/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<Integer> preorder(Node root) {
        List<Integer> list = new ArrayList<Integer>();
        return preorderList(root, list);
    }
    
    private List<Integer> preorderList(Node root, List<Integer> list)
    {
        if(root==null)
        {
            return new ArrayList<Integer>();
        }
        
        list.add(root.val);
        
        for(Node node : root.children){
            preorderList(node, list);
            
        }
        
        return list;
    }
}