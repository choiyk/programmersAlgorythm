package leetcode.one;

public class MiddleOfTheLinkedList {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode middleNode(ListNode head) {
        ListNode currentNode = head;
        ListNode middelNode = head;
        int cnt = 0;

        while(currentNode != null) {
            if(cnt % 2 == 1)
                middelNode = middelNode.next;

            currentNode = currentNode.next;
            cnt++;
        }

        return middelNode;
    }

    public ListNode middleNode2(ListNode head) {
        if(head == null || head.next == null)
            return head;

        ListNode currentNode = head;
        ListNode middelNode = head;

        while(currentNode != null && currentNode.next != null) {
            currentNode = currentNode.next.next;
            middelNode = middelNode.next;
        }

        return middelNode;
    }

}
