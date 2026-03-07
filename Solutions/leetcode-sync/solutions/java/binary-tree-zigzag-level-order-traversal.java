/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
               List result=new ArrayList<LinkedList<Integer>>();
        zigzagLevelOrder(1, root, result);
        return result;
    }

    private void zigzagLevelOrder(int level, TreeNode root, List<LinkedList<Integer>> traversal){
        if(root == null)
            return;
        if(traversal.size() < level)
            traversal.add(new LinkedList<Integer>());
       
        if(level%2==1){
             traversal.get(level - 1).addLast(root.val);
        }
        else
        {
        traversal.get(level - 1).addFirst(root.val);
        }

        zigzagLevelOrder(level + 1, root.left, traversal);
        zigzagLevelOrder(level + 1, root.right, traversal);
    }
}