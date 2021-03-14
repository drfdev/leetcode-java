package dev.drf.leet.code.problems.task0002;

public class TaskMain {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode result = null;
            int temp = 0;
            ListNode rval = null;

            while (l1 != null || l2 != null) {
                int sum = getValue(l1) + getValue(l2) + temp;
                temp = sum / 10;
                sum = sum % 10;

                ListNode cval = new ListNode(sum);
                if (result == null) {
                    result = cval;
                    rval = cval;
                } else {
                    rval.next = cval;
                }

                l1 = l1 == null ? null : l1.next;
                l2 = l2 == null ? null : l2.next;
                rval = cval;
            }
            if (temp > 0) {
                rval.next = new ListNode(temp);
            }

            return result;
        }

        private int getValue(ListNode ln) {
            return ln != null ? ln.val : 0;
        }
    }
}
