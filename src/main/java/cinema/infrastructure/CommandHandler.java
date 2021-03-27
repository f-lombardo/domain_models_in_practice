package cinema.infrastructure;

import cinema.domain.aggregates.ScreeningReservations;
import cinema.domain.aggregates.ScreeningReservationsState;
import cinema.domain.commands.Command;
import cinema.domain.commands.ReserveSeat;
import cinema.domain.events.Event;

import java.util.function.Consumer;

// A very simple commandhandler that is not yet optimised for real life usage.
// Use it as a starting point. Depending on your needs you could add:
//   Real routing, pluggable logging/auth/etc.,
//   Chain of responsibility pattern through parent class... or the opposite
//   go all in on functional programming.
// Whatever you do, the basic pattern of separating infrastructure from domain
// starts here
public class CommandHandler {
    private final Iterable<Event> history;
    private final Consumer<Event> publish;

    public CommandHandler(Iterable<Event> history, Consumer<Event> publish) {
        this.history = history;
        this.publish = publish;
    }

    public void handle(Command command) {
        if (command instanceof ReserveSeat) {
            ReserveSeat cmd = (ReserveSeat) command;
            ScreeningReservationsState state = new ScreeningReservationsState(history);
            ScreeningReservations screeningReservations = new ScreeningReservations(publish, state);
            screeningReservations.reserve(cmd.screening, cmd.seat, cmd.customer);
        }
    }
}
