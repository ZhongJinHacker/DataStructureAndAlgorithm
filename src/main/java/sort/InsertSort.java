package sort;

/**
 * @author gradyjiang
 * @title: InsertSort
 * @projectName datastructure-and-algorithm
 * @description: TODO
 * @date 2020/3/1
 */

/**
 * 插入排序
 * 基本思想：
 * 将待排序的数组看成一个有序表和一个无序表；开始时有序表只包含第一个元素，无序表包含后面的元素
 * 排序过程为每次从无序表中拿第一个元素插入到有序表中的适当位置，以此类推，组成一个有序表
 */
public class InsertSort {

    public void insertSort(int [] arr) {
        for (int i = 1; i < arr.length; i++) {
            int insertVal = arr[i];
            int index = i-1;
            // 前面是升序表，比插入值大就后移
            while (index >= 0 && arr[index] > insertVal) {
                arr[index+1] = arr[index];
                index--;
            }
            arr[index+1] = insertVal;
        }
    }
}
