package programmers.level2;

public class 멀리_뛰기 {

    public long solution(int n) {
        if(n < 3)
            return n;

        long[] cached = new long[n + 1];

        cached[0] = 0;
        cached[1] = 1;
        cached[2] = 2;

        for(int i = 3; i <= n; i++) {
            cached[i] = (cached[i - 1] + cached[i - 2]) % 1234567;
        }

        return cached[n];
    }
}
