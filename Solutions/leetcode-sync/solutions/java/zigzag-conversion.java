class Solution {
    public String convert(String s, int n) {
        if (n == 1)
        {
            return s;
        }
        boolean down =false;
        int row = 0;

        String[] strArr = new String[n];
        Arrays.fill(strArr, "");

        for(int i=0; i< s.length(); i++)
        {
            strArr[row]  += s.charAt(i);
            if(row==n-1) down= false;
            else if(row==0) down=true;

            if(down) row++;
            else row--;
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n ; i++)
            sb.append(strArr[i]);
        
        return sb.toString();
    }
}