package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 하노이_탑_이동_순서 {
    private static StringBuilder sb = new StringBuilder();
    private static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        br.close();

        move(n, 1, 2, 3);

        System.out.println(cnt);

        System.out.println(sb.toString());
    }

    public static void move(int n, int start, int middle, int end) {
        //더 이상 옮길 원판이 없으면 종료
        if(n <= 0)
            return;

        //n-1개를 middle로 옮겨놓고
        move(n-1, start, end, middle);

        //1개를 end로 옮기고
        sb.append(start);
        sb.append(" ");
        sb.append(end);
        sb.append("\n");
        cnt++;

        //n-1개를 end로 옮김
        move(n-1, middle, start, end);
    }
}
