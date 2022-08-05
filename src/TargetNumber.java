import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

public class TargetNumber {

    int answer = 0;

    public int solution(int[] numbers, int target) {
        doSomething(0, 0, numbers, target);

        return answer;
    }

    private void doSomething(int depth, int sum, int[] numbers, int target){
        if(depth >= numbers.length){
            if(sum == target) {
                answer++;
            }
            return;
        }

        //부호가 1인 경우 + 부호가 -1인 경우
        doSomething(depth+1, sum + numbers[depth], numbers, target);
        doSomething(depth+1, sum - numbers[depth], numbers, target);
    }

    public static void main(String[] args){
        int[] numbers= {4, 1, 2, 1};
        int target = 4;
        TargetNumber o = new TargetNumber();
        System.out.println(o.solution(numbers, target));
    }
}
