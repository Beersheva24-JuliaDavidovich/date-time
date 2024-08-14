package telran.time;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;
import java.util.Locale;

import org.junit.jupiter.api.Test;
public class DateTimeTest {
    @Test
    void localDatetest() {
        LocalDate current = LocalDate.now();
        LocalDateTime currentTime = LocalDateTime.now();
        ZonedDateTime currentZonedDateTime = ZonedDateTime.now();
        Instant currentInstant = Instant.now();
        LocalTime currentLocalTime = LocalTime.now();
        System.out.printf("Current date  is %s in ISO format \n", current);
        System.out.printf("Current date & time is %s in ISO format \n", currentTime);
        System.out.printf("Current zoned date & time is %s in ISO format \n", currentZonedDateTime);
        System.out.printf("Current Instant is %s in ISO format \n", currentInstant);
        System.out.printf("Current local time is %s in ISO format \n", currentLocalTime);
        System.out.printf("Current date  is %s in dd/mm/yyyy \n", current.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        System.out.printf("Current date  is %s in dd/mm/yyyy \n", current.format(DateTimeFormatter.ofPattern("dd/MMM/yyyy")));
        System.out.printf("Current date  is %s in dd/mm/yyyy \n", current.format(DateTimeFormatter.ofPattern("dd/MM/yyyy", Locale.forLanguageTag("hebrew"))));
    }
    @Test
    void nextFriday13Test() {
        LocalDate current = LocalDate.of(2024,8,11);
        LocalDate expected = LocalDate.of(2024,9, 13);
        TemporalAdjuster adjuster = new NextFriday13();
        assertEquals(expected, current.with(adjuster));
        assertThrows(RuntimeException.class, () -> LocalTime.now().with(adjuster));
        
    }
    @Test
    void pastTemporalDateProximityTest() {
        LocalDate current1 = LocalDate.of(2024,8,11);
        LocalDate current2 = LocalDate.of(2025,12,11);
        LocalDate current3 = LocalDate.of(2020,9,15);
        LocalDate current4 = LocalDate.of(2004,12,01);
        LocalDate current5 = LocalDate.of(2017,5,5);
        LocalDate current6 = LocalDate.of(1991,5,2);
        Temporal [] temporals = {current1, current2, current3, current4, current5, current6};
        LocalDate localDate = LocalDate.of(2024, 5, 2);
        
    }
}
