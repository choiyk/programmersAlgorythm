import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyArrayDequeTest {

    @Test
    public void offer() {
        MyArrayDeque deque = new MyArrayDeque(10);

        deque.offer(3);
        deque.offer(5);
        deque.offer(1);

        assertEquals(3, deque.size());

        assertEquals(3, deque.poll());
        assertEquals(2, deque.size());

        assertEquals(5, deque.poll());
        assertEquals(1, deque.size());

        assertEquals(1, deque.poll());
        assertEquals(0, deque.size());
    }

    @Test
    public void offerFirst() {
        MyArrayDeque deque = new MyArrayDeque(10);

        deque.offerFirst(3);
        deque.offerFirst(5);
        deque.offerFirst(1);

        assertEquals(3, deque.size());

        assertEquals(1, deque.poll());
        assertEquals(2, deque.size());

        assertEquals(5, deque.poll());
        assertEquals(1, deque.size());

        assertEquals(3, deque.poll());
        assertEquals(0, deque.size());
    }

    @Test
    public void pollLast() {
        MyArrayDeque deque = new MyArrayDeque(10);

        deque.offer(3);
        deque.offer(5);
        deque.offer(1);

        assertEquals(3, deque.size());

        assertEquals(1, deque.pollLast());
        assertEquals(2, deque.size());

        assertEquals(5, deque.pollLast());
        assertEquals(1, deque.size());

        assertEquals(3, deque.pollLast());
        assertEquals(0, deque.size());
    }

    @Test
    public void peek() {
        MyArrayDeque deque = new MyArrayDeque(10);

        deque.offer(3);
        deque.offer(5);
        deque.offer(1);

        assertEquals(3, deque.size());

        assertEquals(3, deque.peek());
        assertEquals(3, deque.size());
    }

    @Test
    public void 꽉_찼을_때_더_넣기() {
        MyArrayDeque deque = new MyArrayDeque(1);

        deque.offer(3);

        assertThrows(IllegalArgumentException.class, () -> {deque.offerFirst(1);});
    }

    @Test
    public void 비었을_때_빼기() {
        MyArrayDeque deque = new MyArrayDeque(1);

        deque.offer(3);

        deque.poll();

        assertThrows(IllegalArgumentException.class, () -> {deque.poll();});
    }
}