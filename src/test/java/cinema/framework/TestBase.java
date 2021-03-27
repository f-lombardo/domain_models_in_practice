package cinema.framework;

import cinema.domain.commands.Command;
import cinema.domain.events.Event;
import cinema.domain.queries.Query;
import cinema.domain.readmodels.CustomerReservations;
import cinema.infrastructure.CommandHandler;
import cinema.infrastructure.QueryHandler;
import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public abstract class TestBase {
        private List<Event> history;
        private List<Event> publishedEvents;

        private Object queriedResponse;
        private CustomerReservations readmodel;

        @BeforeEach
        public void setup() {
            history = new ArrayList<>();
            publishedEvents = new ArrayList<>();
            queriedResponse = null;
        }


        protected void given(Event... events) {
            history = Arrays.asList(events);
            readmodel = new CustomerReservations(history);
        }

        protected void when(Command command) {
            CommandHandler handler = new CommandHandler(history, event -> {
                    publishedEvents.add(event);
                    readmodel.project(event); // This is a simplified version of the observer pattern
            });
            handler.handle(command);
        }

        protected void whenQuery(Query query) {
            QueryHandler handler = new QueryHandler(readmodel, history, r -> {
                queriedResponse = r;
            });
            handler.handle(query);
        }

        protected void thenExpect(Event... expectedEvents) {
            assertArrayEquals(publishedEvents.toArray(), expectedEvents);
        }

        protected void thenExpectResponse(Object expectedResponse) {
            assertEquals(queriedResponse, expectedResponse);
        }
}
