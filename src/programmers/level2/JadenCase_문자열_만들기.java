package programmers.level2;

public class JadenCase_문자열_만들기 {

    public String solution(String s) {
        char[] chars = s.toCharArray();

        //첫번째 문자 대문자로 변경
        if(Character.isAlphabetic(chars[0]))
            chars[0] = Character.toUpperCase(chars[0]);

        //이전 문자가 공백이고 현재 문자가 공백이 아니면 대문자로 변경
        for(int i = 1; i < chars.length; i++) {
            if(!Character.isAlphabetic(chars[i]))
                continue;

            if(chars[i - 1] == ' ' && chars[i] != ' ')
                chars[i] = Character.toUpperCase(chars[i]);
            else
                chars[i] = Character.toLowerCase(chars[i]);
        }

        return new String(chars);
    }
}
