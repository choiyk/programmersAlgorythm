package programmers.level2;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 행렬_테두리_회전하기 {

    public int[] solution(int rows, int columns, int[][] queries) {
        //이동하는 방법은 총 4가지. 오른쪽으로 밀기, 아래로 밀기, 왼쪽으로 밀기, 위로 밀기
        //마지막을 임시로 저장해두고 마지막을 제외한 숫자들을 한칸씩 민다.
        //모서리에 도달하면 큐에 숫자 넣기, 입력 포인터는 다음 칸이 된다.
        //입력 포인터부터 숫자를 큐에서 빼와 넣는다.
        //숫자 중 가장 작은 숫자 리스트에 저장

        int[][] table = new int[rows][columns];

        int num = 1;
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < columns; j++) {
                table[i][j] = num++;
            }
        }

        int[] answer = new int[queries.length];

        for(int i = 0; i < queries.length; i++) {
            answer[i] = rotate(table, queries[i][0] - 1, queries[i][1] - 1, queries[i][2] - 1, queries[i][3] - 1);
        }

        return answer;
    }

    private int rotate(int[][] table, int x1, int y1, int x2, int y2) {
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(table[x1][y1]);

        int min = pushRight(table, queue, x1, y1 + 1, x1, y2);
        min = Math.min(min, pushBellow(table, queue, x1 + 1, y2, x2, y2));
        min = Math.min(min, pushLeft(table, queue, x2, y2 - 1, x2, y1));
        min = Math.min(min, pushTop(table, queue, x2 - 1, y1, x1, y1));

        return min;
    }

    private int pushRight(int[][] table, Queue<Integer> queue, int x, int y, int ex, int ey) {
        int min = table[x][y];

        //큐에 숫자 넣기
        for(int i = y; i <= ey; i++) {
            queue.offer(table[x][i]);

            min = Math.min(min, table[x][i]);
        }

        //숫자 입력
        while(y <= ey) {
            table[x][y++] = queue.poll();
        }

        return min;
    }

    private int pushBellow(int[][] table, Queue<Integer> queue, int x, int y, int ex, int ey) {
        int min = table[x][y];

        //큐에 숫자 넣기
        for(int i = x; i <= ex; i++) {
            queue.offer(table[i][y]);

            min = Math.min(min, table[i][y]);
        }

        //숫자 입력
        while(x <= ex) {
            table[x++][y] = queue.poll();
        }

        return min;
    }

    private int pushLeft(int[][] table, Queue<Integer> queue, int x, int y, int sx, int sy) {
        int min = table[x][y];

        //큐에 숫자 넣기
        for(int i = y; i >= sy; i--) {
            queue.offer(table[x][i]);

            min = Math.min(min, table[x][i]);
        }

        //숫자 입력
        while(y >= sy) {
            table[x][y--] = queue.poll();
        }

        return min;
    }

    private int pushTop(int[][] table, Queue<Integer> queue, int x, int y, int sx, int sy) {
        int min = table[x][y];

        //큐에 숫자 넣기
        for(int i = x; i >= sx; i--) {
            queue.offer(table[i][y]);

            min = Math.min(min, table[i][y]);
        }

        //숫자 입력
        while(x >= sx) {
            table[x--][y] = queue.poll();
        }

        return min;
    }
}
