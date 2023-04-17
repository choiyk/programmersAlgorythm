package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 요세푸스_문제_0 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] input = new int[2];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < 2; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }

        br.close();

        StringBuilder sb = new StringBuilder();
        sb.append("<");
        Queue<Integer> queue = new LinkedList<>();

        for(int i = 1; i <= input[0]; i++) {
            queue.add(i);
        }

        int cnt = 1;
        while (!queue.isEmpty()) {
            if(cnt % input[1] == 0) {
                sb.append(queue.poll() + ", ");
            }
            else {
                queue.add(queue.poll());
            }

            cnt++;
        }

        sb.delete(sb.length()-2, sb.length());
        sb.append(">");

        System.out.println(sb.toString());
    }
}
