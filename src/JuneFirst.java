import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class JuneFirst {

    public String solution(int a, int b) {
        String[] weeks = {"FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"};
        LocalDate date1 = LocalDate.of(2016, 1, 1);
        LocalDate date2 = LocalDate.of(2016, a, b);

        int days = (int)ChronoUnit.DAYS.between(date1, date2);

        String answer = weeks[days % 7];
        return answer;
    }

    public String solution2(int a, int b) {
        String[] weeks = {"FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"};
        int[] days = {31,29,31,30,31,30,31,31,30,31,30,31};

        int betweenDate = b - 1;
        for(int i=0; i<a-1; i++){
            betweenDate += days[i];
        }

        String answer = weeks[betweenDate % 7];
        return answer;
    }

    public static void main(String[] args) {
        JuneFirst o = new JuneFirst();
        System.out.println(o.solution2(5, 24));
    }
}
