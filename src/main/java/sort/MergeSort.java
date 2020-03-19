package sort;

/**
 * @author gradyjiang
 * @title: MergeSort
 * @projectName datastructure-and-algorithm
 * @description: TODO
 * @date 2020/3/1
 */

/**
 * 归并排序
 * 利用归并的思想来实现排序，采用分治（divide-and-conquer）策略解决
 * 将问题拆分为一些小问题，然后将小问题的答案"修补"在一起，即分而治之的思想
 */
public class MergeSort {

    public int[] mergeSort(int [] arr) {
        return mergeSortByIndex(arr, 0, arr.length-1);
    }

    public int[] mergeSortByIndex(int[] arr, int begin, int end) {
        if (end == begin) {
            return new int[]{ arr[begin] };
        }
        int middle = (end + begin)/2;
        return merge(mergeSortByIndex(arr, begin, middle), mergeSortByIndex(arr, middle+1, end));
    }

    /**
     * 归并核心，将两个数组合并
     * @param leftArr
     * @param rightArr
     * @return
     */
    public int[] merge(int[] leftArr, int[] rightArr) {
        int [] temp = new int[leftArr.length + rightArr.length];
        int tempIndex = 0;
        int leftIndex = 0;
        int rightIndex = 0;

        while(leftIndex < leftArr.length && rightIndex < rightArr.length) {
            if (leftArr[leftIndex] < rightArr[rightIndex]) {
                temp[tempIndex++] = leftArr[leftIndex++];
            } else {
                temp[tempIndex++] = rightArr[rightIndex++];
            }
        }

        while (leftIndex < leftArr.length) {
            temp[tempIndex++] = leftArr[leftIndex++];
        }
        while (rightIndex < rightArr.length) {
            temp[tempIndex++] = rightArr[rightIndex++];
        }

        return temp;
    }
}
