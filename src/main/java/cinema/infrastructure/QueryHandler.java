package cinema.infrastructure;

import cinema.domain.events.Event;
import cinema.domain.queries.MyReservations;
import cinema.domain.queries.Query;
import cinema.domain.readmodels.CustomerReservations;
import cinema.domain.values.ReservationInfo;

import java.util.List;
import java.util.function.Consumer;

// This Queryhandler instantiates all readmodels only once, and never updates them live
public class QueryHandler {
    private final  CustomerReservations readmodel;
    public  final List<Event> history;
    public  final Consumer<Object> respond;

    public QueryHandler(CustomerReservations readmodel, List<Event> history, Consumer<Object> respond) {
        this.readmodel = readmodel;  // For this demo we just inject one readmodel. In production you'd want to register all readmodels in here.
        this.history = history;
        this.respond = respond;
    }

    public void handle(Query query) {
        if (query instanceof MyReservations) {
            MyReservations q = (MyReservations) query;
            respond.accept(new ReservationInfo(readmodel.reservations.get(q.customer)));
            // Did I just forget to check if the customer actually exist?
            // Well, there would never be a query with an illegal customer, right? :D:D:D
        }
    }
}
