package leetcode;

public class ClimbingStairs {

    public int climbStairs(int n) {
        int[] cached = new int[n + 1];
        return climb(n, cached);
    }

    public int climb(int stairs, int[] cached) {
        //종료 : 더 이상 오를 수 있는 계단이 없을 때
        if(stairs == 0)
            return 1;

        //갈 수 있는 계단을 넘는 방법은 count에서 제외한다.
        if(stairs < 0)
            return 0;

        //캐시되어있는지 확인
        if(cached[stairs] > 0)
            return cached[stairs];

        int way = 0; //계단을 오르는 방법

        //1 step 오르거나
        way += climb(stairs - 1, cached);

        //2 step 오르는 경우
        way += climb(stairs - 2, cached);

        //캐시
        cached[stairs] = way;

        return way;
    }

}
