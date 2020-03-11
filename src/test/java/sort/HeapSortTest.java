package sort;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class HeapSortTest {

    @Test
    public void headSort() {
        int[] arr = { 4, 6, 8, 5, 10, 9 , 0 ,12, 7};
        System.out.println(Arrays.toString(arr));

        HeapSort sort = new HeapSort();
        sort.headSort(arr);

        System.out.println(Arrays.toString(arr));

    }
}