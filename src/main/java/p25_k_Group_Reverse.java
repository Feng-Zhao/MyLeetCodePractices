import java.util.Queue;

public class p25_k_Group_Reverse {
    //scan twice
    public ListNode sol_1(ListNode head, int k) {
        if(k == 1 || head == null || head.next == null)
            return head;
        ListNode start = head;
        ListNode tail = head;
        ListNode tempHead = head.next;
        int count = 1;
        boolean hasSetStart = false;
        while(head != null){
            if(count % k != 0){

            }
        }
    }

    public ListNode reverseKGroup(ListNode first, ListNode second, int k){
        ListNode head = reverseKGroup()
    }
}
