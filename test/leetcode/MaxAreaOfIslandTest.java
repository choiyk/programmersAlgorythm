package leetcode;

import leetcode.one.MaxAreaOfIsland;
import org.junit.jupiter.api.Test;

class MaxAreaOfIslandTest {

    @Test
    public void test() {
        MaxAreaOfIsland o = new MaxAreaOfIsland();

        int[][] grid = new int[][] {{0,0,1,0,0,0,0,1,0,0,0,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,1,1,0,1,0,0,0,0,0,0,0,0},{0,1,0,0,1,1,0,0,1,0,1,0,0},{0,1,0,0,1,1,0,0,1,1,1,0,0},{0,0,0,0,0,0,0,0,0,0,1,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,0,0,0,0,0,0,1,1,0,0,0,0}};

        int[][] grid2 = new int[][] {{1,1,0,0,0},{1,1,0,0,0},{0,0,0,1,1},{0,0,0,1,1}};

        System.out.println(o.maxAreaOfIsland(grid2));
    }

}