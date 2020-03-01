package tree;

import org.junit.Test;

import static org.junit.Assert.*;

public class ArrayBinaryTreeTest {

    @Test
    public void preOrder() {
        int[] arr = { 1, 2, 3, 4, 5, 6, 7 };
        ArrayBinaryTree tree = new ArrayBinaryTree(arr);
        tree.preOrder(0);// 1 2 4 5 3 6 7
    }

    @Test
    public void midOrder() {
        int[] arr = { 1, 2, 3, 4, 5, 6, 7 };
        ArrayBinaryTree tree = new ArrayBinaryTree(arr);
        tree.midOrder(0); //4 2 5 1 6  3 7
    }

    @Test
    public void proOrder() {
        int[] arr = { 1, 2, 3, 4, 5, 6, 7 };
        ArrayBinaryTree tree = new ArrayBinaryTree(arr);
        tree.proOrder(0);// 4 5 2 6 7 3 1
    }
}