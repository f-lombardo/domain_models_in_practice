package cinema.framework;

import cinema.domain.commands.ReserveSeat;
import cinema.domain.events.ScreeningHasBeenPlanned;
import cinema.domain.events.SeatCannotBeReserved;
import cinema.domain.events.SeatHasBeenReserved;
import cinema.domain.queries.MyReservations;
import cinema.domain.values.Reservation;
import cinema.domain.values.ReservationInfo;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.UUID;

public class SemanticHelper {
    public static ReserveSeat reserveSeat(UUID screening, UUID seat, UUID customer) { return new ReserveSeat(screening, seat, customer);};
    public static SeatHasBeenReserved seatHasBeenReserved(UUID screening, UUID seat, UUID customer) { return new SeatHasBeenReserved(screening, seat, customer);};
    public static ScreeningHasBeenPlanned screeningHasBeenPlanned(UUID screening, LocalDate date, UUID cinema) { return new ScreeningHasBeenPlanned(screening, date, cinema);};
    public static SeatCannotBeReserved seatCannotBeReserved(UUID screening, UUID seat) { return new SeatCannotBeReserved(screening, seat);};
    public static MyReservations myReservations(UUID customer) { return new MyReservations(customer);};
    public static ReservationInfo reservations(Reservation... reservations) { return new ReservationInfo(Arrays.asList(reservations));};
    public static Reservation reservation(UUID screening, UUID seat) { return new Reservation(screening, seat);};
}
