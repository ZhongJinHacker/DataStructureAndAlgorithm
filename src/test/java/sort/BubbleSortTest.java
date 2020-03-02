package sort;

import org.junit.Test;

public class BubbleSortTest {

    @Test
    public void bubbleSort() {
        int [] arr = {10, 11, 1, 5, -1, 7};
        BubbleSort bSort = new BubbleSort();
        bSort.bubboSort(arr);
        for (int i : arr) {
            System.out.print(i + "\t");
        }
    }
}