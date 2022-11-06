package leetcode.one;

public class ReverseLinkedList {

    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode reverseList(ListNode head) {
        ListNode current = head; //현재 노드를 가리키는 커서
        ListNode prev = null; //이전 노드를 가리키는 커서

        while(current != null) {
            ListNode next = current.next; //다음 노드를 가리키는 임시 변수

            //swap
            current.next = prev; //현재 노드의 다음 노드는 이전 노드가 된다.
            prev = current; //이전 노드의 커서는 현재 노드의 위치로 옮긴다.
            current = next; //현재 위치의 커서는 다음 노드로 옮긴다.
        }

        //current는 null이다.
        return prev;
    }
}
