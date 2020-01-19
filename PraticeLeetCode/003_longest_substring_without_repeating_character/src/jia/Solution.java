package jia;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    /**
     * 1：定义一个 map 数据结构（k,v），其中 key的值，为字符，value 值为字符位置+1，加 1 表示从字符位置后一个才开始不重复
     * 2：我们定义不重复子串的开始位置为 start ，结束位置为 end；
     * 3：随着 end 不断遍历向后，会遇到与[start,end]区间内字符相同的情况，此时将字符串作为 key 值，获取 value 值，并更新 start，此时[start,end]
     * 区间不存在重复字符；
     * @param s raw string data.
     * @return the index.
     * @see <a href = "https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/solution/hua-jie-suan-fa-3-wu-zhong-fu-zi-fu-de-zui-chang-z/">
     * 原作者写的代码</a>
     */
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int ans = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int end = 0, start = 0; end < n; end++) {
            char alpha = s.charAt(end);
            if (map.containsKey(alpha)) {
                start = Math.max(map.get(alpha), start);
            }

            ans = Math.max(ans, end - start + 1);
            map.put(s.charAt(end), end + 1);
        }
        return ans;

    }
}
