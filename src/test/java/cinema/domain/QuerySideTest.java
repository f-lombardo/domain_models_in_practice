package cinema.domain;

import cinema.framework.TestBase;
import org.junit.jupiter.api.Test;

import static cinema.framework.SemanticHelper.*;
import static cinema.framework.Fixtures.*;

public class QuerySideTest extends TestBase {

    @Test
    public void aFreeSeatCanBeReserved() {
        given(
            screeningHasBeenPlanned(Screening_1, December_2nd_2020, Cinema_1),
            seatHasBeenReserved(Screening_1, Seat_A1, Marco),
            seatHasBeenReserved(Screening_1, Seat_A2, Marco));

        whenQuery(
            myReservations(Marco));

        thenExpectResponse(
            reservations(
                reservation(Screening_1, Seat_A1),
                reservation(Screening_1, Seat_A2)));
    }
}
