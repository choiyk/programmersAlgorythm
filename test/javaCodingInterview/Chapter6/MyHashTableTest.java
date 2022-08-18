package javaCodingInterview.Chapter6;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyHashTableTest {
    private MyHashTable<Integer, String> hashTable;

    @BeforeEach
    public void setup() {
        this.hashTable = new MyHashTable();
        hashTable.put(1, "하나");
        hashTable.put(2, "둘");
        hashTable.put(3, "셋");
        hashTable.put(4, "넷");
        hashTable.put(5, "다섯");
    }

    @Test
    public void 삽입_테스트() {
        assertEquals(hashTable.getSize(), 5);

        hashTable.put(6, "여섯");
        assertEquals(hashTable.getSize(), 6);
    }

    @Test
    public void 호출_테스트() {
        assertEquals(hashTable.get(2), "둘");
    }

    @Test
    public void 이미_존재하는_키_값에_다른_값_삽입() {
        //동일한 데이터 삽입
        hashTable.put(2, "이");
        assertEquals(hashTable.getSize(), 5);
        assertEquals(hashTable.get(2), "이");
    }

    @Test
    public void 존재하지_않는_값_호출() {
        assertNull(hashTable.get(8));
    }

    @Test
    public void 해시_충돌_체이닝_테스트() {
        hashTable.put(13, "열셋");
        assertEquals(hashTable.getSize(), 6);
        assertEquals(hashTable.get(13), "열셋");
    }

}