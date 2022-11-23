package programmers.level2;

import java.util.*;

public class 괄호_회전하기 {

    public int solution(String s) {
        //0 <= x < s.length
        //x칸 만큼 씩 밀면서 s가 올바른지 확인
        //스택에 괄호를 하나씩 넣으면서 닫는 괄호가 나오면 스택의 가장 마지막에 들어있는게 같은 괄호의 여는 건지 확인하고 맞으면 pop
        //스택이 비어지면 올바른 문자
        //닫는 괄호로 시작하면 틀린 문자
        //올바르면 answer++
        //문자열을 밀기 위해 deque사용

        if(s.length() % 2 == 1)
            return 0;

        int answer = 0;
        Deque<Character> deque = new ArrayDeque<>();
        Map<Character, Character> map = new HashMap<>();

        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');

        for(char c : s.toCharArray()) {
            deque.offer(c);
        }

        for(int x = 0; x < s.length(); x++) {
            if(check(deque, map))
                answer++;

            final char first = deque.poll();
            deque.offerLast(first);
        }

        return answer;
    }

    private boolean check(Deque<Character> deque, Map<Character, Character> map) {
        if(isClose(deque.peek()))
            return false;

        Stack<Character> stack = new Stack<>();

        Iterator<Character> iterator = deque.iterator();

        while(iterator.hasNext()) {
            final char c = iterator.next();

            if(isOpen(c)) {
                stack.push(c);
            }
            else {
                if(stack.isEmpty())
                    return false;

                final char last = stack.peek(); //기대값 : 여는 괄호

                if(map.get(last) != c) {
                    return false;
                }
                else {
                    stack.pop();
                }
            }
        }

        return stack.isEmpty();
    }

    private boolean isOpen(char c) {
        if(c == '(' || c == '{' || c == '[')
            return true;

        return false;
    }

    private boolean isClose(char c) {
        if(c == ')' || c == '}' || c == ']')
            return true;

        return false;
    }
}
