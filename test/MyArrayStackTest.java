import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyArrayStackTest {

    @Test
    public void 테스트() {
        MyArrayStack stack = new MyArrayStack(10);

        stack.push(3);
        stack.push(1);

        assertEquals(2, stack.size);
        assertEquals(1, stack.pop());
        assertEquals(3, stack.pop());
    }

    @Test
    public void 꽉_찬_스택에_더_넣기() {
        MyArrayStack stack = new MyArrayStack(1);

        stack.push(1);

        assertThrows(IllegalArgumentException.class, () -> {stack.push(3);});
    }

    @Test
    public void 빈_스택에서_값_꺼내기() {
        MyArrayStack stack = new MyArrayStack(2);

        assertThrows(IllegalArgumentException.class, () -> {stack.pop();});
    }

}