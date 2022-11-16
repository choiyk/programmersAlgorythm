package leetcode.two;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BalanceABinarySearchTree {

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

    List<TreeNode> list = new LinkedList<>();

    public TreeNode balanceBST(TreeNode root) {
        //트리의 노드를 순서대로 리스트에 넣는다.
        //중간 값을 root로 하고 순서대로 트리를 만든다.
        searchInOrder(root);
        return makeBalanceBST(0, list.size() - 1);
    }

    private void searchInOrder(TreeNode root) {
        //탐색할 노드가 없으면 종료
        if(root == null)
            return;

        TreeNode left = root.left;
        TreeNode right = root.right;

        //왼쪽 자식 방문
        searchInOrder(left);

        //현재 노드 방문
        root.left = null;
        root.right = null;

        list.add(root);

        //오른쪽 자식 방문
        searchInOrder(right);
    }

    private TreeNode makeBalanceBST(int start, int end) {
        //꺼낼 노드가 없으면 종료
        if(start > end)
            return null;

        //중간 노드 찾기
        final int middle = start + ((end - start) / 2);

        //중간 노드가 root가 되고,
        TreeNode root = list.get(middle);

        //양쪽 자식 노드 찾아 연결하기
        //중간 노드의 하위 그룹이 왼쪽 자식
        root.left = makeBalanceBST(start, middle - 1);
        //상위 그룹이 오른쪽 자식이 된다.
        root.right = makeBalanceBST(middle + 1, end);

        return root;
    }

}
