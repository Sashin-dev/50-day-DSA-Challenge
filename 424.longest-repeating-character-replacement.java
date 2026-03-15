/*
 * @lc app=leetcode id=424 lang=java
 *
 * [424] Longest Repeating Character Replacement
 *
 * https://leetcode.com/problems/longest-repeating-character-replacement/description/
 *
 * algorithms
 * Medium (59.12%)
 * Likes:    12936
 * Dislikes: 760
 * Total Accepted:    1.5M
 * Total Submissions: 2.5M
 * Testcase Example:  '"ABAB"\n2'
 *
 * You are given a string s and an integer k. You can choose any character of
 * the string and change it to any other uppercase English character. You can
 * perform this operation at most k times.
 * 
 * Return the length of the longest substring containing the same letter you
 * can get after performing the above operations.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: s = "ABAB", k = 2
 * Output: 4
 * Explanation: Replace the two 'A's with two 'B's or vice versa.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: s = "AABABBA", k = 1
 * Output: 4
 * Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
 * The substring "BBBB" has the longest repeating letters, which is 4.
 * There may exists other ways to achieve this answer too.
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= s.length <= 10^5
 * s consists of only uppercase English letters.
 * 0 <= k <= s.length
 * 
 * 
 */

// @lc code=start

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> freqMap = new HashMap<>();
        int left = 0;
        int maxFreqSoFar = 0;
        int result = 0;

        for (int right = 0; right < s.length(); right++) {
            Character in = s.charAt(right);
            freqMap.merge(in, 1, Integer::sum);

            maxFreqSoFar = Math.max(freqMap.get(in), maxFreqSoFar);
            if (right - left + 1 - maxFreqSoFar > k) {
                freqMap.merge(s.charAt(left++), -1, Integer::sum);
            }

            result = Math.max(result, right - left + 1);
        }
        return result;
    }
}
// @lc code=end
