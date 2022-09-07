package javaCodingInterview.Chapter12;

import java.util.EmptyStackException;
import java.util.LinkedList;
import java.util.Stack;

public class StackOfPlates {

    class MyStack {
        private static final int STACK_SIZE = 3;

        private final LinkedList<Stack<Integer>> stacks = new LinkedList<>();

        public void push(int value) {
            if(stacks.isEmpty() || stacks.getLast().size() >= STACK_SIZE)
                stacks.add(new Stack<>());

            stacks.getLast().push(value);
        }

        public Integer pop() {
            if(stacks.isEmpty())
                throw new EmptyStackException();

            Integer e = stacks.getLast().pop();
            removeLastStackIfEmpty();

            return e;
        }

        public Integer popAt(int stackIndex) {
            if(stacks.isEmpty())
                throw new EmptyStackException();

            if(stackIndex < 0 || stackIndex > stacks.size())
                throw new IllegalArgumentException();

            Integer e = stacks.get(stackIndex).pop();

            shift(stackIndex);

            return e;
        }

        private void shift(int stackIndex) {
            for(int i=stackIndex; i<stacks.size()-1; i++) {
                stacks.get(i).push(stacks.get(i+1).remove(0));
            }
            removeLastStackIfEmpty();
        }

        private void removeLastStackIfEmpty() {
            if(stacks.getLast().isEmpty())
                stacks.removeLast();
        }
    }
}
