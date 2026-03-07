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
    public int sumRootToLeaf(TreeNode root) {
        return sumLeafPath(root, 0);
    }
    
    private int sumLeafPath(TreeNode root, int sumSoFar)
    {
        if(root==null)
        {
            return 0;
        }
        
        sumSoFar = sumSoFar * 2 + root.val;
        
        if(root.left==null && root.right==null)
        {
            return sumSoFar;
        }
        
        return sumLeafPath(root.left, sumSoFar)+  sumLeafPath(root.right, sumSoFar);
    }
}