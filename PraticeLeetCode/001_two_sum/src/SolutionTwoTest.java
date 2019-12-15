import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTwoTest {
    @Test
    void two() {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        Solution solution = new Solution();
        int[] result = solution.two(nums, target);
        int[] okArr = {0, 1};
        assertArrayEquals(okArr, result);
    }
}