class Solution {
    public char repeatedCharacter(String s) {
        Set<Character> sets = new HashSet();
        for(Character c : s.toCharArray())
        {
            if(sets.contains(c))
            {
                return c;
            }
            else
            {
                sets.add(c);
            }
        }
        return ' ';
    }
}