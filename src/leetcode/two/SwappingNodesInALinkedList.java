package leetcode.two;

public class SwappingNodesInALinkedList {

    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    int cnt = 1;

    public ListNode swapNodes(ListNode head, int k) {
        //k - 1번째 노드 찾기
        ListNode slow1 = head;
        for(int i = 1; i < k - 1; i++) {
            slow1 = slow1.next;
        }

        ListNode slow2 = findNthNodeFromEnd(head, k);

        ListNode current1 = slow1.next;
        ListNode fast1 = current1 == null ? null : current1.next;
        ListNode current2 = slow2.next;
        ListNode fast2 = current2 == null ? null : current2.next;

        slow1 = current2;
        slow2 = fast2;
        current2 = current1;

        return head;
    }

    private ListNode findNthNodeFromEnd(ListNode head, int k) {
        //마지막 노드이면 head return
        //cnt == k + 1이면 head return

        if(head.next == null)
            return head;

        ListNode node = findNthNodeFromEnd(head.next, k);

        cnt++;

        if(cnt <= k + 1)
            return head;
        else
            return node;
    }

}
