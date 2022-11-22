package programmers.level2;

import java.util.*;

public class N개의_최소공배수 {

    public int solution(int[] arr) {
        //a * b = 최대공약수 * 최소공배수
        //최대공약수 =  GCD(a, b) = GCD(b, a%b), GCD(a, 0) = a
        //0번과 1번의 최소공배수를 구하고
        //구해진 값과 2번의 최소공배수를 구한다.

        Stack<Integer> stack = new Stack<>();

        for(int n : arr) {
            stack.push(n);
        }

        while(stack.size() > 1) {
            int a = stack.pop();
            int b = stack.pop();

            int gcd = GCD(a, b);
            int lcm = a * b / gcd;

            stack.push(lcm);
        }

        return stack.pop();
    }

    private int GCD(int a, int b) {
        if(b == 0)
            return a;

        return GCD(b, a % b);
    }
}
