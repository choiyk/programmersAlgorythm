package programmers.level2;

import java.util.HashMap;
import java.util.Map;

public class 위장 {

    public int solution(String[][] clothes) {
        //모든 의상을 하나씩만 착용한 경우: clothes.length
        //종류별로 조합할 수 있는 경우의 수 : 각 종류별 의상 갯수 + 1(선택 안하는 경우 포함)의 곱 - 1(모두 선택 안한 경우)
        //종류가 하나뿐이라면 해당 없음

        Map<String, Integer> map = new HashMap<>();

        for(int i = 0; i < clothes.length; i++) {
            final String name = clothes[i][1];
            map.put(name, map.getOrDefault(name, 1) + 1);
        }

        if(map.size() <= 1)
            return clothes.length;

        int answer = 1;
        for(int cnt : map.values()) {
            answer *= cnt;
        }

        return answer - 1;
    }
}
