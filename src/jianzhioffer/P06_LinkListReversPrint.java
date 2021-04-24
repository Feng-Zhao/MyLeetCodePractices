package jianzhioffer;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

import CommonDataStructure.ListNode;

public class P06_LinkListReversPrint {
    /**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
    public int[] reversePrint(ListNode head) {
        Deque<Integer> dq = new LinkedList<>();
        while (head != null ){
            dq.offerFirst(head.val);
            head = head.next;
        }
        int[] array = dq.stream().mapToInt(Integer::intValue).toArray();
        return array;

    }
}
