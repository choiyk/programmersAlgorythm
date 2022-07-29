import java.util.ArrayList;
import java.util.Arrays;

public class InvertNumber {

    public int[] solution(long n) {
        int size = String.valueOf(n).length();
        int[] answer = new int[size];
        for(int i = 0; i < size; i++) {
            answer[i] = (int)(n % 10);
            n /= 10.0;
        }
        return answer;
    }

    public int[] solution2(long n) {
        //그냥 마음에 들어서..
        return new StringBuilder().append(n).reverse().chars().map(Character::getNumericValue).toArray();
    }

    public static void main(String[] args) {
        long n = 12345;
        InvertNumber o = new InvertNumber();
        System.out.println(Arrays.toString(o.solution(n)));
    }
}
