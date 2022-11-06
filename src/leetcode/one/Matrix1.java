package leetcode.one;

import java.util.ArrayDeque;
import java.util.Queue;

public class Matrix1 {

    private final int[][] DIRECTIONS = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

    public int[][] updateMatrix(int[][] mat) {
        Queue<Integer[]> queue = new ArrayDeque<>();

        for(int i = 0; i < mat.length; i++) {
            for(int j = 0; j <mat[0].length; j++) {
                //0인 것에서 부터 계산
                if(mat[i][j] == 0) {
                    queue.add(new Integer[] {i, j});
                }
                else {
                    mat[i][j] = -1;
                }
            }
        }

        while(!queue.isEmpty()) {
            Integer[] p = queue.poll();
            final int i = p[0];
            final int j = p[1];

            //사방을 확인
            for(int[] direction : DIRECTIONS) {
                final int x = i + direction[0];
                final int y = j + direction[1];

                //범위를 벗어나는 경우
                if(x < 0 || y < 0 || x >= mat.length || y >= mat[0].length)
                    continue;

                //값이 -1이면 거리 계산 : 나 + 1;
                if(mat[x][y] == -1) {
                    mat[x][y] = mat[i][j] + 1;
                    queue.add(new Integer[] {x, y});
                }
            }
        }

        return mat;
    }

}
