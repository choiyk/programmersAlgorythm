package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RottingOrangesTest {

    @Test
    public void test() {
        int[][] grid = {{2,1,1},{1,1,1},{0,1,2}};

        RottingOranges o = new RottingOranges();

        System.out.println(o.orangesRotting(grid));
    }

}