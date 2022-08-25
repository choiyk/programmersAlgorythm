package javaCodingInterview.Chapter8;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TowerTest {

    @Test
    public void test() {
        Tower o = new Tower();
        int[][] boxes = {{14,10,1},{10,7,2},{10,5,3}};
        System.out.println(o.solution(boxes));  //17
    }

    @Test
    public void test2() {
        Tower o = new Tower();
        int[][] boxes = {{14,10,1},{10,7,2},{10,5,3}};
        System.out.println(o.solution2(boxes));  //17
    }

}