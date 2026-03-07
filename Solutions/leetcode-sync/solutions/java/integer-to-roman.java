class Solution {
    public String intToRoman(int num) {
        int [] integers = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
          String[] ROMANS ={"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X",
                "IX", "V", "IV", "I"};

        int i=0;
        StringBuilder sb = new StringBuilder();
        while(num>0 && i < integers.length)
        {
            if(num>=integers[i])
            {
                sb.append(ROMANS[i]);
                num-=integers[i];
            }
            else
            {
                i++;
            }
        }
        return sb.toString();
    }
}