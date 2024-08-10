package day17;

public class MaxDepthBinaryTree {

    public static class TreeNode {

        TreeNode left;
        TreeNode right;
        int value;

        TreeNode() {

        }

        TreeNode(int value) {
            this.value = value;
        }

        TreeNode(int value, TreeNode left, TreeNode right) {
            this.left = left;
            this.right = right;
            this.value = value;
        }
    }

    public int maxDepth(TreeNode root) {

        if(root == null) return 0;

        int leftHeight = maxDepth(root.left);
        int rightHeight = maxDepth(root.right);

        return 1 + Math.max(leftHeight, rightHeight);
    }
}
