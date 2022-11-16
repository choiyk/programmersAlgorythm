package leetcode.two;

public class DeleteNodeInABST {

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

    public TreeNode makeNode(int val) {
        TreeNode node = new TreeNode(val);
        return node;
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null)
            return null;

        //트리를 순회하며 key에 해당하는 노드 찾기
        TreeNode parent = null;
        TreeNode current = root;

        while(current != null && current.val != key) {
            if(key > current.val) {
                parent = current;
                current = current.right;
            }
            else if(key < current.val) {
                parent = current;
                current = current.left;
            }
        }

        //key가 없을 때
        if(current == null)
            return root;

        root = deleteNode(root, parent, current);

        return root;
    }

    private TreeNode deleteNode(TreeNode root, TreeNode parent, TreeNode current) {
        TreeNode node = null;

        //자식 노드가 없으면 현재 자리를 null로 만든다.
        if(current.left == null && current.right == null) {

        }

        //자식 노드가 하나면 그 자식 노드로 교체한다.
        else if(current.left == null || current.right == null) {
            if(current.left == null) {
                node = current.right;
                current.right = null;
            }
            else if(current.right == null) {
                node = current.left;
                current.left = null;
            }
        }

        //자식 노드가 둘 다 있으면 왼쪽 자식의 가장 큰 값으로 교체한다.
        else {
            TreeNode preNode = current;
            node = current.left;

            while(node.right != null) {
                preNode = node;
                node = node.right;
            }

            if(preNode == current)
                preNode.left = null;
            else
                preNode.right = null;

            node.left = current.left;
            node.right = current.right;

            current.left = null;
            current.right = null;
        }

        if(parent == null)
            root = node;
        else if(current.val < parent.val)
            parent.left = node;
        else
            parent.right = node;

        return root;
    }
}
