class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
         String[] splitArr = s.split(" ");
         for(int i = splitArr.length-1; i>=0; i--)
         {
             if(splitArr[i].trim().length()>0)
                sb.append(splitArr[i]).append(" ");
         }
         String result  =sb.toString();
         return result.substring(0, result.length()-1);
    }
}