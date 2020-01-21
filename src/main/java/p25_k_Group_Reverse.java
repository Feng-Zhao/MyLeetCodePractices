
public class p25_k_Group_Reverse {
    //scan twice
    public ListNode sol_1(ListNode head, int k) {
        if(k == 1 || head == null || head.next == null)
            return head;
        ListNode start = new ListNode(0);
        ListNode cur = start;
        cur.next = head;
        int count = 0;
        while(cur != null){
            if(count % k == 0){
                cur.next = reverseKGroup(cur.next,k,k);
            }
            cur = cur.next;
            count++;
        }
        return start.next;
    }

    public ListNode reverseKGroup(ListNode head, int k, int needToReverse){
        if(head == null){
            return head;
        }
        if(needToReverse == 2){
            return swapPairs(head);
        }
        else if(needToReverse > 2 && needToReverse <= k){
            ListNode cur = head;
            int preCount = 1;
            while (preCount != needToReverse){
                if(cur.next == null){
                    return head;
                }
                cur = cur.next;
                preCount++;
            }

            ListNode res = reverseKGroup(head.next,k,needToReverse-1);
            ListNode temp = res;
            int count = 2;
            while(count != needToReverse && temp.next != null){
                temp = temp.next;
                count++;
            }
            head.next = temp.next;
            temp.next = head;
            return res;
        }
        return null;
    }

    public ListNode swapPairs(ListNode head) {
        if ((head == null)||(head.next == null))
            return head;
        ListNode n = head.next;
        head.next = n.next;
        n.next = head;
        return n;
    }

    static public void main(String[] arg){
        p25_k_Group_Reverse sol = new p25_k_Group_Reverse();
        ListNode a = new ListNode(1);
        ListNode start = a;
        a.next = new ListNode(2);
        a = a.next;
        a.next = new ListNode(3);
        a = a.next;
//        a.next = new ListNode(4);
//        a=a.next;
//        a.next = new ListNode(5);
//        a = a.next;
        a.next = null;
        int k = 3;

        ListNode res = sol.sol_1(start,k);
        while(res != null){
            System.out.println(res.val);
            res = res.next;
        }
    }
}
