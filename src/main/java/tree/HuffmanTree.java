package tree;

/**
 * @author gradyjiang
 * @title: HuffmanTree
 * @projectName datastructure-and-algorithm
 * @description: TODO
 * @date 2020/4/6
 */

/**
 * 1) 给定n个权值作为n个叶子结点，构造一棵二叉树，若该树的带权路径长度(wpl)达到最小，称这样的二叉树为 最优二叉树，也称为哈夫曼树(Huffman Tree), 还有的书翻译为霍夫曼树。
 * 2) 赫夫曼树是带权路径长度最短的树，权值较大的结点离根较近
 * <p>
 * 11.2.2 赫夫曼树几个重要概念和举例说明
 * 1) 路径和路径长度:在一棵树中，从一个结点往下可以达到的孩子或孙子结点之间的通路，称为路径。通路
 * 中分支的数目称为路径长度。若规定根结点的层数为 1，则从根结点到第 L 层结点的路径长度为 L-1
 * 2) 结点的权及带权路径长度:若将树中结点赋给一个有着某种含义的数值，则这个数值称为该结点的权。结 点的带权路径长度为:从根结点到该结点之间的路径长度与该结点的权的乘积
 * 3) 树的带权路径长度:树的带权路径长度规定为所有叶子结点的带权路径长度之和，记为 WPL(weighted path length) ,权值越大的结点离根结点越近的二叉树才是最优二叉树。
 * 4) WPL最小的就是赫夫曼树
 * <p>
 *
 * 构成赫夫曼树的步骤:
 * 1) 从小到大进行排序,将每一个数据，每个数据都是一个节点，每个节点可以看成是一颗最简单的二叉树
 * 2) 将这些节点组成一个节点数组，根据根节点的全值升序排列
 * 2) 取出根节点权值最小的两颗二叉树
 * 3) 组成一颗新的二叉树, 该新的二叉树的根节点的权值是前面两颗二叉树根节点权值的和
 * 4）将这颗新二叉树入数组，以选择处理的两个节点踢出数组
 * 5) 数组再次排序， 不断重复 1-2-3-4 的步骤，直到数组中的元素个数为1，则所有的数据都被处理，就得到一颗赫夫曼树
 */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * 题目：
 * 给定一个数组 { 13, 7, 8, 3, 29, 6, 1 }, 要求转成一颗赫夫曼树
 */
public class HuffmanTree {

    /**
     * 创建霍夫曼树的方法
     *
     * @param arr 需要创建成哈夫曼树的数组
     * @return 创建好后的哈夫曼树的root结点
     */
    public static Node createHuffmanTree(int [] arr) {
        if (arr == null || arr.length == 0) {
            throw new RuntimeException("arr 为空，请检查 ");
        }
        List<Node> list = new ArrayList<>();
        for(int value : arr) {
            Node node = new Node(value, null, null);
            list.add(node);
        }
        while (list.size() > 1) {
            list.sort(Node::compareTo);

            Node firstNode = list.get(0);
            Node secondNode = list.get(1);
            Node rootNode = new Node(firstNode.getValue() + secondNode.getValue(), firstNode, secondNode);

            list.remove(firstNode);
            list.remove(secondNode);
            list.add(rootNode);
        }
        return list.get(0);
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Node implements Comparable<Node> {

        // 结点权值
        private int value;
        // 指向左子结点
        private Node left;
        //指向右子结点
        private Node right;

        @Override
        public int compareTo(Node o) {
            return this.value - o.value;
        }

        @Override
        public String toString() {
            return "node[value =" + value + "]";
        }

        public void preOrder() {
            System.out.println(this);
            if (this.left != null) {
                this.left.preOrder();
            }
            if (this.right != null) {
                this.right.preOrder();
            }
        }
    }
}
