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
    public boolean isBalanced(TreeNode root) {
        return checkBalanced(root).balanced;
    }
    
    public BalancedStatusWithHeight checkBalanced(TreeNode node)
    {
        if(node==null)
        {
            return new BalancedStatusWithHeight(-1, true);
        }
        
        BalancedStatusWithHeight leftResult = checkBalanced(node.left);
        if(!leftResult.balanced)
        {
            return new BalancedStatusWithHeight(0, false);
        }
        
        BalancedStatusWithHeight rightResult = checkBalanced(node.right);
        if(!rightResult.balanced)
        {
            return new BalancedStatusWithHeight(0, false);
        }
        
        boolean isBalanced = Math.abs(leftResult.height-rightResult.height)<=1;
        int height = Math.max(leftResult.height, rightResult.height)+1;
        return new BalancedStatusWithHeight(height, isBalanced);
    }
    
    
    
}

class BalancedStatusWithHeight{
    public int height;
    public boolean balanced;
    
    public BalancedStatusWithHeight(int height, boolean balanced)
    {
        this.height = height;
        this.balanced = balanced;
    }
}