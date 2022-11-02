package leetcode;

public class HouseRobber {

    public int rob(int[] nums) {
        return robDFS(nums, nums.length - 1);
    }

    private int robDFS(int[] nums, int idx) {
        //종료 : idx가 0보다 작을 때
        if(idx < 0)
            return 0;

        int case1 = nums[idx] + robDFS(nums, idx - 2);
        int case2 = robDFS(nums, idx - 1);

        return Math.max(case1, case2);
    }

    public int rob2(int[] nums) {
        int[] cache = new int[nums.length + 1];

        cache[0] = 0;
        cache[1] = nums[0];

        for(int i = 2; i < cache.length; i++) {
            cache[i] = Math.max(cache[i - 1], nums[i - 1] + cache[i - 2]);
        }

        return cache[cache.length - 1];
    }

}
