package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class 단지_번호_붙이기 {

    private static Queue<Integer> answer = new PriorityQueue<>();
    private static int[][] direction = {{0,1}, {1,0}, {0,-1}, {-1,0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] maze = new int[N][N];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            String[] sarr = s.split("");
            for (int j = 0; j < N; j++) {
                maze[i][j] = Integer.parseInt(sarr[j]);
            }
        }

        br.close();
        //입력 종료

        //문제풀이
        //시작점 찾기
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(maze[i][j] == 1) {
                    //연결된 집 찾기
                    Queue<int[]> queue = new LinkedList<>();
                    queue.add(new int[]{i, j});

                    maze[i][j] = 0;
                    int size = 1;

                    while(!queue.isEmpty()) {
                        int[] c = queue.poll();

                        for(int d = 0; d < 4; d++) {
                            int nextX = c[0] + direction[d][0];
                            int nextY = c[1] + direction[d][1];

                            if(nextX >= 0 && nextX < N && nextY >= 0 && nextY < N && maze[nextX][nextY] == 1) {
                                queue.add(new int[]{nextX, nextY});

                                maze[nextX][nextY] = 0;

                                size++;
                            }
                        }
                    }

                    answer.add(size);
                }
            }
        }

        //출력
        StringBuilder sb = new StringBuilder();

        sb.append(answer.size());
        while (!answer.isEmpty()) {
            sb.append("\n");
            sb.append(answer.poll());
        }

        System.out.println(sb.toString());
    }
}
