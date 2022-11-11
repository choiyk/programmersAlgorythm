package leetcode.two;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        //시작점 포인터 start,
        //HashMap에 character를 저장
        //동일한 character가 나올때까지 이동하는 포인터 end
        //이동하며 길이 계산
        //동일한 character가 나오면 최대 길이와 비교해서 더 큰 길이가 최대 길이가 된다.
        //HashMap 초기화 후 반복

        char[] chars = s.toCharArray();
        Map<Character, Integer> map;
        int maxLength = 0;

        for(int i = 0; i < chars.length; i++) {
            map = new HashMap<>();
            map.put(chars[i], 1);

            int length = 1;

            for(int j = i + 1; j < chars.length; j++) {
                if(map.containsKey(chars[j]))
                    break;

                map.put(chars[j], 1);
                length++;
            }

            maxLength = Math.max(maxLength, length);
        }

        return maxLength;
    }

    public int lengthOfLongestSubstring2(String s) {
        //시작점 포인터 start,
        //동일한 character가 나올때까지 이동하는 포인터 end
        //HashMap에 character의 가장 마지막 index를 저장한다.
        //동일한 character가 나오면 가장 마지막 index의 다음으로 start를 이동
        //길이는 end - start

        char[] chars = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        int maxLength = 0;

        int start = 0;
        int end = 0;

        while(end < chars.length) {
            if(map.containsKey(chars[end]) && map.get(chars[end]) >= start)
                start = map.get(chars[end]) + 1;

            map.put(chars[end], end);

            maxLength = Math.max(maxLength, end - start + 1);

            end++;
        }

        return maxLength;
    }

}
