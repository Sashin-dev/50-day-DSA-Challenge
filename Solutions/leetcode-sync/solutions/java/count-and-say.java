class Solution {
       public String countAndSay(int n) {
        String s= "1";
        for(int i=0; i<n-1; i++)
        {
            s= nextNumber(s);
        }
        return s;
    }

    private String nextNumber(String s) {
    StringBuilder sb = new StringBuilder();
    for (int i=0; i<s.length(); i++)
    {
        int count=1;
        while(i+1<s.length() && s.charAt(i) == s.charAt(i+1))
        {
            i++;
            count++;
        }
        sb.append(count).append(s.charAt(i));
    }
    return sb.toString();
    }

}