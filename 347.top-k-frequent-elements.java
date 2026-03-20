/*
 * @lc app=leetcode id=347 lang=java
 *
 * [347] Top K Frequent Elements
 *
 * https://leetcode.com/problems/top-k-frequent-elements/description/
 *
 * algorithms
 * Medium (65.94%)
 * Likes:    19399
 * Dislikes: 853
 * Total Accepted:    3.5M
 * Total Submissions: 5.3M
 * Testcase Example:  '[1,1,1,2,2,3]\n2'
 *
 * Given an integer array nums and an integer k, return the k most frequent
 * elements. You may return the answer in any order.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [1,1,1,2,2,3], k = 2
 * 
 * Output: [1,2]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [1], k = 1
 * 
 * Output: [1]
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: nums = [1,2,1,2,1,2,3,1,3,2], k = 2
 * 
 * Output: [1,2]
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= nums.length <= 10^5
 * -10^4 <= nums[i] <= 10^4
 * k is in the range [1, the number of unique elements in the array].
 * It is guaranteed that the answer is unique.
 * 
 * 
 * 
 * Follow up: Your algorithm's time complexity must be better than O(n log n),
 * where n is the array's size.
 * 
 */

import java.util.*;

import java.util.function.Function;

import java.util.stream.Collectors;

// @lc code=start
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int n : nums)
            countMap.merge(n, 1, Integer::sum);

        // bucket[i] = list of numbers that appear i times
        List<Integer>[] bucket = new List[nums.length + 1];
        for (Map.Entry<Integer, Integer> e : countMap.entrySet()) {
            int freq = e.getValue();
            if (bucket[freq] == null)
                bucket[freq] = new ArrayList<>();
            bucket[freq].add(e.getKey());
        }

        int[] res = new int[k];
        int idx = 0;
        // iterate from highest frequency down
        for (int i = bucket.length - 1; i >= 0 && idx < k; i--) {
            if (bucket[i] == null)
                continue;
            for (int num : bucket[i])
                res[idx++] = num;
        }
        return res;
    }
}
// @lc code=end
