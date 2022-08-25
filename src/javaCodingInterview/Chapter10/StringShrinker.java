package javaCodingInterview.Chapter10;

public class StringShrinker {

    public String solution(String s) {
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();

        char currentChar = chars[0];
        int cnt = 1;
        for(int i=1; i<chars.length; i++) {
            if(currentChar != chars[i]) {
                if(currentChar != ' ')
                    sb.append(currentChar).append(cnt);
                if(chars[i] == ' ') sb.append(chars[i]);
                currentChar = chars[i];
                cnt = 1;
            }
            else {
                if(chars[i] == ' ') sb.append(chars[i]);
                cnt++;
            }
        }

        sb.append(currentChar).append(cnt);

        return s.length() > sb.length() ? sb.toString() : s;
    }
}
