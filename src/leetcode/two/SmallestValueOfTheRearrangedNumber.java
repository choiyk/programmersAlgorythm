package leetcode.two;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class SmallestValueOfTheRearrangedNumber {

    public long smallestNumber(long num) {
        //양수면 최소값, 음수면 최대값

        //양수일때
        //오름차순으로 정렬
        //0을 제외한 그 다음 작은 수가 제일 먼저 오고,
        //0으로 채우고,
        //작은 순서대로 채우기

        //음수일때
        //내림차순으로 정렬

        if(num == 0)
            return 0;

        char[] chars = String.valueOf(num).toCharArray();
        Queue<Character> heap;

        if(num < 0)
            heap = new PriorityQueue<>((a, b) -> b - a);
        else heap = new PriorityQueue<>();

        for(int i = num < 0 ? 1 : 0; i < chars.length; i++) {
            heap.add(chars[i]);
        }

        if(num < 0) {
            for(int i = 1; i < chars.length; i++) {
                chars[i] = heap.poll();
            }
        }
        else {
            int zero = 0;

            while(heap.peek() == '0') {
                heap.poll();
                zero++;
            }

            chars[0] = heap.poll();

            int i = 1;
            for(; i <= zero; i++) {
                chars[i] = '0';
            }

            for(; i < chars.length; i++) {
                chars[i] = heap.poll();
            }
        }

        return Long.parseLong(new String(chars));
    }

    public long smallestNumber2(long num) {
        //숫자 정렬
        //음수면 큰 수부터 뽑음
        //양수면 0이 아닌 그 다음 작은 수를 찾아 맨 앞의 0과 바꿈

        char[] chars = String.valueOf(Math.abs(num)).toCharArray();
        Arrays.sort(chars);

        if(num < 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("-");

            for(int i = chars.length - 1; i >= 0; i--) {
                sb.append(chars[i]);
            }

            return Long.parseLong(sb.toString());
        }
        else {
            int i = 0;
            for(; i < chars.length; i++) {
                if(chars[i] != '0')
                    break;
            }

            char temp = chars[0];
            chars[0] = chars[i];
            chars[i] = temp;

            return Long.parseLong(new String(chars));
        }
    }

}
