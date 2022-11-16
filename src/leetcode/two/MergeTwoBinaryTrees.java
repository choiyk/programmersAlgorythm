package leetcode.two;

import org.w3c.dom.Node;

public class MergeTwoBinaryTrees {

    class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode() {}
       TreeNode(int val) { this.val = val; }
       TreeNode(int val, TreeNode left, TreeNode right) {
           this.val = val;
           this.left = left;
           this.right = right;
       }
    }

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        //둘 다 null이면 종료
        if(root1 == null && root2 == null)
            return null;

        //한쪽이 null이면 null이 아닌 트리 return
        if(root1 == null)
            return root2;
        else if(root2 == null)
            return root1;

        //두 값을 더한 새로운 노드 생성
        TreeNode node = new TreeNode(root1.val + root2.val);

        //자식 노드 계산
        node.left = mergeTrees(root1.left, root2.left);

        node.right = mergeTrees(root1.right, root2.right);

        //새로운 노드 반환
        return node;
    }

}
