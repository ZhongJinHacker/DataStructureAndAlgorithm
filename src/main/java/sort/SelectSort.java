package sort;

/**
 * @author gradyjiang
 * @title: SelectSort
 * @projectName datastructure-and-algorithm
 * @description: TODO
 * @date 2020/3/1
 */

/**
 * 选择排序比冒泡排序思路接近，
 *
 * 首先在数组中第一个值开始，找到最小的数，和第一个值交换
 * 然后从第二个值开始，找最小的值，和第二个值交换
 * 依次类推，一直到最后一个值
 */
public class SelectSort {

    public void selectSort(int [] arr) {
        for (int i = 0; i < arr.length; i++) {
            int min = arr[i];
            int index = i;
            for (int j = i+1; j < arr.length; j++) {
                if (min > arr[j]) {
                    min = arr[j];
                    index = j;
                }
            }

            int temp = arr[i];
            arr[i] = min;
            arr[index] = temp;

        }
    }
}
