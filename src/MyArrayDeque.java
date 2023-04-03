public class MyArrayDeque {
    private int[] array;
    private int size;

    private int front;
    private int rear;

    public MyArrayDeque(int size) {
        this.array = new int[size];
        this.size = 0;
        this.front = 0;
        this.rear = 0;
    }

    /**
     * 뒤에서 삽입
     * @param value
     */
    public void offer(int value) {
        if(size >= array.length)
            throw new IllegalArgumentException("배열이 꽉 찼습니다.");

        rear = (rear + 1) % array.length;

        array[rear] = value;

        size++;
    }

    /**
     * 앞에서 삽입
     * @param value
     */
    public void offerFirst(int value) {
        if(size >= array.length)
            throw new IllegalArgumentException("배열이 꽉 찼습니다.");

        array[front] = value;

        front = (front - 1 + array.length) % array.length;

        size++;
    }

    /**
     * 앞에서 꺼내기
     * @return
     */
    public int poll() {
        if(size <= 0)
            throw new IllegalArgumentException("배열이 비었습니다.");

        front = (front + 1) % array.length;

        int value = array[front];
        array[front] = 0;

        size--;

        return value;
    }

    /**
     * 뒤에서 꺼내기
     * @return
     */
    public int pollLast() {
        if(size <= 0)
            throw new IllegalArgumentException("배열이 비었습니다.");

        int value = array[rear];
        array[rear] = 0;

        rear = (rear - 1 + array.length) % array.length;

        size--;

        return value;
    }

    /**
     * 맨 앞 값 찾기
     * @return
     */
    public int peek() {
        if(size <= 0)
            throw new IllegalArgumentException("배열이 비었습니다.");

        return array[(front + 1) % array.length];
    }

    /**
     * 맨 뒤 값 찾기
     * @return
     */
    public int peekLast() {
        if(size <= 0)
            throw new IllegalArgumentException("배열이 비었습니다.");

        return array[rear];
    }

    public int size() {
        return this.size;
    }
}
