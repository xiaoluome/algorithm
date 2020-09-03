package Week_02.id_18;

import java.util.Stack;

/**
 * @author LiveForExperience
 * @date 2019/6/14 18:30
 */
public class LeetCode_235_18 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (found(root, p, q)) {
            return root;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();

            if (node != null) {
                if (found(node, p, q)) {
                    return node;
                }

                stack.push(node.left);
                stack.push(node.right);
            }
        }

        return null;
    }

    private boolean found(TreeNode node, TreeNode p, TreeNode q) {
        return p.val <= node.val && q.val >= node.val ||
                p.val >= node.val && q.val <= node.val;
    }

    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        int parentVal = root.val;
        int pVal = p.val;
        int qVal = q.val;

        if (pVal < parentVal && qVal < parentVal) {
            return lowestCommonAncestor1(root.left, p, q);
        } else if (pVal > parentVal && qVal > parentVal) {
            return lowestCommonAncestor1(root.right, p, q);
        } else {
            return root;
        }
    }

    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();

            if (node != null) {
                if (p.val < node.val && q.val < node.val) {
                    stack.push(node.left);
                } else if (p.val > node.val && q.val > node.val){
                    stack.push(node.right);
                } else {
                    return node;
                }
            }
        }

        return null;
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
