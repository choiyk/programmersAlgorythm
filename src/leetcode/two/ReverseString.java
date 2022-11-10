package leetcode.two;

public class ReverseString {

    public void reverseString(char[] s) {
        //양쪽에서부터 swap

        int start = 0;
        int end = s.length - 1;

        while(start < end) {
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;

            start++;
            end--;
        }
    }

}
