package programmers.level3;

public class 정수_삼각형 {

    public int solution(int[][] triangle) {
        int[][] cached = new int[triangle.length][triangle[triangle.length - 1].length];

        return compute(triangle, 0, 0, cached);
    }

    private int compute(int[][] triangle, int x, int y, int[][] cached) {
        //마지막인 경우(더 이상 이동할 수 없는 경우) 종료
        if(x >= triangle.length - 1)
            return triangle[x][y];

        if(cached[x][y] > 0)
            return cached[x][y];

        //왼쪽으로 가는 경우 : y
        int left = compute(triangle, x + 1, y, cached);

        //오른쪽으로 가는 경우 : y + 1
        int right = compute(triangle, x + 1, y + 1, cached);

        int answer = triangle[x][y] + Math.max(left, right);

        cached[x][y] = answer;

        return answer;
    }
}
