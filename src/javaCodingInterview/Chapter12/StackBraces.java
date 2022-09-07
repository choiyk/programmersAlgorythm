package javaCodingInterview.Chapter12;

import java.util.Stack;

public class StackBraces {
    public boolean solution(String s) {
        if(s == null || s.length() <= 0)
            return false;

        Stack<Character> braces = new Stack<>();

        for(char c : s.toCharArray()) {
            if(c == '{')
                braces.push(c);
            else if(c == '}') {
                try {
                    braces.pop();
                }
                catch(Exception e) {
                    return false;
                }
            }
        }

        return braces.isEmpty();
    }
}
