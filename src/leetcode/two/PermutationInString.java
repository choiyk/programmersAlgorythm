package leetcode.two;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PermutationInString {

    public boolean checkInclusion(String s1, String s2) {
        //s1의 hashMap을 만들고
        //s2에서 s1에 포함된 charcter가 나오면
        //연속해서 hashMap과 동일하다면 true
        //아니면 false

        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        Map<Character, Integer> map1 = new HashMap<>();

        for(char c : chars1) {
            map1.put(c, map1.getOrDefault(c, 0) + 1);
        }

        for(int i = 0; i <= chars2.length - chars1.length; i++) {
            if(map1.containsKey(chars2[i])) {
                boolean res = checkPermutation(chars2, i, i + chars1.length - 1, map1);

                if(res)
                    return true;
            }
        }

        return false;
    }

    private boolean checkPermutation(char[] chars, int start, int end, Map<Character, Integer> map) {
        Map<Character, Integer> copyMap = new HashMap<>(map);

        for(; start <= end; start++) {
            final int cnt = copyMap.getOrDefault(chars[start], 0);

            if(cnt <= 0)
                return false;

            copyMap.put(chars[start], cnt - 1);
        }

        return true;
    }

    public boolean checkInclusion2(String s1, String s2) {
        //문자열을 각각 sorting해서 비교함
        final char[] chars = s1.toCharArray();
        Arrays.sort(chars);

        final String sortedS1 = new String(chars);

        for(int i = 0; i <= s2.length() - s1.length(); i++) {
            final String substring = s2.substring(i, i + s1.length());

            if(checkBySorting(sortedS1, substring))
                return true;
        }

        return false;
    }

    private boolean checkBySorting(String s1, String s2) {
        final char[] chars = s2.toCharArray();
        Arrays.sort(chars);

        final String sortedS2 = new String(chars);

        return s1.equals(sortedS2);
    }

}
