package leetcode.two;

public class NumberOfIslands {

    public int numIslands(char[][] grid) {
        int cnt = 0;

        //땅을 만나면 섬을 확인 후 cnt++
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == '1') {
                    cnt++;
                    compute(grid, i, j);
                }
            }
        }

        return cnt;
    }

    private void compute(char[][] grid, int x, int y) {
        //범위를 벗어나거나 땅이 아니면 종료
        if(!(x >= 0 && x < grid.length) || !(y >= 0 && y < grid[0].length) || grid[x][y] != '1')
            return;

        //현재 땅 방문
        grid[x][y] = '2';

        //연결된 땅을 방문
        if(x - 1 >= 0 && grid[x - 1][y] == '1')
            compute(grid, x - 1, y);

        if(y - 1 >= 0 && grid[x][y - 1] == '1')
            compute(grid, x, y - 1);

        if(x + 1 < grid.length && grid[x + 1][y] == '1')
            compute(grid, x + 1, y);

        if(y + 1 < grid[0].length && grid[x][y + 1] == '1')
            compute(grid, x, y + 1);
    }
}
