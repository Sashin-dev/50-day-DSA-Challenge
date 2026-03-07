class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left=0;
        int right=0;
        Set<Character> set = new HashSet<>();
        int maxCharSoFar = 0;
        while(right<s.length()){
            char current= s.charAt(right);
            if(set.contains(current)){
                while(set.contains(current)){
                set.remove(s.charAt(left));
                left++;
                }
            }
            else{
                set.add(current);
                maxCharSoFar=Math.max(maxCharSoFar, right-left+1);
                right++;
            }
        }
        return maxCharSoFar;
    }
}