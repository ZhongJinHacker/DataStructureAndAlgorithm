package tree;

/**
 * @author gradyjiang
 * @title: BinaryTree 二叉树
 * @projectName datastructure-and-algorithm
 * @description: TODO
 * @date 2020/3/1
 */
public class BinaryTree {

    private TreeNode root;

    public void setRoot(TreeNode root) {
        this.root = root;
    }

    // 前序遍历
    public void preOrder() {
        preOrderByNode(this.root);
    }

    private void preOrderByNode(TreeNode node) {
        if (node == null) return;
        System.out.println(node.value);
        preOrderByNode(node.getLeftSubNode());
        preOrderByNode(node.getRightSubNode());
    }

    // 中序遍历
    public void midOrder() {
        midOrderByNode(this.root);
    }

    private void midOrderByNode(TreeNode node) {
        if (node == null) return;
        midOrderByNode(node.getLeftSubNode());
        System.out.println(node.value);
        midOrderByNode(node.getRightSubNode());
    }

    // 后序遍历
    public void proOrder() {
        proOrderByIndex(this.root);
    }

    private void proOrderByIndex(TreeNode node) {
        if (node == null) return;
        proOrderByIndex(node.getLeftSubNode());
        proOrderByIndex(node.getRightSubNode());
        System.out.println(node.value);
    }


    public static class TreeNode {
        private int id;

        private String value;

        private TreeNode leftSubNode;

        private TreeNode rightSubNode;

        public TreeNode(int id, String value) {
            this.id = id;
            this.value = value;
        }

        public void setLeftSubNode(TreeNode leftSubNode) {
            this.leftSubNode = leftSubNode;
        }

        public TreeNode getLeftSubNode() {
            return leftSubNode;
        }

        public void setRightSubNode(TreeNode rightSubNode) {
            this.rightSubNode = rightSubNode;
        }

        public TreeNode getRightSubNode() {
            return rightSubNode;
        }
    }
}
