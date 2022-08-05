import java.util.Arrays;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class MoreSpicy {

    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(scoville.length);
        for(int n : scoville){
            queue.add(n);
        }

        int cnt = 0;
        for(int i=0; i<scoville.length - 1; i++){
            int min = queue.poll();
            if(min >= K) break;

            int min2 = queue.poll();

            queue.add(min + (min2 * 2));
            cnt++;
        }

        if(cnt >= scoville.length - 1 && queue.peek() < K) cnt = -1;
        return cnt;
    }

    public static void main(String[] args) {
        int[] scoville = {1, 2, 3, 9, 10, 12};
        int K = 10000;
        MoreSpicy o = new MoreSpicy();
        System.out.println(o.solution(scoville, K));
    }
}
