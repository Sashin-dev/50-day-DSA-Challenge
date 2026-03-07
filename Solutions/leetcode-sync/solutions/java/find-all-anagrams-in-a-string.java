class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        if (s.length() < p.length())
            return List.of();

        List<Integer> list = new ArrayList<>();

        int[] freqPArr = new int[26];
        for (char c : p.toCharArray()) {
            freqPArr[c - 'a']++;
        }

        int left = 0;
        int right = 0;
        int[] currFreqArr = new int[26];

        // ---- MAIN WINDOW LOOP: right walks across s
        while (right < s.length()) {
            // expand window by including s[right]
            currFreqArr[s.charAt(right) - 'a']++;
            right++;

            // shrink from left if window is too big
            if (right - left > p.length()) {
                currFreqArr[s.charAt(left) - 'a']--;
                left++;
            }

            // when window size equals p.length(), compare frequencies
            if (right - left == p.length()) {
                if (isSame(freqPArr, currFreqArr)) {
                    list.add(left);
                }
            }
        }

        return list;
    }

    // ---- NEW: helper to compare two freq arrays
    private boolean isSame(int[] a, int[] b) {
        for (int i = 0; i < 26; i++) {
            if (a[i] != b[i])
                return false;
        }
        return true;
    }

}