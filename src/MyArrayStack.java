public class MyArrayStack {
    int[] stack;
    int top;
    int size;

    public MyArrayStack(int size) {
        this.stack = new int[size];
        this.top = -1;
        this.size = 0;
    }

    public void push(int value) {
        if(size >= stack.length)
            throw new IllegalArgumentException("스택이 꽉 찼습니다.");

        stack[++top] = value;
        size++;
    }

    public int pop() {
        if(size <= 0)
            throw new IllegalArgumentException("스택이 비었습니다.");

        int value = stack[top];
        stack[top--] = 0;
        size--;
        return value;
    }

    public int peek() {
        if(size <= 0)
            throw new IllegalArgumentException("스택이 비었습니다.");

        return stack[top];
    }

    public int size() {
        return this.size;
    }
}
