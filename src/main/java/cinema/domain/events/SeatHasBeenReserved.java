package cinema.domain.events;

import java.util.Objects;
import java.util.UUID;

public class SeatHasBeenReserved implements Event {
    public final UUID screening;
    public final UUID seat;
    public final UUID customer;

    public SeatHasBeenReserved(UUID screening, UUID seat, UUID customer) {
        this.screening = screening;
        this.seat = seat;
        this.customer = customer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SeatHasBeenReserved that = (SeatHasBeenReserved) o;
        return Objects.equals(screening, that.screening) &&
            Objects.equals(seat, that.seat) &&
            Objects.equals(customer, that.customer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(screening, seat, customer);
    }
}
