package cinema.framework;

import java.time.LocalDate;
import java.util.UUID;

public class Fixtures {
    public final static LocalDate December_2nd_2020 = LocalDate.of(2020, 12, 2);
    
    public final static UUID Marco = UUID.fromString("99A83F47-32D2-4007-A5B8-87C2F1BFD197"); // Reference to the Customer Marco H.
    public final static UUID Tina = UUID.fromString("BC6BF2B8-A198-4877-980C-E454A4E42628"); // Reference to the Customer Tina F.
    public final static UUID Cinema_1 = UUID.fromString("EC15243D-58D5-470D-922D-730FAAFB1B36"); // Reference to Cinema 1 in the first floor
    public final static UUID Seat_A1 = UUID.fromString("108F0340-C954-44E3-84C2-6CD453351553"); // Reference to the first seat in row A in Cinema 1
    public final static UUID Seat_A2 = UUID.fromString("4E5DAC6B-E898-4653-91C6-941204E64BFC"); // Reference to the second seat in row A in Cinema 1
    public final static UUID Seat_A3 = UUID.fromString("FF87BBFF-6C84-4DD8-A658-9FCE5D94CF1B"); // Reference to the third seat in row A in Cinema 1
    public final static UUID Screening_1 = UUID.fromString("42F573B3-257B-48C3-BC94-7ACC37C5D3F4"); // Reference to the screening of "Avengers End Game" on december the second.}
}
