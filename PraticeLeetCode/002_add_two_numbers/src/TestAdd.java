import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class TestAdd {
    @Test
    public void addTwoNumbers() {
        Solution.ListNode l1 = generateListNode(2, 4, 3);
        Solution.ListNode l2 = generateListNode(5, 6, 4);
        Solution solution = new Solution();
        Solution.ListNode curr = solution.addTwoNumbers(l1, l2);
        while (curr != null) {
            int val = curr.val;
            System.out.println("val :" + val);
            curr = curr.next;
        }
    }

    private Solution.ListNode generateListNode(int val1, int val2, int val3) {
        Solution.ListNode thirdNode = new Solution.ListNode(val3);
        Solution.ListNode secondNode = new Solution.ListNode(val2);
        Solution.ListNode firstNode = new Solution.ListNode(val1);
        firstNode.next = secondNode;
        secondNode.next = thirdNode;
        return firstNode;
    }
}