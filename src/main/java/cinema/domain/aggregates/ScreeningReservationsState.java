package cinema.domain.aggregates;

import cinema.domain.events.Event;
import cinema.domain.events.ScreeningHasBeenPlanned;
import cinema.domain.events.SeatHasBeenReserved;

import java.util.*;

/*
 The Aggregate that protects the invariants around reserving seats
 Ensures transactional consistent and domain-correct behaviour for all involved classes
*/
public class ScreeningReservationState {
    public final Map<UUID, List<UUID>> screenings = new HashMap();

    public ScreeningReservationState(List<Event> events) {
        for (Event event: events) {
            if (event instanceof ScreeningHasBeenPlanned) {
                apply((ScreeningHasBeenPlanned) event);
            }
            if (event instanceof SeatHasBeenReserved) {
                apply((SeatHasBeenReserved) event);
            }
        }
    }

    private void apply(ScreeningHasBeenPlanned event) {
        screenings.put(event.screening, new ArrayList<UUID>());
    }

    private void apply(SeatHasBeenReserved event) {
        screenings.get(event.screening).add(event.seat);
    }

}
