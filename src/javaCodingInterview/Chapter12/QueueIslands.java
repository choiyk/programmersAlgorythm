package javaCodingInterview.Chapter12;

import java.util.LinkedList;
import java.util.Queue;

public class QueueIslands {
    private static final int POSSIBLE_MOVEMENT = 8;
    private static final int[] ROW = {-1,-1,-1,0,0,1,1,1};
    private static final int[] COL = {-1,0,1,-1,1,-1,0,1};

    public int solution(int[][] matrix) {
        int[][] flagged = new int[matrix.length][matrix[0].length];
        int islandCnt = 0;

        for(int r=0; r<matrix.length; r++) {
            for(int c=0; c<matrix[0].length; c++) {
                if(isValid(matrix, r, c, flagged)) {
                    islandCnt++;

                    resolve(matrix, r, c, flagged);
                }
            }
        }

        return islandCnt;
    }

    private void resolve(int[][] matrix, int row, int col, int[][] flagged) {
        Queue<Cell> possibles = new LinkedList<>();
        possibles.offer(new Cell(row, col));

        while(!possibles.isEmpty()) {
            Cell cell = possibles.poll();

            flagged[cell.row][cell.col] = -1;

            for(int i=0; i<POSSIBLE_MOVEMENT; i++) {
                int r = cell.row + ROW[i];
                int c = cell.col + COL[i];

                if(isValid(matrix, r, c, flagged)) {
                    //flagged[r][c] = -1;
                    possibles.offer(new Cell(r, c));
                }
            }
        }
    }

    private boolean isValid(int[][] matrix, int row, int col, int[][] flagged) {
        /** 다음 칸으로 이동할 수 있는 조건
         * 행렬에서 벗어나지 않아야 함
         * 칸의 값이 1이어야 함
         * 이전에 방문한 적이 없어야 함
         */
        return (col >= 0 && col < matrix[0].length && row >= 0 && row < matrix.length) &&
                (matrix[row][col] == 1) &&
                (flagged[row][col] != -1);
    }

    class Cell {
        int row;
        int col;

        public Cell(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}
