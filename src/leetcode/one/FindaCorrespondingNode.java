package leetcode.one;

public class FindaCorrespondingNode {

    TreeNode answer = null;

    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        //클론 트리를 탐색하며 target의 값과 같은 트리를 만나면 return

        searchTree(cloned, target);

        return answer;
    }

    private void searchTree(TreeNode node, TreeNode target) {
        //종료 조건 : node가 null이면 탐색 종료
        if(node == null)
            return;

        //종료 조건 : 현재 노드의 값이 target과 일치하면 종료
        if(node.val == target.val) {
            answer = node;
            return;
        }

        //왼쪽 자식 노드 방문
        searchTree(node.left, target);

        //오른쪽 자식 노드 방문
        searchTree(node.right, target);
    }

}
