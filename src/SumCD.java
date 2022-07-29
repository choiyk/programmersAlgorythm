import java.util.ArrayList;

public class SumCD {

    public int solution(int n) {
        int answer = n;
        for(int i = 1; i <= n/2; i++){
            if(n % i == 0) answer += i;
        }
        return answer;
    }

    public static void main(String[] args) {
        int n = 12;
        SumCD o = new SumCD();
        System.out.println(o.solution(n));
    }
}
