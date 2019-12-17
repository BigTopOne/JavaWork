
public class Solution {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            this.val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode pre = new ListNode(0);
        ListNode cur = pre;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;

            int sum = x + y + carry;
            // 商
            carry = sum / 10;
            // 余数
            sum = sum % 10;
            cur.next = new ListNode(sum);
            cur = cur.next;
            // 链表后移
            if (l1 != null) {
                l1 = l1.next;
            }

            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry == 1) {
            cur.next = new ListNode(carry);
        }
        return pre.next;
    }

    /*
     * input :(2->4->3)+(5->6->4)
     * output:7->0->8
     *
     * 第一次：
     *    int x =
     *
     *
     *
     *
     *
     *
     *
     */
}
