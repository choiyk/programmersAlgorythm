package javaCodingInterview.Chapter8;

import java.util.LinkedList;
import java.util.Queue;

public class Josephus {

    public int solution(int n, int k) {
        Queue<Integer> queue = new LinkedList<>();
        for(int i=1; i<=n; i++){
            queue.offer(i);
        }

        while(queue.size() > 1){
            for(int i=1; i<=k; i++){
                int temp = queue.poll();
                if(i < k)
                    queue.offer(temp);
            }
        }

        return queue.poll();
    }

}
