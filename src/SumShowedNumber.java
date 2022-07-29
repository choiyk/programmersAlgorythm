import java.util.Arrays;

public class SumShowedNumber {

    public int solution(int n) {
        return Arrays.stream(String.valueOf(n).split("")).mapToInt(Integer::valueOf).sum();
        //느림
    }

    public int solution2(int n) {
        int answer = 0;
        while(n > 0){
            answer += n % 10;
            n /= 10;
        }
        return answer;
    }

    public static void main(String[] args) {
        int n = 987;
        SumShowedNumber o = new SumShowedNumber();
        System.out.println(o.solution2(n));
    }
}
