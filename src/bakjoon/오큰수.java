package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class 오큰수 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] target = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < n; i++) {
            target[i] = Integer.parseInt(st.nextToken());
        }

        br.close();

        List<Integer> answer = new ArrayList<>(n);
        Stack<Integer> stack = new Stack<>();

        //가장 마지막 수의 오큰수는 항상 -1
        answer.add(-1);
        stack.push(target[n-1]);

        for(int i = n-2; i >= 0; i--) {
            int last = stack.peek();

            while(!stack.isEmpty() && (last = stack.peek()) <= target[i]) {
                stack.pop();
            }

            if(stack.isEmpty()) {
                answer.add(-1);
            }
            else {
                answer.add(last);
            }

            stack.push(target[i]);
        }

        StringBuilder sb = new StringBuilder();
        for(int i = n-1; i >= 1; i--) {
            sb.append(answer.get(i));
            sb.append(" ");
        }
        sb.append(answer.get(0));

        System.out.println(sb.toString());
    }
}
