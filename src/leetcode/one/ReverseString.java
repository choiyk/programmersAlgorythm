package leetcode.one;

public class ReverseString {

    public void reverseString(char[] s) {
        //O(N) 어떻게 O(1)이 나오지?
        int startIdx = 0;
        int endIdx = s.length - 1;

        while(startIdx < endIdx) {
            char temp = s[startIdx];
            s[startIdx] = s[endIdx];
            s[endIdx] = temp;

            startIdx++;
            endIdx--;
        }
    }

}
