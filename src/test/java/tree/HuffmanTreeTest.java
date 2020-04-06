package tree;

import org.junit.Test;

import static org.junit.Assert.*;

public class HuffmanTreeTest {

    int[] arr = { 13, 7, 8, 3, 29, 6, 1 };

    private static void preOrder(HuffmanTree.Node root) {
        if (root != null) {
            root.preOrder();
        } else {
            System.out.println("是空树，不能遍历~~");
        }
    }

    @Test
    public void preOrderHuffmanTree() {
        HuffmanTree.Node huffmanNode = HuffmanTree.createHuffmanTree(arr);
        preOrder(huffmanNode);
    }
}