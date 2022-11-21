package programmers.level2;

public class 피보나치_수 {

    public int solution(int n) {
        int[] cached = new int[(n % 1234567) + 1];

        return fibonacci(cached, n);
    }

    private int fibonacci(int[] cached, int n) {
        //n이 0일때 0, 1일때 1 반환
        //F(n) = F(n - 2) + F(n - 1)
        //결과값이 캐시에 있다면 계산하지 않고 캐시에 저장된 값 반환

        if(n == 0 || n == 1)
            return n;

        n = n % 1234567;

        if(cached[n] > 0)
            return cached[n];

        int res = (fibonacci(cached, n - 2) + fibonacci(cached, n - 1)) % 1234567;

        cached[n] = res;

        return res;
    }
}
