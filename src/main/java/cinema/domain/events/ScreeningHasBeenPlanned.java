package cinema.domain.events;

import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

public class ScreeningHasBeenPlanned implements Event {
    public final UUID screening;
    public final LocalDate date;
    public final UUID cinema;

    public ScreeningHasBeenPlanned(UUID screening, LocalDate date, UUID cinema) {
        this.screening = screening;
        this.date = date;
        this.cinema = cinema;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ScreeningHasBeenPlanned that = (ScreeningHasBeenPlanned) o;
        return Objects.equals(screening, that.screening) &&
            Objects.equals(date, that.date) &&
            Objects.equals(cinema, that.cinema);
    }

    @Override
    public int hashCode() {
        return Objects.hash(screening, date, cinema);
    }
}
