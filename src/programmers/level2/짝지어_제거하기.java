package programmers.level2;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class 짝지어_제거하기 {

    public int solution(String s) {
        //문자를 스택에 차례로 넣는다.
        //가장 마지막 문자가 현재 문자와 같으면 pop
        //스택이 비어있으면 1, 아니면 0

        if(s.length() <= 1)
            return 0;

        Stack<Character> stack1 = new Stack<>();

        char[] chars = s.toCharArray();
        for(char c : chars) {
            if(!stack1.isEmpty()) {
                final char lastChar = stack1.peek();

                if(lastChar == c) {
                    stack1.pop();
                    continue;
                }
            }

            stack1.push(c);
        }

        return stack1.isEmpty() ? 1 : 0;
    }
}
