package leetcode.two;

public class ReverseWordsInAString3 {

    public String reverseWords(String s) {
        //공백 기준으로 문자열 나누기
        //각 문자열을 양쪽에서부터 swap

        String[] arr = s.split(" ");
        StringBuilder sb = new StringBuilder();

        for(String target : arr) {
            final char[] chars = target.toCharArray();
            int start = 0;
            int end = chars.length - 1;

            while(start < end) {
                char temp = chars[start];
                chars[start] = chars[end];
                chars[end] = temp;

                start++;
                end--;
            }

            sb.append(new String(chars) + " ");
        }

        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

}
