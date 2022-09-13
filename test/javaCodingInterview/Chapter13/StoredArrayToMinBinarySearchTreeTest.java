package javaCodingInterview.Chapter13;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StoredArrayToMinBinarySearchTreeTest {

    @Test
    public void test() {
        Integer[] m = {-2, 3, 4, 6, 7, 8, 12, 23, 90};
        StoredArrayToMinBinarySearchTree o = new StoredArrayToMinBinarySearchTree();
        o.solution(m);
    }

}