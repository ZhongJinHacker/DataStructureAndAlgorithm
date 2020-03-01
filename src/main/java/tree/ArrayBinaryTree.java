package tree;

/**
 * @author gradyjiang
 * @title: ArrayBinaryTree
 * @projectName datastructure-and-algorithm
 * @description: TODO
 * @date 2020/3/1
 */

/**
 * 顺序存储二叉树
 * 以数组的形式表现一颗二叉树
 * 从数据存储来看，数组存储方式和树的存储方式可以相互转换，即数组可以转换成树，树也可以转换成数组
 *
 *    要求:
 * 1) 右图的二叉树的结点，要求以数组的方式来存放arr:[1,2,3,4,5,6,7]
 * 2) 要求在遍历数组arr时，仍然可以以前序遍历，中序遍历和后序遍历的方式完成结点的遍历
 *
 * 顺序存储二叉树的特点:
 * 1) 顺序二叉树通常只考虑完全二叉树
 * 2) 第n个元素的左子节点为 2 * n + 1
 * 3) 第n个元素的右子节点为 2 * n + 2
 * 4) 第 n 个元素的父节点为 (n-1) / 2
 * 5) n : 表示二叉树中的第几个元素(按 0 开始编号如图所示)
 */
public class ArrayBinaryTree {

    int[] arr;

    public ArrayBinaryTree(int[] arr) {
        this.arr = arr;
    }

    /**
     * 从index节点开始前序遍历
     * @param index
     */
    public void preOrder(int index) {
        if (arr == null || arr.length == 0) return;
        if (index > arr.length-1) return;
        System.out.println(arr[index]);
        preOrder(2*index+1);
        preOrder(2*index+2);
    }

    public void midOrder(int index) {
        if (arr == null || arr.length == 0) return;
        if (index > arr.length-1) return;
        midOrder(2*index+1);
        System.out.println(arr[index]);
        midOrder(2*index+2);
    }

    public void proOrder(int index) {
        if (arr == null || arr.length == 0) return;
        if (index > arr.length-1) return;
        proOrder(2*index+1);
        proOrder(2*index+2);
        System.out.println(arr[index]);
    }

}
