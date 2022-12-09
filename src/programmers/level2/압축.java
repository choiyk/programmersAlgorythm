package programmers.level2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 압축 {

    public int[] solution(String msg) {
        //사전 : HashMap
        //영어 대문자로 초기화
        //마지막 색인 번호 저장

        //사전에 등록되어 있는 가장 긴 문자열 찾기
        //첫번째 문자가 등록되어 있고, 그 다음 문자를 합친 문자가 사전에 있는지 찾음
        //사전에 없을 때까지 반복
        //찾을 문자열, 그 다음 문자열

        //찾을 문자열의 색인번호 저장
        //다음 문자열을 사전에 마지막 번호+1 로 저장

        List<Integer> answer = new ArrayList<>();
        Map<String, Integer> dictionary = new HashMap<>();
        int index = 0;

        for(int i = 0; i < 26; i++) {
            dictionary.put(Character.toString('A' + i), ++index);
        }

        int before = 0, after = 0;
        String search = null;
        String next;
        while(before < msg.length() && after < msg.length()) {
            next = msg.substring(before, after + 1);

            if(dictionary.containsKey(next)){
                search = next;
                after++;
                continue;
            }
            else {
                answer.add(dictionary.get(search));
                dictionary.put(next, ++index);
                before = after;
            }
        }

        if(before < msg.length()) {
            answer.add(dictionary.get(msg.substring(before)));
        }

        int[] answerArr = new int[answer.size()];

        for(int i = 0; i < answerArr.length; i++) {
            answerArr[i] = answer.get(i);
        }

        return answerArr;
    }
}
