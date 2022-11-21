package programmers.level2;

import java.util.HashSet;
import java.util.Set;

public class 영어_끝말잇기 {

    public int[] solution(int n, String[] words) {
        //단어를 차례로 HashSet에 저장한다.
        //이미 동일한 단어가 있으면 탈락
        //이전 단어의 마지막 char를 저장해두고, 다음의 시작 char가 다르면 탈락
        //i / n + 1 : 횟수, i % n + 1 : 번호

        Set<String> set = new HashSet<>(words.length);
        set.add(words[0]);
        char lastChar = words[0].charAt(words[0].length() - 1);

        for(int i = 1; i < words.length; i++) {
            if(set.contains(words[i]) || words[i].charAt(0) != lastChar)
                return new int[]{i % n + 1, i / n + 1};

            set.add(words[i]);
            lastChar = words[i].charAt(words[i].length() - 1);
        }

        return new int[]{0, 0};
    }
}
