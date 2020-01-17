import java.awt.image.TileObserver;
import java.util.List;

public class p24_Swap_Nodes_in_Pairs {
    public ListNode sol_1(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode left = head, right = head.next;
        ListNode start = new ListNode(0);
        ListNode temp = start;
        while(left != null && right != null) {
            temp.next = right;
            left.next = right.next;
            right.next = left;
            temp = left;
            left = left.next;
            right = left!=null?left.next:null;
        }
        return start.next;
    }
    //recursive solution
    public ListNode swapPairs(ListNode head) {
        if ((head == null)||(head.next == null))
            return head;
        ListNode n = head.next;
        head.next = swapPairs(head.next.next);
        n.next = head;
        return n;
    }

    static public void main(String[] arg){
        p24_Swap_Nodes_in_Pairs sol = new p24_Swap_Nodes_in_Pairs();
        ListNode a = new ListNode(1);
        ListNode start = a;
        a.next = new ListNode(2);
        a = a.next;
        a.next = new ListNode(3);
        a = a.next;
        a.next = new ListNode(4);
        a=a.next;
        a.next = null;

        ListNode res = sol.sol_1(start);
        while(res != null){
            System.out.println(res.val);
            res = res.next;
        }
    }
}
