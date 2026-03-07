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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<inorder.length; i++){
            map.put(inorder[i], i);
        }

        return splitTree(preorder, 0, 0, inorder.length-1, map);
    }

    private TreeNode splitTree(int[] p,  int pIndex, int iStart, int iEnd, Map<Integer, Integer> map)
    {
        int rootVal = p[pIndex];
        int iMid = map.get(rootVal);
        TreeNode root = new TreeNode(rootVal);
        if(iMid>iStart)
        {
            root.left = splitTree(p, pIndex+1, iStart, iMid-1, map);
        }
        if(iMid<iEnd){
            root.right =splitTree(p, pIndex+iMid-iStart+1, iMid+1, iEnd, map);
        }

        return root;
    }
}