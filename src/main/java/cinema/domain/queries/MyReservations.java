package cinema.domain.queries;

import java.util.UUID;

public class MyReservation implements Query {
    public final UUID customer;

    public MyReservation(UUID customer) {
        this.customer = customer;
    }
}
