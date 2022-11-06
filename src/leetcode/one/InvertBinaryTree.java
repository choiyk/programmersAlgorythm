package leetcode.one;

public class InvertBinaryTree {

    public TreeNode invertTree(TreeNode root) {
        invert(root);
        return root;
    }

    public void invert(TreeNode node) {
        //종료 : node가 null이면 작업할 필요가 없다.
        if(node == null)
            return;

        //root 노드의 왼쪽 자식과 오른쪽 자식을 바꿔준다.
        TreeNode left = node.left;
        TreeNode right = node.right;
        node.left = right;
        node.right = left;

        //왼쪽 자식 invert
        invert(node.left);

        //오른쪽 자식 invert
        invert(node.right);
    }

}
