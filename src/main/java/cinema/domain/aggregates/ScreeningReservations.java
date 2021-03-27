package cinema.domain.aggregates;

import cinema.domain.events.Event;
import cinema.domain.events.SeatCannotBeReserved;
import cinema.domain.events.SeatHasBeenReserved;

import java.util.UUID;
import java.util.function.Consumer;

// The Aggregate that protects the invariants around reserving seats
// Ensures transactional consistent and domain-correct behaviour for all involved classes
// In a real life implementation you wouldn't store this in an Aggregate.cs,
// but put it in domain specific files and folders.
public class ScreeningReservations {
    private final Consumer<Event> publish;
    private final ScreeningReservationsState state;

    public ScreeningReservations(Consumer<Event> publish, ScreeningReservationsState state) {
        this.publish = publish;
        this.state = state;
    }

    public void reserve(UUID screening, UUID seat, UUID customer) {
        if (seatAlreadyReserved(screening, seat)) {
            publish.accept(new SeatCannotBeReserved(screening, seat));
        } else {
            publish.accept(new SeatHasBeenReserved(screening, seat, customer));
        }
    }

    private boolean seatAlreadyReserved(UUID screening, UUID seat){
        return state.screenings.get(screening).contains(seat);
    }
}
