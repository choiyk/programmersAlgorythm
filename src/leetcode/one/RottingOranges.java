package leetcode.one;

import java.util.ArrayDeque;
import java.util.Queue;

public class RottingOranges {

    private final int[][] DIRECTIONS = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

    public int orangesRotting(int[][] grid) {

        Queue<int[]> queue = new ArrayDeque<>();

        int freshOrange = 0;
        //rotten orange를 찾아 큐에 넣기
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j <grid[0].length; j++) {
                if(grid[i][j] == 2) {
                    queue.add(new int[] {i, j});
                }
                else if(grid[i][j] == 1) {
                    freshOrange++;
                }
            }
        }

        //fresh orange가 없으면 0 return
        if(freshOrange == 0)
            return 0;

        //rotten orange가 없으면 -1 return
        if(queue.isEmpty())
            return -1;

        int minute = 0;
        //큐가 빌때까지 작업 반복
        //rotten orange를 꺼내와 사방에 fresh orange가 있으면 rotten으로 바꾸고 큐에 넣기
        while (!queue.isEmpty()) {
            int queueSize = queue.size();
            //rotten orange가 여러 개일 수 있으니 모든 rotten orange에 대해 작업
            for(int i = 0; i < queueSize; i++) {
                final int[] p = queue.poll();
                final int m = p[0];
                final int n = p[1];

                for(int j = 0; j < DIRECTIONS.length; j++) {
                    final int x = m + DIRECTIONS[j][0];
                    final int y = n + DIRECTIONS[j][1];

                    //범위를 벗어나면
                    if(x < 0 || y < 0 || x >= grid.length || y >= grid[0].length)
                        continue;

                    if(grid[x][y] == 1) {
                        grid[x][y] = 2;
                        queue.add(new int[] {x, y});
                        freshOrange--;
                    }
                }
            }

            minute++;
        }

        //작업이 끝난 후 fresh orange가 남아있으면 -1  return
        if(freshOrange > 0)
            return -1;

        return minute - 1;
    }

}
