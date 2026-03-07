class Solution {
    public boolean isPalindrome(String s) {
        if (s.isEmpty()) {
        	return true;
        }
        char[] charArray = s.toCharArray();
        int i=0;
        int j = charArray.length-1;
       while(i<=j)
       {
           Character cLeft = s.charAt(i);
           Character cRight = s.charAt(j);

           if(!Character.isLetterOrDigit(cLeft)){
               i++;
           }
           else if(!Character.isLetterOrDigit(cRight)){
                j--;
           }
           else if(Character.toLowerCase(cLeft)==Character.toLowerCase(cRight)){
               i++;
               j--;
           }
           else {
               return false;
           }
       }
        return true;
    }
}