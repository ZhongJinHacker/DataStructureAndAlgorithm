package sort;

/**
 * @author gradyjiang
 * @title: HeapSort
 * @projectName datastructure-and-algorithm
 * @description: TODO
 * @date 2020/3/1
 */

/**
 * 堆排序
 * 如果每个节点都大于或等于其左右孩子节点的值，称为大顶堆
 * 大顶堆在数组中表示的特点： arr[i] >= arr[2*i+1] && arr[i] >= arr[2*i+2], i对应的是第几个节点，从0开始
 * 如果每个节点都小于或等于其左右孩子节点的值，称为小顶堆
 * 小顶堆在数组中表示的特点： arr[i] <= arr[2*i+1] && arr[i] <= arr[2*i+2], i对应的是第几个节点，从0开始
 * 升序采用大顶堆，降序采用小顶堆
 *
 * 堆排序思想：
 * 1. 将待排序序列构造成一个堆，然后构造成一个大顶堆（数组表现形式的大顶堆）
 * 2. 此时整个序列的最大值就是堆顶的根节点
 * 3. 将堆顶值与数组末尾值交换，此时末尾位最大值
 * 4. 将剩余的 n-1 个元素再构建位大顶堆，这样会得到n-1个元素中的最小值，再与堆（数组）最后元素交换
 * 5。 依次反复，最后就可以得到一个有序序列了
 */
public class HeapSort {

    public void headSort(int[] arr) {
        buildHeap(arr);
        for (int i = arr.length-1; i > 0; i--) {
            swap(arr, 0, i);
            adjustHeap(arr, 0, i);
        }
    }

    /**
     * 构建一个大顶堆（乱序堆到大顶堆）
     * @param arr
     */
    public void buildHeap(int[] arr) {
        // 有arr.length/2-1（公式）个非叶子节点要调整，从下向上,从右向左调整
        for (int i = arr.length/2-1; i >= 0; i--) {
            adjustHeap(arr, i, arr.length);
        }
    }

    /**
     * 调整成一个大顶堆（仅调整，建立在大顶堆已构建的基础上，仅调整一个值，即索引i该在哪里的问题）
     * @param arr 待调整的数组
     * @param i 表示非叶子节点在数组中的索引
     * @param length 表示要对多少个元素继续调整，即剩余数组长度
     */
    public void adjustHeap(int[] arr, int i, int length) {
        // 先保存当前索引i的值
        int temp = arr[i];
        // 从索引i的左子节点开始，即2i+1处开始;
        // k 和 i 的关系； k始终是i的左子节点或右子节点
        for (int k = i*2+1; k < length; k = k*2+1) {
            // 比较左子节点和右子节点的大小，选大的那个
            if (k+1 < length && arr[k] < arr[k+1]) {
                k++;
            }
            // 如果选中的节点k的值大于temp，那么子节点值赋给父节点后，继续向k的子节点比较
            if (arr[k] > temp) {
                arr[i] = arr[k];
                i = k;
            } else {
                // 如果选中的节点k的值小于于temp，那么其下面的子节点就都小于了，调整完毕
                break;
            }
        }
        // 将temp 即之前索引i的值放到最终位置上
        arr[i] = temp;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
