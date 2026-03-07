class Solution {
    public String reverseVowels(String s) {
        StringBuilder sb = new StringBuilder();
        Set<Character> vowels = new HashSet();
        vowels.addAll(Arrays.asList(
            new Character[] { 'A', 'E', 'O', 'I', 'U',
                                'a', 'e', 'i', 'o', 'u'}));
        
        Stack<Character> stack1 = new Stack();
        for(Character c : s.toCharArray())
        {
            if(vowels.contains(c))
            {
                stack1.push(c);    
            }
            
        }
        
        for(Character c : s.toCharArray())
        {
            if(vowels.contains(c))
            {
                Character c2= stack1.pop();
                sb.append(c2);
            }
            else
            {
                sb.append(c);
            }
            
        }
        
        return sb.toString();
    }
}