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
    public TreeNode invertTree(TreeNode root) {
     return mirrorTree(root)   ;
    }

    public TreeNode mirrorTree(TreeNode node)
    {
        if(node==null){
         return node;
        }

        TreeNode left = mirrorTree(node.left);
        TreeNode right = mirrorTree(node.right);

        node.left = right;
        node.right = left;

        return node;
    }
}