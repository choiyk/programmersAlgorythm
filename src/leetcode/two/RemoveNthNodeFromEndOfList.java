package leetcode.two;

public class RemoveNthNodeFromEndOfList {

    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    int cnt = 1;

    public ListNode removeNthFromEnd(ListNode head, int n) {
        //끝에서부터 cnt를 센다.
        //cnt==n이면 return 받은 리스트를 return
        //n+1번 째에서는 나의 next를 return받은 리스트로 연결
        //아니면 넘어감

        //마지막 리스트일때
        if(head.next == null) {
            if(n == 1)
                return null;
            else
                return head;
        }

        ListNode node = removeNthFromEnd(head.next, n);

        cnt++;

        if(cnt == n) {
            head.next = null;
            return node;
        }
        else if(cnt == n + 1) {
            head.next = node;
            return head;
        }
        else {
            return head;
        }
    }

}
