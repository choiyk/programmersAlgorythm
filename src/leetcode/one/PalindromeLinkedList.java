package leetcode.one;

public class PalindromeLinkedList {

    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public boolean isPalindrome(ListNode head) {
        //가운데 노드를 찾는다.
        //fast 노드가 2칸 가면 slow 노드는 1칸 간다.
        ListNode fast = head;
        ListNode middle = head;
        int middleCnt = 0;

        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            middle = middle.next;
            middleCnt++;
        }

        //가운데 노드부터 마지막 노드까지 돌면서 reverse 한다.
        ListNode prev = middle;
        ListNode current = middle.next;

        while(current != null) {
            ListNode next = current.next;

            current.next = prev; //현재 노드의 다음 노드는 이전 노드가 된다.
            prev = current; //이전 노드 커서 이동
            current = next; //현재 노드 커서 이동
        }

        ListNode last = prev;

        //head와 가운데 노드부터 차례대로 비교한다.
        for(int i = 0; i < middleCnt; i++) {
            if(head.val != last.val)
                return false;

            head = head.next;
            last = last.next;
        }

        return true;
    }
}
