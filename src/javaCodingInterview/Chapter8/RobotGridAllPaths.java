package javaCodingInterview.Chapter8;

import java.util.*;

public class RobotGridAllPaths {

    public RobotGridAllPaths() {    }

    public int solution(int x, int y) {
        return computePath(x-1, y-1);
    }

    private int computePath(int x, int y) {
        if(x < 0 || y < 0) {
            return 0;
        }

        if(x == 0 && y == 0) {
            return 1;
        }

        return computePath(x-1, y) + computePath(x, y-1);
    }

    // 일반 재귀 알고리즘
    public int countPaths(int m, int n) {
        if (m <= 0 || n <= 0) {
            return -1;
        }

        // 첫 번째 열/행의 모든 칸으로 이동하면 1입니다.
        if (m == 1 || n == 1) {
            return 1;
        }

        return countPaths(m - 1, n) + countPaths(m, n - 1);
        // 대각선으로 이동 가능하면 앞 줄에 다음 코드를 추가: + numberOfPaths(m - 1, n - 1);
    }

    // 테뷸레이션
    public int countPathsBottomUp(int m, int n) {
        if (m <= 1 || n <= 1) {
            return -1;
        }

        // 하위 문제의 결과를 저장(cache)
        int[][] count = new int[m][n];

        // 첫 번째 행의 모든 칸으로 이동하면 1입니다.
        for (int j = 0; j < n; j++) {
            count[0][j] = 1;
        }

        // 첫 번째 열의 모든 칸으로 이동하면 1입니다.
        for (int i = 0; i < m; i++) {
            count[i][0] = 1;
        }

        // 상향식 접근법으로 이동할 다른 칸의 경로 결정
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                count[i][j] = count[i - 1][j] + count[i][j - 1];
                // 대각선으로 이동 가능하면 앞 줄에 다음 코드를 추가: + count[i - 1][j - 1];
            }
        }

        return count[m - 1][n - 1];
    }

    class Point {
        private int x;
        private int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public String toString() {
            return "("+x+","+y+")";
        }
    }
}
