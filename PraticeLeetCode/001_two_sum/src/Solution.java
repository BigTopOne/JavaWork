import java.util.HashMap;

public class Solution {

    public int[] two(int[] nums, int target) {
        if (nums == null) {
            throw new NullPointerException("The raw array can`t be null.");
        }
        int length = nums.length;
        if (length == 0) {
            return new int[0];

        }
        int arrLength = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arrLength; i++) {
            int temp = nums[i];
            final Integer value = map.get(temp);
            if (value != null) {
                return new int[]{value, i};
            }
            map.put(target - temp, i);
        }
        return null;

    }
}
