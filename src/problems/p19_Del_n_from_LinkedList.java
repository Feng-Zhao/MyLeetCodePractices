package problems;

import CommonDataStructure.ListNode;

public class p19_Del_n_from_LinkedList {
    public ListNode sol_1(ListNode head, int n) {
        ListNode first = head;
        ListNode target = head;
        int count = 0;
        while(first != null){
            first = first.next;
            if(count > n){
                target = target.next;
            }
            count++;
        }
        ListNode temp = target.next;
        if(count > n){
            target.next = temp.next;
            return head;
        }
        else{
            return head.next;
        }
    }
}
