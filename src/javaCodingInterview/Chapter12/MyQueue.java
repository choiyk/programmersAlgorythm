package javaCodingInterview.Chapter12;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.EmptyStackException;

public class MyQueue<E> {

    private static final int DEFAULT_CAPACITY = 10;
    private int front;  //큐의 맨 앞 index
    private int rear;   //큐의 맨 뒤 index
    private int count;  //큐에 들어있는 원소 갯수
    private int capacity;   //큐의 크기
    private E[] queue;  //큐

    public MyQueue() {
        queue = (E[]) Array.newInstance(Object[].class.getComponentType(), DEFAULT_CAPACITY);
        count = 0;
        front = 0;
        rear = -1;
        capacity = DEFAULT_CAPACITY;
    }

    public void enqueue(E e) {
        if(isFull())
            ensureCapacity();

        rear = (rear + 1) % capacity;
        queue[rear] = e;

        count++;
    }

    public E dequeue() {
        if(isEmpty())
            throw new EmptyStackException();

        E e = queue[front];

        queue[front] = null;
        front = (front + 1) % capacity;
        count--;

        return e;
    }

    private boolean isEmpty() {
        return count == 0;
    }

    private boolean isFull() {
        return count == capacity;
    }

    private void ensureCapacity() {
        int newSize = capacity * 2;
        queue = Arrays.copyOf(queue, newSize);
        capacity = newSize;
    }
}
