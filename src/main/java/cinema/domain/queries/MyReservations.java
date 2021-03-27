package cinema.domain.queries;

import java.util.UUID;

public class MyReservations implements Query {
    public final UUID customer;

    public MyReservations(UUID customer) {
        this.customer = customer;
    }
}
