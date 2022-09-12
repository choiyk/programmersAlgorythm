package javaCodingInterview.Chapter12;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueueIslandsTest {

    @Test
    public void test() {
        int[][] matrix = {
                {1, 1, 1, 0, 0, 0, 1, 1, 0, 1},
                {0, 1, 1, 0, 1, 0, 1, 0, 0, 0},
                {1, 1, 1, 1, 0, 0, 1, 0, 1, 0},
                {1, 0, 0, 1, 0, 1, 0, 0, 0, 0},
                {1, 1, 1, 1, 1, 1, 0, 0, 0, 1},
                {0, 0, 0, 1, 0, 0, 1, 1, 0, 1},
                {0, 0, 0, 0, 0, 1, 1, 0, 0, 0},
                {1, 1, 0, 1, 0, 0, 0, 1, 1, 0},
                {1, 0, 0, 0, 1, 1, 0, 1, 0, 0},
                {1, 1, 0, 1, 0, 1, 0, 1, 1, 1}
        };

        QueueIslands o = new QueueIslands();
        assertEquals(o.solution(matrix), 6);
    }

}