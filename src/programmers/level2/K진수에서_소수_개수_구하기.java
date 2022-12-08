package programmers.level2;

public class K진수에서_소수_개수_구하기 {

    private boolean[] prime;

    public int solution(int n, int k) {
        //n을 k진수 문자열로 변환
        //0을 기준으로 나눔
        //각 수가 소수인지 확인

        String s = Integer.toString(n, k);
        String[] nums = s.split("0");

        int result = 0;

        for(String str : nums) {
            if(str.length() < 1)
                continue;

            final long num = Long.valueOf(str);

            if(isPrime(num))
                result++;
        }

        return result;
    }

    private boolean isPrime(long n) {
        if(n < 2)
            return false;

        if(n == 2)
            return true;

        for(long i = 2; i * i <= n; i++) {
            if(n % i == 0)
                return false;
        }

        return true;
    }

    //시간복잡도가 O(Nlog(logN))으로 가장 좋지만 여기선 쓸 수 없음
    public void computePrime(int n) {
        prime = new boolean[n + 1];

        //2 미만의 n이면 소수가 없음
        if(n < 2)
            return;

        //0과 1은 소수가 아니다
        prime[0] = prime[1] = true;

        //n의 제곱근까지만 계산한다
        for(int i = 2; i * i <= n; i++) {
            //이미 계산되어있으면 넘어감
            if(prime[i])
                continue;

            //i의 배수들은 다 소수가 아님
            //시작이 i*2가 아닌 이유는 앞에서 이미 다 걸러졌기때문
            for(int j = i * i; j < prime.length; j = j + i) {
                prime[j] = true;
            }
        }
    }
}
