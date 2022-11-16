package leetcode.two;

public class MaxAreaOfIsland {

    int maxArea = 0;

    public int maxAreaOfIsland(int[][] grid) {
        //땅을 만나면 연결된 땅의 개수를 계산
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1)
                    maxArea = Math.max(maxArea, compute(grid, i, j));
            }
        }

        return maxArea;
    }

    private int compute(int[][] grid, int x, int y) {
        //좌표가 범위를 벗어나면 종료
        //땅이 아니면 종료
        if(!(x >= 0 && x < grid.length) || !(y >= 0 && y < grid[0].length) || grid[x][y] != 1)
            return 0;

        grid[x][y] = -1;
        int area = 1;
        //사방에 연결된 땅으로 이동
        //각각 계산된 땅의 개수 더하기
        if(x - 1 >= 0 && grid[x - 1][y] == 1)
            area += compute(grid, x -  1, y);

        if(x + 1 < grid.length && grid[x + 1][y] == 1)
            area += compute(grid, x +  1, y);

        if(y - 1 >= 0 && grid[x][y - 1] == 1)
            area += compute(grid, x, y - 1);

        if(y + 1 < grid[0].length && grid[x][y + 1] == 1)
            area += compute(grid, x, y + 1);

        return area;
    }
}
