class Solution {
    public boolean detectCapitalUse(String word) {
        int capCounter=0;
        boolean flag = false;
        for(char c : word.toCharArray())
        {
            if(c>=65 && c<=90)
            {
                ++capCounter;
            }
        }

        if( capCounter==0 || capCounter == word.length() )
        {
            flag=true;
        }

        else if(capCounter==1 && (word.charAt(0) >=65 &&  word.charAt(0)<=90))
        {
            flag=true;
        }

        return flag;
    }
}