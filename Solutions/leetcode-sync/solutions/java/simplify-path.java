class Solution {
    public String simplifyPath(String path) {
           List<String> list = new ArrayList<>();
        String[] pathArr = path.split("/");
        for(int i=0; i<pathArr.length; i++){
            String s = pathArr[i];
            if(s.equals("") || s.equals("."))
            {
                continue;
            }
            else if(s.equals(".."))
            {
                if(list.size()>0)
                {
                    list.remove(list.size()-1);
                }
            }
            else
            {
                list.add(s);
            }
        }

        if(list.isEmpty()) return "/";
        StringBuilder sb = new StringBuilder();
        for(String s: list)
        {
            sb.append("/").append(s);
        }
        return sb.toString();
    }
}