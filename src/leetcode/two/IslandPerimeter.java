package leetcode.two;

public class IslandPerimeter {

    int perimeter = 0;

    public int islandPerimeter(int[][] grid) {
        for(int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    countPerimeter(grid, i, j);
                    break;
                }
            }
        }

        return perimeter;
    }

    private void countPerimeter(int[][] grid, int x, int y) {
        //현재 위치가 격자를 벗어나면 종료
        if(!(x >= 0 && x < grid.length) || !(y >= 0 && y < grid[0].length))
            return;

        //이미 방문한 곳이면 종료
        //현재 위치가 땅이 아니면 종료
        if(grid[x][y] != 1)
            return;

        //방문
        grid[x][y] = -1;

        //사방 확인
        //격자를 벗어나거나, 물이면 perimeter++
        //땅이면 이동해서 계산
        if(x - 1 < 0 || grid[x - 1][y] == 0)
            perimeter++;
        else
            countPerimeter(grid, x - 1, y);

        if(x + 1 >= grid.length || grid[x + 1][y] == 0)
            perimeter++;
        else
            countPerimeter(grid, x + 1, y);

        if(y - 1 < 0 || grid[x][y - 1] == 0)
            perimeter++;
        else
            countPerimeter(grid, x, y - 1);

        if(y + 1 >= grid[0].length || grid[x][y + 1] == 0)
            perimeter++;
        else
            countPerimeter(grid, x, y + 1);
    }

}
