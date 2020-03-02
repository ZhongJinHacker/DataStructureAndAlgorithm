package sort;

/**
 * @author gradyjiang
 * @title: BubboSort
 * @projectName datastructure-and-algorithm
 * @description: TODO
 * @date 2020/3/1
 */
public class BubbleSort {

    public void bubboSort(int[] arr) {
        // 一共执行数组长度次
        for (int i = 0; i < arr.length; i++) {
            // 每次执行次数比上次少1，因为上次的最大值已确定
            for(int j = 1; j < arr.length - i; j++) {
                if (arr[j-1] > arr[j]) {
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                }
            }
        }
    }
}
