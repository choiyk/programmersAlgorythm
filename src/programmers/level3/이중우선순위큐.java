package programmers.level3;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class 이중우선순위큐 {

    public int[] solution(String[] operations) {
        //최대값을 반환하는 큐, 최소값을 반환하는 큐
        //삽입 시 두 큐에 모두 삽입
        //삭제 시 두 큐에서 모두 삭제

        Queue<Integer> ascending = new PriorityQueue<>();
        Queue<Integer> descending = new PriorityQueue<>(Collections.reverseOrder());

        for(String operation : operations) {
            final String[] arr = operation.split(" ");
            final int num = Integer.valueOf(arr[1]);

            if (arr[0].equals("I")) {
                ascending.add(num);
                descending.add(num);
            }
            else {
                if (ascending.isEmpty())
                    continue;

                if(num == -1) {
                    final int min = ascending.poll();
                    descending.remove(min);
                }
                else {
                    final int max = descending.poll();
                    ascending.remove(max);
                }
            }
        }

        if (ascending.isEmpty())
            return new int[]{0, 0};

        return new int[]{descending.poll(), ascending.poll()};
    }
}
