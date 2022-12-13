package programmers.level2;

import java.util.LinkedList;
import java.util.Queue;

public class n진수_게임 {

    public String solution(int n, int t, int m, int p) {
        //0부터 숫자를 n진법으로 변환하여 차례대로 큐에 넣는다.
        //튜브의 순서에 맞는 숫자를 리스트에 담는다.
        //리스트가 t개일때까지 반복

        StringBuilder answer = new StringBuilder();
        Queue<String> queue = new LinkedList<>();
        queue.add("0");
        queue.add("1");

        int num = 2;
        int turn = 1;

        while(answer.length() < t) {
            if(queue.isEmpty()) {
                String s = Integer.toString(num, n);

                for(int i = 0; i < s.length(); i++) {
                    if(Character.isAlphabetic(s.charAt(i)))
                        queue.add(Character.toString(s.charAt(i)).toUpperCase());
                    else queue.add(Character.toString(s.charAt(i)));
                }

                num++;
            }

            String next = queue.poll();

            if(turn == p)
                answer.append(next);

            turn++;
            if(turn > m)
                turn = turn % m;
        }

        return answer.toString();
    }
}
