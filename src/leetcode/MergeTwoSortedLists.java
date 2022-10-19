package leetcode;

public class MergeTwoSortedLists {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        //두 리스트 중 작은 값을 선택하는 작업을 반복한다.

        //더 이상 선택할 리스트가 없을 경우 작업이 끝난다.
        if(list1 == null && list2 == null)
            return null;

        //한 쪽에만 리스트가 남아있다면 남아있는 리스트를 반환
        if(list1 == null)
            return list2;

        if(list2 == null)
            return list1;

        //둘 다 리스트가 있으면 둘 중 더 작은 값을 선택
        ListNode firstNode;
        if(list1.val < list2.val) {
            firstNode = list1;
            list1 = list1.next;
        }
        else {
            firstNode = list2;
            list2 = list2.next;
        }

        //다음 노드 연결
        firstNode.next = mergeTwoLists(list1, list2);

        return firstNode;
    }

}
