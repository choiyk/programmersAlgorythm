package leetcode.one;

import java.util.LinkedList;
import java.util.Queue;

public class FloodFill {

    class Position {
        private int x;
        private int y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int[][] directionally = {{0, -1}, {1, 0}, {0, 1}, {-1, 0}}; //네 방향
        boolean[][] cached = new boolean[image.length][image[0].length]; //방문한 좌표 표시

        Queue<Position> queue = new LinkedList<>(); //앞으로 방문해야 할 좌표
        queue.add(new Position(sr, sc)); //시작점
        final int replacedColor = image[sr][sc]; //시작점의 색깔. 이 색과 같으면 색 바꾸기

        while(!queue.isEmpty()) {
            Position cp = queue.poll();

            //좌표 방문
            cached[cp.x][cp.y] = true;

            //색깔 변경
            image[cp.x][cp.y] = color;

            for(int i = 0; i < directionally.length; i++) {
                final int x = cp.x + directionally[i][0];
                final int y = cp.y + directionally[i][1];

                //좌표 범위를 벗어났는지 확인
                if(x < 0 || y < 0 || x >= image.length || y >= image[0].length)
                    continue;

                if(!cached[x][y] && image[x][y] == replacedColor)
                    queue.add(new Position(x, y));
            }
        }

        return image;
    }

    public int[][] floodFillByDfs(int[][] image, int sr, int sc, int color) {
        if(image[sr][sc] == color)
            return image;

        floodFill(image, image[sr][sc], color, sr, sc);

        return image;
    }

    public void floodFill(int[][] image, int oldColor, int newColor, int x, int y) {
        image[x][y] = newColor;

        //위
        if(y - 1 >= 0 && image[x][y - 1] == oldColor)
            floodFill(image, oldColor, newColor, x, y - 1);

        //오른쪽
        if(x + 1 < image.length && image[x + 1][y] == oldColor)
            floodFill(image, oldColor, newColor, x + 1, y);

        //아래
        if(y + 1 < image[0].length && image[x][y + 1] == oldColor)
            floodFill(image, oldColor, newColor, x, y + 1);

        //왼쪽
        if(x - 1 >= 0 && image[x - 1][y] == oldColor)
            floodFill(image, oldColor, newColor, x - 1, y);
    }

}
