class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        boolean flag = true;
       
       
        HashMap<Character, Integer> magazineMap = new HashMap<>();
        for(int i=0; i < magazine.length(); i++)
        {
            Character c = magazine.charAt(i);
            magazineMap.put(c, magazineMap.getOrDefault(c, 0)+1);
        }
        
        for(int i=0; i < ransomNote.length(); i++)
        {
            Character c = ransomNote.charAt(i);
            if(magazineMap.getOrDefault(c, -1) <=0 )
            {
                flag=false;
                break;
            }
            else
            {
                magazineMap.put(c, magazineMap.get(c)-1);
            }
        }
        return flag;
        
    }
}