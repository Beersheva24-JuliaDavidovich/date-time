package telran.time;

import java.lang.reflect.Array;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalAdjuster;
import java.util.Arrays;

public class PastTemporalDateProximity implements TemporalAdjuster{
//TODO some encapsulation
//array of temporals supporting Day, Month, Year (Dates)
    Temporal[] temporals;
    public PastTemporalDateProximity (Temporal[] temporals) {
        temporals = java.util.Arrays.copyOf(temporals, temporals.length);
        //comments
        for(int i = 0; i < temporals.length; i++) {
            if (LocalDate.from(temporals[i]) > LocalDate.from(temporals[i + 1])) {
                Temporal temp = new Temporal();
                temp = LocalDate.from(temporals[i]);
                LocalDate.from(temporals[i]) = LocalDate.from(temporals[i + 1]);
                LocalDate.from(temporals[i + 1]) = temp;
            } 
    }
    }

    @Override
    public Temporal adjustInto(Temporal temporal) {
        int left = 0;
        int right = temporals.length - 1;
        int middle = (left + right) / 2;
        int compres = 0;
        while (left <= right) {
            compres = temporal.compareTo(ChronoLocalDate other);
            if (compres < 0) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
            middle = (left + right) / 2;
        }
        return right < temporals.length ? temporals[right].from(temporal.plus(1, ChronoUnit.DAYS)) : null;
    }

}
