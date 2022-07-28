import java.util.Locale;

public class CountPY {

    boolean solution(String s) {
        int countP = 0;
        int countY = 0;
        s = s.toUpperCase();
        for(int i = 0; i<s.length(); i++){
            if(s.charAt(i) == 'P') countP++;
            else if(s.charAt(i) == 'Y') countY++;
        }
        return countP == countY;
    }

    boolean solution2(String s) {
        s = s.toUpperCase();
        return s.chars().filter(i -> i == 'P').count() == s.chars().filter(i -> i == 'Y').count();
    }

    public static void main(String[] args) {
        String s = "Pyy";
        CountPY o = new CountPY();
        System.out.println(o.solution(s));
    }
}
