package programmers.level2;

import java.util.*;

public class 튜플 {

    public int[] solution(String s) {
        //길이가 짧은 튜플부터 순서대로 확인한다.
        //숫자를 hashMap에 넣는다.
        //동일한 숫자가 나오면 값을 하나 증가시킴
        //모인 숫자들을 배열로 만들어 리턴
        //값이 가장 큰 숫자부터 차례로 넣는다.

        Map<Integer, Integer> map = new HashMap<>();

        s = s.replace("{{", "");
        s = s.replace("},{", "v");
        s = s.replace("}}", "");

        String[] tuples = s.split("v");

        for(String tuple : tuples) {
            String[] nums = tuple.split(",");

            for(String n : nums) {
                final int num = Integer.parseInt(n);

                map.put(num, map.getOrDefault(num, 0) + 1);
            }
        }

        int[] answer = new int[map.size()];

        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            final int idx = answer.length - entry.getValue();
            answer[idx] = entry.getKey();
        }

        return answer;
    }
}
