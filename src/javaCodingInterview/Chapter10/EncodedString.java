package javaCodingInterview.Chapter10;

public class EncodedString {

    public char[] solution(String s) {
        s = s.replaceAll(" ", "%20");
        char[] answer = s.toCharArray();
        return answer;
    }
}
