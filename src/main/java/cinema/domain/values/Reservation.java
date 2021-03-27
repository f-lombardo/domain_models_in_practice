package cinema.domain.values;

import java.util.Objects;
import java.util.UUID;

public class Reservation {
    public final UUID screening;
    public final UUID seat;

    public Reservation(UUID screening, UUID seat) {
        this.screening = screening;
        this.seat = seat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reservation that = (Reservation) o;
        return Objects.equals(screening, that.screening) &&
            Objects.equals(seat, that.seat);
    }

    @Override
    public int hashCode() {
        return Objects.hash(screening, seat);
    }
}
