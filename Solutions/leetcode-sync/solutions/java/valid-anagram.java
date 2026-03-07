class Solution {
    public boolean isAnagram(String s, String t) {
        // int length = s.length();
        int[] charset = new int[256];
        Arrays.fill(charset, 0);

        for(char c : s.toCharArray()){
            charset[c]++;
        }

        
        for(char c : t.toCharArray()){
            charset[c]--;
        }

        for(int i=0; i<charset.length; i++){
            if(charset[i]>0 || charset[i]<0){
                return false;
            }
        }

        return true;
    }
}