class Solution {
    public void reverseString(char[] s) {
        if(s==null || s.length==0){
            return;
        }

        int i=0;
        int j=s.length-1;

        for(; i<j; i++, j--){
            if(s[i]!=s[j])
            {
                swap(s, i,j);
            }
        }
    }

    public void swap(char[] s, int i, int j){
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp; 
    }
}