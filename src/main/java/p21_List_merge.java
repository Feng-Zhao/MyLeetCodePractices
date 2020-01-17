public class p21_List_merge {
    public ListNode sol_1(ListNode l1, ListNode l2) {
        ListNode a = l1;
        ListNode b = l2;
        ListNode head = new ListNode(0);
        ListNode cur = head;
        while(a != null && b != null){
            if(a.val < b.val){
                cur.next = a;
                a = a.next;
            }
            else{
                cur.next = b;
                b = b.next;
            }
            cur = cur.next;
        }
        if(a != null){
            cur.next = a;
        }
        else if(b != null){
            cur.next = b;
        }
        return head.next;
    }

    //recursive solution
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
}

