class Solution {
    public boolean isIsomorphic(String s, String t) {
        
        if(s.length()!=t.length()) return false;

        int[] tArr = new int[256];
        Arrays.fill(tArr, -1);

        int[] sArr = new int[256];
        Arrays.fill(sArr, -1);

        for(int i=0; i<s.length();i++)
        {
            char cS = s.charAt(i);
            char cT = t.charAt(i);
            
            if(sArr[cS]==-1 && tArr[cT]==-1){
                sArr[cS]  = cT;
                tArr[cT] = cS;
            }
            else if(sArr[cS]!=cT || tArr[cT]!=cS){
                return false;
            }
        }
        return true;
    }
}