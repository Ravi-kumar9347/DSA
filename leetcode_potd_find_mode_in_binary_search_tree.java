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
    public int[] findMode(TreeNode root) {
        //O(N)
        //S(1)
        List<Integer> ans = new ArrayList<>();
        int[] values = new int[2]; // values[0] for current value, values[1] for current frequency
        int[] max = new int[1]; // max[0] for maximum frequency
        inOrder(root, values, max, ans);
        int[] result = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            result[i] = ans.get(i);
        }
        return result;
    }

   private void inOrder(TreeNode root, int[] values, int[] max, List<Integer> ans) {
        if (root == null) return;

        inOrder(root.left, values, max, ans);

        if (values[0] == root.val) {
            values[1]++;
        } else {
            values[0] = root.val;
            values[1] = 1;
        }

        if (values[1] > max[0]) {
            max[0] = values[1];
            ans.clear();
            ans.add(root.val);
        } else if (values[1] == max[0]) {
            ans.add(root.val);
        }

        inOrder(root.right, values, max, ans);
    }
}