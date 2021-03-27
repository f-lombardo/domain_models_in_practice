package cinema.domain.events;

import java.util.UUID;

public class SeatCannotReserved {
    public final UUID screening;
    public final UUID seat;
    public final UUID customer;

    public SeatCannotReserved(UUID screening, UUID seat, UUID customer) {
        this.screening = screening;
        this.seat = seat;
        this.customer = customer;
    }
}
