package programmers.level2;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class 구명보트 {

    public int solution(int[] people, int limit) {
        //사람들의 무게를 정렬
        //가장 가벼운 무게와 가장 무거운 무게 비교
        //limit을 초과한다면 가장 무거운 무게는 혼자 타야 함 -> pop(), res++
        //limit을 초과하지 않는다면 두 무게 pop(), res++
        //덱이 빌때까지 반복

        Arrays.sort(people);

        Deque<Integer> deque = new ArrayDeque<>();
        int answer = 0;

        for(int weight : people) {
            deque.add(weight);
        }

        while(!deque.isEmpty()) {
            int weight = deque.peekFirst() + deque.peekLast();

            if(weight > limit) {
                deque.pollLast();
                answer++;
            }
            else {
                deque.pollFirst();
                deque.pollLast();
                answer++;
            }
        }

        return answer;
    }

}
