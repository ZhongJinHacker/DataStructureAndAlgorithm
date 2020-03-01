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

    /**
     * 前序遍历
     */
    public void preOrder() {
        preOrderByNode(this.root);
    }

    private void preOrderByNode(TreeNode node) {
        if (node == null) return;
        System.out.println(node.value);
        preOrderByNode(node.getLeftSubNode());
        preOrderByNode(node.getRightSubNode());
    }

    /**
     * 前序查找
     */
    public TreeNode preSearch(int id) {
        return preSearchByNode(root, id);
    }

    private TreeNode preSearchByNode(TreeNode node, int id) {
        if (node == null) return null;
        if (node.id == id) return node;
        TreeNode nodeLeft = preSearchByNode(node.getLeftSubNode(), id);
        if (nodeLeft != null) {
            return nodeLeft;
        }
        return preSearchByNode(node.getRightSubNode(), id);
    }

    /**
     * 中序遍历
     */
    public void midOrder() {
        midOrderByNode(this.root);
    }

    private void midOrderByNode(TreeNode node) {
        if (node == null) return;
        midOrderByNode(node.getLeftSubNode());
        System.out.println(node.value);
        midOrderByNode(node.getRightSubNode());
    }

    /**
     * 中序查找
     * @param id
     * @return
     */
    public TreeNode midSearch(int id) {
        return midSearchByNode(root, id);
    }

    private TreeNode midSearchByNode(TreeNode node, int id) {
        if (node == null) return null;

        TreeNode nodeLeft = midSearchByNode(node.getLeftSubNode(), id);
        if (nodeLeft != null) {
            return nodeLeft;
        }

        if (node.id == id) return node;

        return midSearchByNode(node.getRightSubNode(), id);
    }

    /**
     * 后序遍历
     */
    public void proOrder() {
        proOrderByIndex(this.root);
    }

    private void proOrderByIndex(TreeNode node) {
        if (node == null) return;
        proOrderByIndex(node.getLeftSubNode());
        proOrderByIndex(node.getRightSubNode());
        System.out.println(node.value);
    }

    /**
     * 中序查找
     * @param id
     * @return
     */
    public TreeNode proSearch(int id) {
        return proSearchByNode(root, id);
    }

    private TreeNode proSearchByNode(TreeNode node, int id) {
        if (node == null) return null;

        TreeNode nodeLeft = proSearchByNode(node.getLeftSubNode(), id);
        if (nodeLeft != null) {
            return nodeLeft;
        }

        TreeNode nodeRight = proSearchByNode(node.getRightSubNode(), id);
        if (nodeRight != null) {
            return nodeRight;
        }

        if (node.id == id) return node;

        return null;
    }

    /**
     * 删除节点
     * @param id
     */
    public void deleteNode(int id) {
        if (this.root == null) return;
        if (this.root.id == id) {
            this.root = null;
            return;
        }
        deleteNode(root, id);
    }

    private void deleteNode(TreeNode node, int id) {
        if (node.getLeftSubNode() != null && node.getLeftSubNode().id == id) {
            node.setLeftSubNode(null);
            return;
        }
        else if (node.getLeftSubNode() != null && node.getLeftSubNode().id != id) {
            deleteNode(node.getLeftSubNode(), id);
        }

        if (node.getRightSubNode() != null && node.getRightSubNode().id == id) {
            node.setRightSubNode(null);
            return;
        }
        else if (node.getRightSubNode() != null && node.getRightSubNode().id != id) {
            deleteNode(node.getRightSubNode(), id);
        }
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

        @Override
        public String toString() {
            return "TreeNode{" +
                    "id=" + id +
                    ", value='" + value +
                    '}';
        }
    }
}
