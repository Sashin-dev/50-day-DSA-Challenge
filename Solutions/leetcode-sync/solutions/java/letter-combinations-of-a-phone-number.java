class Solution {
    
   public List<String> letterCombinations(String digits) {
        char[] partialMnemonics = new char[digits.length()];
        List<String> mnemonics = new ArrayList<>();
        phoneMnemonicHelper(partialMnemonics, mnemonics, 0, digits);
        return mnemonics;
    }

    private static List<String> phoneKeyMapping = List.of(
            "0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
    );
    private void phoneMnemonicHelper(char[] partialMnemonics, List<String> mnemonics, int digit, String phoneNumber) {
        if(digit==phoneNumber.length())
        {
 if(partialMnemonics.length>0) {
                mnemonics.add(new String(partialMnemonics));
            }
        }else
        {
            for(char c : phoneKeyMapping.get(phoneNumber.charAt(digit)-'0').toCharArray())
            {
                partialMnemonics[digit]=c;
                phoneMnemonicHelper(partialMnemonics, mnemonics, digit+1, phoneNumber);
            }
        }
    }
}