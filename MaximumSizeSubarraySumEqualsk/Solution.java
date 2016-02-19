/*

medium
tag: hashmap, preSum
similar: continuous array sum
Given an array nums and a target value k, find the maximum length of a subarray that sums to k. If there isn't one, return 0 instead.

eg : Given nums = [1, -1, 5, -2, 3], k = 3, return 4. (because the subarray [1, -1, 5, -2] sums to 3 and is the longest)
参考的discuss里面的1-pass解法, link
思路和我的类似, 也是在hashmap里面找sum-k的index, 但就是写得好. 我修改了一下, 即使用virtual preSum: 0存在-1的位置. 这在array, list, graph里面经常使用, 统一解决边界问题.
代码如下, 注意sum只存1次, 因为是找max length, 所以是最远距离, 所以保存第一次出现的位置.
*/
import java.util.*;
public class Solution {
  public int maxSubArrayLen(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int sum = 0;
        int result = 0;
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k)) {
                result = Math.max(result, i - map.get(sum - k));
            }
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }
        return result;
    }
}
