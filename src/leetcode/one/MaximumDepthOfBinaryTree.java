package leetcode.one;

public class MaximumDepthOfBinaryTree {

    /*
    이건 매번 밑에서부터 계산한걸 더해와서 시간이 더 오래 걸리는 걸까?
     */
    public int maxDepth(TreeNode root) {
        //종료 : node가 null이면 0을 return
        if(root == null)
            return 0;

        //왼쪽 자식 depth count 계산
        int leftDepthCnt = 1; //depth count
        leftDepthCnt += maxDepth(root.left);

        //오른쪽 자식 depth count 계산
        int rightDepthCnt = 1;
        rightDepthCnt += maxDepth(root.right);

        //둘 중 더 큰 값을 return
        return Math.max(leftDepthCnt, rightDepthCnt);
    }

    public int maxDepth2(TreeNode root) {
        //종료 : node가 null이면 0을 return
        if(root == null)
            return 0;

        //왼쪽 자식 depth count 계산
        int leftDepthCnt = 1 + maxDepth2(root.left);

        //오른쪽 자식 depth count 계산
        int rightDepthCnt = 1 + maxDepth2(root.right);

        //둘 중 더 큰 값을 return
        return Math.max(leftDepthCnt, rightDepthCnt);
    }

}
