package leetcode.one;

import javax.swing.tree.TreeNode;
import java.util.LinkedList;
import java.util.Queue;

public class MergeTwoBinaryTrees {

     public class TreeNode {
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
         final Queue<TreeNode> t1Queue = new LinkedList<>(); //1번 트리 앞으로 방문할 노드
         final Queue<TreeNode> t2Queue = new LinkedList<>(); //2번 트리 앞으로 방문할 노드

        t1Queue.add(root1);
        t2Queue.add(root2);

        while(!t1Queue.isEmpty() && !t2Queue.isEmpty()) {
            TreeNode t1 = t1Queue.poll();
            TreeNode t2 = t2Queue.poll();

            //두 트리 노드의 값을 t1에 더해준다.
            t1.val += t2.val;

            //t2의 자식 노드가 하나라도 있다면 t1의 자식 노드는 모두 있어야 한다.
            if(t2.left != null || t2.right != null) {
                if(t1.left == null) {
                    TreeNode newNode = new TreeNode();
                    t1.left = newNode;
                }

                if(t1.right == null) {
                    TreeNode newNode = new TreeNode();
                    t1.right = newNode;
                }
            }

            //두 트리 모두 왼쪽 자식 노드가 있으면 방문할 노드 큐에 넣음
            if(t1.left != null && t2.left != null) {
                t1Queue.add(t1.left);
                t2Queue.add(t2.left);
            }

            //두 트리 모두 오른쪽 자식 노드가 있으면 방문할 노드 큐에 넣음
            if(t1.right != null && t2.right != null) {
                t1Queue.add(t1.right);
                t2Queue.add(t2.right);
            }
        }

        return root1;
    }

    public TreeNode mergeTrees2(TreeNode root1, TreeNode root2) {
         //둘 다 빈 트리일 때
        if(root1 == null && root2 == null)
            return null;

        //한 쪽만 존재할 때
        if(root1 == null)
            return root2;

        if(root2 == null)
            return root1;

        //양쪽 다 존재할 때
        //값 더하기
        TreeNode mergeNode = new TreeNode(root1.val + root2.val);

        //왼쪽 자식 merge
        mergeNode.left = mergeTrees2(root1.left, root2.left);

        //오른쪽 자식 merge
        mergeNode.right = mergeTrees2(root1.right, root2.right);

        return mergeNode;
    }

}
