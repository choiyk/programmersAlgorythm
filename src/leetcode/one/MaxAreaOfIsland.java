package leetcode.one;

import java.util.ArrayDeque;
import java.util.Queue;

public class MaxAreaOfIsland {

    public int maxAreaOfIsland(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length]; //방문한 곳임을 표시할 배열

        int maxArea = 0; //섬의 수

        //0,0부터 순회하면서 1인 곳을 찾는다.
        for(int x = 0; x < grid.length; x++) {
            for(int y = 0; y < grid[0].length; y++) {
                //방문하지 않은 섬일 경우
                if(grid[x][y] == 1 && visited[x][y] == false) {
                    int islandSize = visitIsland(grid, visited, x, y); //섬 크기 계산

                    maxArea = Math.max(maxArea, islandSize);
                }
            }
        }

        return maxArea;
    }

    public int visitIsland(int[][] grid, boolean[][] visited, int x, int y) {
        int isalandSize = 0;
        Queue<Integer[]> queue = new ArrayDeque<>(); //방문할 곳을 저장할 큐

        //현재 섬을 큐에 저장
        queue.add(new Integer[] {x, y});

        while(!queue.isEmpty()) {
            Integer[] coordinate = queue.poll();

            final int cx = coordinate[0];
            final int cy = coordinate[1];

            if(visited[cx][cy])
                continue; //이미 방문했다면 넘어감

            visited[cx][cy] = true; //방문 표시
            isalandSize++; //섬 크기 증가

            //4방향을 확인하고 1이면 방문할 큐에 저장
            if(cx - 1 >= 0 && !visited[cx - 1][cy] && grid[cx - 1][cy] == 1)
                queue.add(new Integer[] {cx - 1, cy});

            if(cy - 1 >= 0 && !visited[cx][cy - 1] && grid[cx][cy - 1] == 1)
                queue.add(new Integer[] {cx, cy - 1});

            if(cx + 1 < grid.length && !visited[cx + 1][cy] && grid[cx + 1][cy] == 1)
                queue.add(new Integer[] {cx + 1, cy});

            if(cy + 1 < grid[0].length && !visited[cx][cy + 1] && grid[cx][cy + 1] == 1)
                queue.add(new Integer[] {cx, cy + 1});
        }

        return isalandSize;
    }

    public int maxAreaOfIslandBFS(int[][] grid) {
        int maxArea = 0; //섬의 최대 크기

        //0,0부터 순회하면서 1인 곳을 찾는다.
        for(int x = 0; x < grid.length; x++) {
            for(int y = 0; y < grid[0].length; y++) {
                //방문하지 않은 섬일 경우
                if(grid[x][y] == 1) {
                    int islandSize = countIslandSizeBFS(grid, x, y);
                    maxArea = Math.max(maxArea, islandSize);
                }
            }
        }

        return maxArea;
    }

    public int countIslandSizeBFS(int[][] grid, int x, int y) {
        int size = 1;
        grid[x][y] = 0;

        //4방향 확인
        //왼쪽
        if(x - 1 >= 0 && grid[x - 1][y] == 1)
            size += countIslandSizeBFS(grid, x - 1, y);

        //위
        if(y - 1 >= 0 && grid[x][ y - 1] == 1)
            size += countIslandSizeBFS(grid, x, y - 1);

        //오른쪽
        if(x + 1 < grid.length && grid[x + 1][y] == 1)
            size += countIslandSizeBFS(grid, x + 1, y);

        //아래
        if(y + 1 < grid[0].length && grid[x][y + 1] == 1)
            size += countIslandSizeBFS(grid, x, y + 1);

        return size;
    }

}
