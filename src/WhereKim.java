import java.util.Arrays;

public class WhereKim {

    public String solution(String[] seoul) {
        int answer = -1;
        for(int i=0; i<seoul.length; i++){
            if(seoul[i].equals("Kim")) {answer = i; break;}
        }
        return "김서방은 " + answer + "에 있다";
    }

    public String solution2(String[] seoul) {
        int answer = Arrays.asList(seoul).indexOf("Kim");
        return "김서방은 " + answer + "에 있다";
    }

    public static void main(String[] args) {
        String[] seoul = new String[]{"Jane", "Kim"};
        WhereKim o = new WhereKim();
        System.out.println(o.solution(seoul));
    }
}
