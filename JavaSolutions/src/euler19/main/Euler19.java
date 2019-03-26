package euler19.main;
import java.time.*;

public class Euler19 {

    public static void main(String[] args) {
        LocalDate date = LocalDate.of(1901, 1, 1);
        int numSundays = 0;
        do {
            if(date.getDayOfWeek() == DayOfWeek.SUNDAY && date.getDayOfMonth() == 1) {
                numSundays++;
            }
            date = date.plusDays(1);
            System.out.println(date.toString());
        } while(date.getYear() < 2001);

        System.out.println(numSundays);
    }
}