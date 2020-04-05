package sort;

import org.junit.Test;

import static org.junit.Assert.*;

public class SelectSortTest {

    @Test
    public void selectSort() {
        int [] arr = {10, 11, 1, 5, -1, 7};
        SelectSort sSort = new SelectSort();
        sSort.selectSort(arr);
        for (int i : arr) {
            System.out.print(i + "\t");
        }
    }
}