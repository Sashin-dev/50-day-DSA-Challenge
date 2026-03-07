/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Status
{
    int targetNodes;
    TreeNode ancestor;
    
    public Status (int targetNodes, TreeNode ancestor)
    {
        this.targetNodes = targetNodes;
        this.ancestor = ancestor;
    }
}

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
                return LCAHelper(root, p, q).ancestor;
    }
    
    private Status LCAHelper(TreeNode root, TreeNode p, TreeNode q )
    {
        if(root==null)
        {
            return new Status(0, null);
        }
    
        Status leftResult = LCAHelper(root.left, p, q);
        if(leftResult.targetNodes==2)
        {
            return leftResult;
        }
        
        Status rightResult = LCAHelper(root.right, p, q);
        if(rightResult.targetNodes==2)
        {
            return rightResult;
        }
        
        int targetNodes = leftResult.targetNodes + rightResult.targetNodes 
            + (root==p ? 1 : 0) + (root==q ? 1 : 0);
        
        return new Status(targetNodes, targetNodes==2 ? root : null);
    }
}