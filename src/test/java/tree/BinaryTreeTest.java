package tree;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BinaryTreeTest {

    BinaryTree binaryTree;

    @Before
    public void setUp() throws Exception {
        binaryTree = new BinaryTree();
        BinaryTree.TreeNode root = new BinaryTree.TreeNode(1, "宋江");
        BinaryTree.TreeNode node1 = new BinaryTree.TreeNode(2, "吴用");
        BinaryTree.TreeNode node2 = new BinaryTree.TreeNode(3, "卢俊义");
        BinaryTree.TreeNode node3 = new BinaryTree.TreeNode(4, "武松");
        BinaryTree.TreeNode node4 = new BinaryTree.TreeNode(5, "关胜");

        root.setLeftSubNode(node1);
        root.setRightSubNode(node2);
        node2.setLeftSubNode(node3);
        node2.setRightSubNode(node4);

        binaryTree.setRoot(root);
    }

    @After
    public void tearDown() throws Exception {
        binaryTree = null;
    }

    @Test
    public void preOrder() {
        binaryTree.preOrder();
    }

    @Test
    public void midOrder() {
        binaryTree.midOrder();
    }

    @Test
    public void proOrder() {
        binaryTree.proOrder();
    }

    @Test
    public void preSearch() {
        BinaryTree.TreeNode node = binaryTree.preSearch(3);
        System.out.println(node);
    }

    @Test
    public void midSearch() {
        BinaryTree.TreeNode node = binaryTree.midSearch(3);
        System.out.println(node);
    }

    @Test
    public void proSearch() {
        BinaryTree.TreeNode node = binaryTree.proSearch(3);
        System.out.println(node);
    }

    @Test
    public void deleteNode() {
        binaryTree.preOrder();
        binaryTree.deleteNode(3);
        System.out.println("---");
        binaryTree.preOrder();
    }
}