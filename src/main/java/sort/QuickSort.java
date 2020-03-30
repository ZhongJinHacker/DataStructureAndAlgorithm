package sort;

/**
 * @author gradyjiang
 * @title: QuickSort
 * @projectName datastructure-and-algorithm
 * @description: TODO
 * @date 2020/3/1
 */

/**
 * 快速排序：
 * 对冒泡排序的改进
 * 思想：
 * 通过一趟排序，将要排序的数据分割成独立的两部分，其中一部分的所有数据都比另外一部分小，
 * 然后按照此方法对这两部分数据再次分别进行快速排序，整个排序过程递归进行，以达到整个数据
 * 变为有序序列
 */
public class QuickSort {

    public void quickSort(int [] arr) {
        qSort(arr, 0, arr.length - 1);
    }

    private void qSort(int [] arr,int left, int right) {
        if (right == left) return;

        int baseVal = arr[(right + left)/2];
        int leftIndex = left;
        int rightIndex = right;
        // 循环目的：让比baseVal大的值在baseVal右边，比baseVal小的值在baseVal左边
        while (leftIndex < rightIndex) {

            while(arr[leftIndex] < baseVal) {
                leftIndex++;
            }

            while (arr[rightIndex] > baseVal) {
                rightIndex--;
            }

            if (leftIndex == rightIndex) {
                break;
            }

            int temp = arr[leftIndex];
            arr[leftIndex] = arr[rightIndex];
            arr[rightIndex] = temp;
        }
        // 这个循环后，leftIndex 和 rightIndex 会汇聚在基准值所在处
        if (left < leftIndex) {
            qSort(arr, left, leftIndex-1);
        }
        if (right > rightIndex) {
            qSort(arr, rightIndex+1, right);
        }
    }
}
