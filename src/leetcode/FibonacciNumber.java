package leetcode;

public class FibonacciNumber {

    public int fib(int n) {
        //n이 0의면 o
        if(n == 0)
            return 0;

        //n이 1이면 1
        if(n == 1)
            return 1;

        //f(n) = f(n - 1) + f(n - 2)
        return fib(n - 1) + fib(n - 2);
    }

    public int fib2(int n) {
        int[] cached = new int[n + 1];

        return fib(n, cached);
    }

    public int fib(int n, int[] cached) {
        //n이 0의면 o
        if(n == 0)
            return 0;

        //n이 1이면 1
        if(n == 1)
            return 1;

        //캐시된 값이 있는지 확인
        if(cached[n] > 0)
            return cached[n];

        //캐시된 값이 없으면 계산하고
        //f(n) = f(n - 1) + f(n - 2)
        int fib = fib(n - 1, cached) + fib(n - 2, cached);

        //캐시에 저장
        cached[n] = fib;

        return fib;
    }
}
