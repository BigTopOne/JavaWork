package recursion;

public class StudyTree {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode();
        TreeNode result = invertTreeNode(treeNode);
    }

    private static TreeNode invertTreeNode(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = invertTreeNode(root.left);
        TreeNode right = invertTreeNode(root.right);
        // 左右节点下的二叉树反转好后，反转根节点的左右节点。
        root.right = left;
        root.left = right;
        return root;
    }

}
