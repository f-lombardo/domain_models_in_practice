package cinema.domain.readmodels;

import cinema.domain.events.Event;
import cinema.domain.events.SeatHasBeenReserved;
import cinema.domain.values.Reservation;

import java.util.*;

public class CustomerReservations {
    private final Map<UUID, List<Reservation>> reservations = new HashMap<>();

    public CustomerReservations(Iterable<Event> history) {
        for (Event event: history) {
            apply(event);
        }
    }

    public void project(Event e) {
        apply(e);
    }

    private void apply(Event e){
        if (e instanceof SeatHasBeenReserved) {
            applyEvent((SeatHasBeenReserved)e);
        }
    }

    private void applyEvent(SeatHasBeenReserved e) {
        if (!reservations.containsKey(e.customer)) {
            reservations.put(e.customer, new ArrayList<Reservation>());
        }
        reservations.get(e.customer).add(new Reservation(e.screening, e.seat));
    }

    public List<Reservation> reservationsFor(UUID customer) {
        return reservations.get(customer);
    }
}
