package problems;

import CommonDataStructure.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class p23_k_sorted_list_merge {
    public ListNode sol_1(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        if (lists.length == 1) {
            return lists[0];
        }
        ListNode head = lists[0];
        for (int i = 1; i < lists.length; i++) {
            head = mergeTwoLists(head, lists[i]);
        }
        return head;
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }


    //use priorityQueue
    //comes from https://leetcode.com/problems/merge-k-sorted-lists/discuss/10809/13-lines-in-Java
    public ListNode sol_2(ListNode[] lists) {
//        if (lists==null||lists.length ==0) return null;

        Queue<ListNode> heap = new PriorityQueue(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode l1, ListNode l2) {
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

    //improved by controlling the length of each sub problem
    //comes from https://leetcode.com/problems/merge-k-sorted-lists/discuss/10805/Beat-94.84-3ms-divide-conquer-Java-solution!
    public ListNode sol_3(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        return reduce(map(lists, 0, lists.length / 2), map(lists, lists.length / 2 + 1, lists.length - 1));
    }

    private ListNode map(ListNode[] lists, int from, int to) {
        if (from > to) {
            return null;
        }
        if (from == to) {
            return lists[from];
        }
        if (from + 1 == to) {
            return reduce(lists[from], lists[to]);
        }
        return reduce(map(lists, from, (from + to) / 2), map(lists, (from + to) / 2 + 1, to));
    }

    private ListNode reduce(ListNode first, ListNode second) {
        if (first == null) {
            return second;
        }
        if (second == null) {
            return first;
        }
        ListNode head, pre;
        if (first.val < second.val) {
            head = first;
            pre = first;
            first = first.next;
        } else {
            head = second;
            pre = second;
            second = second.next;
        }
        while (true) {
            if (first == null) {
                pre.next = second;
                break;
            }
            if (second == null) {
                pre.next = first;
                break;
            }
            if (first.val < second.val) {
                pre.next = first;
                pre = pre.next;
                first = first.next;
            } else {
                pre.next = second;
                pre = pre.next;
                second = second.next;
            }
        }
        return head;
    }
}
