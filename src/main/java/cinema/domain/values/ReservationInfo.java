package cinema.domain.values;

import java.util.List;
import java.util.Objects;

public class ReservationInfo {
    public final List<Reservation> reservations;

    public ReservationInfo(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReservationInfo that = (ReservationInfo) o;
        return Objects.equals(reservations, that.reservations);
    }

    @Override
    public int hashCode() {
        return Objects.hash(reservations);
    }
}
