class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs==null || strs.length==0){
            return List.of();
        }

        HashMap<String, List<String>> map = new HashMap<>();
        for(int i=0; i<strs.length; i++){
            char[] chArr =  strs[i].toCharArray();
            Arrays.sort(chArr);
            String key = new String(chArr);
            List<String> list = map.getOrDefault(key, new ArrayList());
            list.add(strs[i]);
            map.put(key, list);
        }
        //System.out.println(map);
        return new ArrayList(map.values());
    }
}