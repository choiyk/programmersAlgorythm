package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 미로_탐색 {

    private static int minWay = Integer.MAX_VALUE;
    private static int[][] direction = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] maze = new int[N][M];

        for(int i = 0; i < N; i++) {
            String s = br.readLine();
            String[] sarr = s.split("");
            for(int j = 0; j < M; j++) {
                maze[i][j] = Integer.parseInt(sarr[j]);
            }
        }

        //go(maze, cached, 0, 0, N - 1, M - 1, 1);

        //bfs
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0,0});

        while(!queue.isEmpty()) {
            int[] arr = queue.poll();
            int length = maze[arr[0]][arr[1]];

            if(arr[0] == N - 1 && arr[1] == M - 1) {
                minWay = length;
                break;
            }

            for(int i = 0; i < direction.length; i++) {
                int nextX = arr[0] + direction[i][0];
                int nextY = arr[1] + direction[i][1];

                if(nextX >= 0 && nextX < maze.length && nextY >= 0 && nextY < maze[0].length && maze[nextX][nextY] == 1) {
                    queue.add(new int[]{nextX, nextY});

                    maze[nextX][nextY] = length + 1;
                }
            }
        }

        System.out.println(minWay);
    }

    private static void go(int[][] maze, int x, int y, int targetX, int targetY, int way) {
        //도착했을 때
        if(x == targetX && y == targetY) {
            minWay = Math.min(minWay, way);
            return;
        }

        //방문 표시
        maze[x][y] = -1;

        for(int i = 0; i < direction.length; i++) {
            int nextX = x + direction[i][0];
            int nextY = y + direction[i][1];

            if(nextX >= 0 && nextX < maze.length && nextY >= 0 && nextY < maze[0].length && maze[nextX][nextY] == 1) {
                go(maze, nextX, nextY, targetX, targetY, way + 1);
            }
        }

        maze[x][y] = 1;
    }
}
