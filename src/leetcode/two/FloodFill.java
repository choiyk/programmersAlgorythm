package leetcode.two;

public class FloodFill {

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        fill(image, sr, sc, color);

        return image;
    }

    private void fill(int[][] image, int x, int y, int color) {
        //범위를 벗어나면 종료
        if(!(x >= 0 && x < image.length) || !(y >= 0 && y < image[0].length))
            return;

        //이미 색칠해졌으면 종료
        if(image[x][y] == color)
            return;

        //현재 칸 색칠
        final int current = image[x][y];
        image[x][y] = color;

        //사방으로 색칠
        if((x - 1 >= 0 && x - 1 < image.length) && image[x - 1][y] == current)
            fill(image, x - 1, y, color);

        if((y + 1 >= 0 && y + 1 < image[0].length) && image[x][y + 1] == current)
            fill(image, x, y + 1, color);

        if((x + 1 >= 0 && x + 1 < image.length) && image[x + 1][y] == current)
            fill(image, x + 1, y, color);

        if((y - 1 >= 0 && y - 1 < image[0].length) && image[x][y - 1] == current)
            fill(image, x, y - 1, color);
    }

}
