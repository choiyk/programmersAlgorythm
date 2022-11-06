package leetcode.one;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;

public class LetterCasePermutation {

    public List<String> letterCasePermutation(String s) {
        List<String> answer = new ArrayList<>(); //최종 결과를 담을 list
        char[] changed = new char[s.length()];
        char[] chars = s.toCharArray();

        permute(chars, answer, changed, 0);

        return answer;
    }

    private void permute(char[] s, List<String> answer, char[] changed, int idx) {
        //경우의 수는 2가지 : 바꾸거나 안바꾸거나
        //종료 : idx가 s.length일때
        if(idx >= s.length) {
            answer.add(new String(changed));
            return;
        }

        //s[idx]가 숫자면 넘어감
        if(s[idx] >= '0' && s[idx] <= '9') {
            changed[idx] = s[idx];
            permute(s, answer, changed, idx + 1);
        }
        else {
            //idx 선택, 바꾸는 경우, 안바꾸는 경우
            //안바꿈
            changed[idx] = s[idx];
            permute(s, answer, changed, idx + 1);

            //바꿈
            if(s[idx] >= 'A' && s[idx] <= 'Z')
                changed[idx] = (char)(s[idx] + 32);
            else
                changed[idx] = (char)(s[idx] - 32);

            permute(s, answer, changed, idx + 1);
        }
    }

}
