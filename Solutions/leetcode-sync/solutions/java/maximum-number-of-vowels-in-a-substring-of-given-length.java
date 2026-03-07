class Solution {
    public int maxVowels(String s, int k) {
        Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        int maxVowels = 0;
        int currVowels = 0;
        
        // Count vowels in first window
        for (int i = 0; i < k; i++) {
            if (vowels.contains(s.charAt(i))) {
                currVowels++;
            }
        }
        maxVowels = currVowels;
        
        // Slide window and update vowel count
        for (int i = k; i < s.length(); i++) {
            if (vowels.contains(s.charAt(i - k))) {
                currVowels--;
            }
            if (vowels.contains(s.charAt(i))) {
                currVowels++;
            }
            maxVowels = Math.max(maxVowels, currVowels);
        }
        
        return maxVowels;
    }
}