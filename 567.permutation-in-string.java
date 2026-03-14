/*
 * @lc app=leetcode id=567 lang=java
 *
 * [567] Permutation in String
 *
 * https://leetcode.com/problems/permutation-in-string/description/
 *
 * algorithms
 * Medium (48.48%)
 * Likes:    12948
 * Dislikes: 519
 * Total Accepted:    1.4M
 * Total Submissions: 3M
 * Testcase Example:  '"ab"\n"eidbaooo"'
 *
 * Given two strings s1 and s2, return true if s2 contains a permutation of s1,
 * or false otherwise.
 * 
 * In other words, return true if one of s1's permutations is the substring of
 * s2.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: s1 = "ab", s2 = "eidbaooo"
 * Output: true
 * Explanation: s2 contains one permutation of s1 ("ba").
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: s1 = "ab", s2 = "eidboaoo"
 * Output: false
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= s1.length, s2.length <= 10^4
 * s1 and s2 consist of lowercase English letters.
 * 
 * 
 */

// @lc code=start

import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length())
            return false;

        int left = 0;
        Map<Character, Integer> s1FreqMap = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            s1FreqMap.merge(s1.charAt(i), 1, Integer::sum);
        }

        for (int right = 0; right < s2.length(); right++) {
            Character input = s2.charAt(right);
            if (s1FreqMap.getOrDefault(input, 0) > 0) {
                s1FreqMap.merge(input, -1, Integer::sum);
            }

            if (right - left + 1 > s1.length()) {
                Character out = s2.charAt(left++);
                s1FreqMap.merge(out, 1, Integer::sum);
            }

            if (right - left + 1 == s1.length()) {
                if (s1FreqMap.values().stream().allMatch(val -> val == 0)) {
                    return true;
                }
            }

        }

        return false;
    }
}
// @lc code=end
