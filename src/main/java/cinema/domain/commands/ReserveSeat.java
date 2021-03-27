package cinema.domain.commands;

import java.util.UUID;

public class ReserveSeat implements Command {
    public final UUID screening;
    public final UUID seat;
    public final UUID customer;

    public ReserveSeat(UUID screening, UUID seat, UUID customer) {
        this.screening = screening;
        this.seat = seat;
        this.customer = customer;
    }
}
