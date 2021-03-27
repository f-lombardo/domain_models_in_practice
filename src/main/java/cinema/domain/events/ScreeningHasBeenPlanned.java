package cinema.domain.events;

import java.util.Date;
import java.util.UUID;

public class SeatHasBeenPlanned implements Event {
    public final UUID screening;
    public final Date date;
    public final UUID cinema;

    public SeatHasBeenPlanned(UUID screening, Date date, UUID cinema) {
        this.screening = screening;
        this.date = date;
        this.cinema = cinema;
    }
}
