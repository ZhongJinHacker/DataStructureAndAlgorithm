package sort;

/**
 * @author gradyjiang
 * @title: ShellSort
 * @projectName datastructure-and-algorithm
 * @description: TODO
 * @date 2020/3/1
 */

/**
 * 希尔排序
 * 希尔排序是对插入排序的改进
 * 插入排序存在的问题：
 * 当一个数比较小时，存在需要后移次数增多问题，影响效率，比如{2,3,4,5,6,1}, 对1的排序，前面就都要移动
 *
 * 希尔排序思想：
 * 把记录按照下标的一定的增量分组，对每组使用直接插入排序算法来进行排序；然后逐渐减少增量，当增量减少到1时，
 * 整个数组被分成一组，在次插入排序，得到有序数组，算法终止
 * 比如：
 * {2, 3, 4, 5, 6, 1}
 * 第一次分组 步长为 6/2 = 3；
 * 2-5 3-6 4-1 一组
 * 插入排序变为{2,3,1,5,6,4}
 * 再次分组 步长为 3/2=1；
 * 对{2,3,1,5,6,4}进行插入排序，得到升序数组
 * 这样直接把最后的1排到前面去了，降低来插入排序的弱点
 */
public class ShellSort {

    public void shellSort(int [] arr) {
        int step = arr.length / 2;
        while(step > 0) {
            // 这里是交换排序
            for (int i = step; i < arr.length; i++) {
                //遍历各组中所有的元素（共gap组，每组有个元素），步长gap
                for (int j = i - step; j >= 0; j -= step) {
                    // 这里用的交换法，而非移位法
                    if(arr[j] > arr[j + step]) {
                        int tem = arr[j];
                        arr[j] = arr[j + step];
                        arr[j + step] = tem;
                    }
                }
            }

            step = step/2;
        }
    }
}
