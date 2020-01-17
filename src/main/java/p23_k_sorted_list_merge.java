import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class p23_k_sorted_list_merge {
    public ListNode sol_1(ListNode[] lists) {
        if(lists.length == 0){
            return null;
        }
        if(lists.length == 1){
            return lists[0];
        }
        ListNode head = lists[0];
        for (int i = 1; i < lists.length; i++) {
            head = mergeTwoLists(head,lists[i]);
        }
        return head;
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2){
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        if(l1.val < l2.val){
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else{
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }


    //use priorityQueue
    //comes from https://leetcode.com/problems/merge-k-sorted-lists/discuss/10809/13-lines-in-Java
    public ListNode sol_2(ListNode[] lists) {
//        if (lists==null||lists.length ==0) return null;

        Queue<ListNode> heap = new PriorityQueue(new Comparator<ListNode>(){
            @Override public int compare(ListNode l1, ListNode l2) {
                return l1.val - l2.val;
            }
        });
        ListNode head = new ListNode(0), tail = head;
        for (ListNode node : lists) if (node != null) heap.offer(node);
        while (!heap.isEmpty()) {
            tail.next = heap.poll();
            tail = tail.next;
            if (tail.next != null) heap.offer(tail.next);
        }
        return head.next;
    }
}
