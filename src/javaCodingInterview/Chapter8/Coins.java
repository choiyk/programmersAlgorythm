package javaCodingInterview.Chapter8;

public class Coins {

    private int[] coins = {25, 10, 5, 1};

    public int solution(int n) {
        return compute(n, 0);
    }

    public int solution2(int n) {
        int[] cache = new int[n+1];
        cache[1] = 1;
        cache[2] = 1;
        cache[3] = 1;
        cache[4] = 1;
        int answer = computeMemoization(n, 0, cache);
        return answer;
    }

    private int compute(int amount, int coin) {
        if(amount <= 0 || coin >= coins.length-1) return 1;

        int cnt = 0;
        for(int i=0; i * coins[coin] <= amount; i++){
            cnt += compute(amount - (i * coins[coin]), coin + 1);
        }

        return cnt;
    }

    private int computeMemoization(int amount, int coin, int[] cache) {
        if(amount <= 0 || coin >= coins.length-1) return 1;

        if(cache[amount] > 0) return cache[amount];

        int cnt = 0;
        for(int i=0; i * coins[coin] <= amount; i++) {
            int remain = amount - (i * coins[coin]);
            cnt += computeMemoization(remain, coin + 1, cache);
        }

        cache[amount] = cnt;

        return cnt;
    }
}