public class p2_Add_two_numbers {
    public ListNode sol_1(ListNode l1, ListNode l2) {
        ListNode res_head = new ListNode(0);
        ListNode res_tile = res_head;
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            int a;
            int b;
            int c;
            a = l1 == null ? 0 : l1.val;
            b = l2 == null ? 0 : l2.val;
            c = a + b + carry;
            if (c > 9) {
                c = c - 10;
                carry = 1;
            } else {
                carry = 0;
            }
            res_tile.next = new ListNode(c);
            res_tile = res_tile.next;
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }
        return res_head.next;
    }

    static public void main(String[] arg) {
        ListNode l1 = new ListNode(0);
        ListNode l2 = new ListNode(5);
        ListNode l1_tile = l1;
        ListNode l2_tile = l2;

        l1_tile.next = new ListNode(4);
        l1_tile = l1_tile.next;
        l1_tile.next = new ListNode(3);

        l2_tile.next = new ListNode(6);
        l2_tile = l2_tile.next;
        l2_tile.next = new ListNode(4);
        l2_tile = l2_tile.next;
        l2_tile.next = new ListNode(4);

        p2_Add_two_numbers solution = new p2_Add_two_numbers();
        ListNode res = solution.sol_1(l1, l2);
        while (res != null) {
            System.out.print(res.val);
            System.out.print("->");
            res = res.next;
        }
    }

}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}


