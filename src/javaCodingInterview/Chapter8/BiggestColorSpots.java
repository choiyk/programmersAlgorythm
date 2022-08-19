package javaCodingInterview.Chapter8;

public class BiggestColorSpots {

    int currentColorSpot = 0;

    public void solution(int cols, int rows, int color, int[][] map) {
        int biggestColorSpot = 0;
        int answerColor = 0;

        for(int i=0; i< cols; i++) {
            for(int j=0; j<rows; j++) {
                if(map[i][j] > 0) {
                    currentColorSpot = 0;
                    compute(map[i][j], map, i, j, cols, rows);
                    if(biggestColorSpot < currentColorSpot) {
                        biggestColorSpot = currentColorSpot;
                        answerColor = -map[i][j];
                    }
                }
            }
        }

        System.out.println(answerColor + "번 색깔이 " + biggestColorSpot + "칸으로 가장 큽니다.");
    }

    private void compute(int color, int[][] map, int i, int j, int cols, int rows) {
        if(map[i][j] == -1) return; //이미 지났다면 검사가 다 끝났을테니...? 확신할 수 없어...ㅎ

        map[i][j] *= -1;
        currentColorSpot++;

        if(i < cols-1 && map[i+1][j] == color) {
            compute(color, map, i+1, j, cols, rows);
        }

        if(i > 0 && map[i-1][j] == color) {
            compute(color, map, i-1, j, cols, rows);
        }

        if(j < rows-1 && map[i][j+1] == color) {
            compute(color, map, i, j+1, cols, rows);
        }

        if(j > 0 && map[i][j-1] == color) {
            compute(color, map, i, j-1, cols, rows);
        }
    }
}
