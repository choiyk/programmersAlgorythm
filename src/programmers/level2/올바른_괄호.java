package programmers.level2;

import java.util.Stack;

public class 올바른_괄호 {

    boolean solution(String s) {
        //'('는 스택에 쌓는다.
        //')'는 스택에서 pop한다.
        //스택에서 더 이상 pop할게 없으면 false
        //최종적으로 스택이 비어있지 않으면 false

        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();

        for(char c : chars) {
            if(c == '(') {
                stack.push(c);
            }
            else {
                if(stack.isEmpty())
                    return false;

                stack.pop();
            }
        }

        if(!stack.isEmpty())
            return false;

        return true;
    }
}
