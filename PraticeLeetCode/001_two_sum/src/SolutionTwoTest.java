import org.junit.jupiter.api.Test;
import org.omg.PortableInterceptor.INACTIVE;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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

    /**
     * 2018 年 年底 的面试题；
     */
    @Test
    public void testTwo() {
        int[] rawData = {1, 2, 3, 4, 5, 6};
        int begin = 1;
        int end = 4;
        System.out.println("raw    : " + Arrays.toString(rawData));

        int[] result = convertArr(rawData, begin, end);
        System.out.println("result : " + Arrays.toString(result));
    }

    private int[] convertArr(int[] rawData, int begin, int end) {
        int[] subArr = getSubArr(rawData, begin, end);
        int index = begin;
        for (int i : subArr) {
            rawData[index] = i;
            index++;
        }
        // System.out.println("subArr : " + Arrays.toString(subArr));
        return rawData;
    }

    //  System.arraycopy(rawData, 0, result, 0, begin);
    private int[] getSubArr(int[] rawData, int begin, int end) {
        int length = rawData.length;
        int[] newArr = new int[end - begin + 1];

        int j = 0;
        for (int i = end; i >= begin; i--) {
            newArr[j] = rawData[i];
            j++;
        }
        return newArr;
    }
}