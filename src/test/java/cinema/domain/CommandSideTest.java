package cinema.domain;

import cinema.framework.TestBase;
import org.junit.jupiter.api.Test;

import static cinema.framework.Fixtures.*;
import static cinema.framework.SemanticHelper.*;

public class CommandSideTest extends TestBase {

    @Test
    public void aFreeSeatCanBeReserved() {
        given(
            screeningHasBeenPlanned(Screening_1, December_2nd_2020, Cinema_1),
            seatHasBeenReserved(Screening_1, Seat_A1, Tina));

        when(
            reserveSeat(Screening_1, Seat_A2, Marco));

        thenExpect(
            seatHasBeenReserved(Screening_1, Seat_A2, Marco));
    }

    @Test
    public void An_already_reserved_seat_cannot_be_reserved() {
        given(
            screeningHasBeenPlanned(Screening_1, December_2nd_2020, Cinema_1),
            seatHasBeenReserved(Screening_1, Seat_A1, Tina) );

        when(
            reserveSeat(Screening_1, Seat_A1, Marco));

        thenExpect(
            seatCannotBeReserved(Screening_1, Seat_A1));
    }

}
