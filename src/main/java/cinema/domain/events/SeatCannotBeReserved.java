package cinema.domain.events;

import java.util.Objects;
import java.util.UUID;

public class SeatCannotBeReserved implements Event {
    public final UUID screening;
    public final UUID seat;

    public SeatCannotBeReserved(UUID screening, UUID seat) {
        this.screening = screening;
        this.seat = seat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SeatCannotBeReserved that = (SeatCannotBeReserved) o;
        return Objects.equals(screening, that.screening) &&
            Objects.equals(seat, that.seat);
    }

    @Override
    public int hashCode() {
        return Objects.hash(screening, seat);
    }
}
