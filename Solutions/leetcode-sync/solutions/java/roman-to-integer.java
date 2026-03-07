class Solution {
    public int romanToInt(String s) {
       
        char[] charArr = s.toCharArray();
        int sum = getIntForChar(charArr[charArr.length-1]);

        for(int i=charArr.length-2; i>=0; i--)
        {
            if(getIntForChar(charArr[i])< getIntForChar(charArr[i+1]))
            {
                sum-=getIntForChar(charArr[i]);
            }
            else
            {
                sum+=getIntForChar(charArr[i]);
            }
        }
        return sum;
    }

    private int getIntForChar(char c)
    {
        int val=0;
        switch(c){
            case 'I':
                val=1;
                break;
            case 'V':
                val=5;
                break;
            case 'X':
                val=10;
                break;
            case 'L':
                val=50;
                break;
            case 'C':
                val=100;
                break;
            case 'D':
                val=500;
                break;
            case 'M':
                val=1000;
                break;
            default:
                break;

        }
        return val;

    }
}