package leetcode.one;

import java.util.Arrays;

public class ReverseWordsInAString3 {

    public String reverseWords(String s) {
        //공백 기준으로 문자열 나누기
        String[] words = s.split(" ");

        //역순으로 문자열 넣기
        StringBuilder sb = new StringBuilder();

        for(String word : words) {
            reverse(word, sb);
            sb.append(" ");
        }

        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    public void reverse(String s, StringBuilder sb) {
        for(int i = s.length() - 1; i >= 0; i--) {
            sb.append(s.charAt(i));
        }
    }

    public String reverseWords2(String s) {
        char[] charArr = s.toCharArray();
        int startIdx = 0;

        for(int i = 0; i <= charArr.length; i++) {
            if(i == charArr.length || charArr[i] == ' ') {
                int endIdx = i - 1;

                //단어 역순 정렬
                while(startIdx < endIdx) {
                    char temp = charArr[startIdx];
                    charArr[startIdx] = charArr[endIdx];
                    charArr[endIdx] = temp;

                    startIdx++;
                    endIdx--;
                }

                startIdx = i + 1;
            }
        }

        /*StringBuilder sb = new StringBuilder();
        for(char c : charArr) {
            sb.append(c);
        }

        return sb.toString();*/

        return new String(charArr);
    }

}
