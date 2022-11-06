package leetcode.one;

public class CountingBits {

    public int[] countBits(int n) {
        int[] ans = new int[n + 1];
        ans[0] = 0;

        if(n == 0)
            return ans;

        ans[1] = 1;
        int idx = 1; //계산할 기준 숫자 index
        for(int i = 2; i <= n; i++) {
            //홀수면 +1, 짝수면 +0
            if(i % 2 == 0)
                ans[i] = ans[idx];
            else {
                ans[i] = ans[idx] + 1;
                idx++; //기준 index 변경
            }
        }

        return ans;
    }

}
