package sort;

import org.junit.Test;

import static org.junit.Assert.*;

public class ShellSortTest {

    @Test
    public void shellSort() {
        int [] arr = {10, 11, 1, 5, -1, 7};
        ShellSort sSort = new ShellSort();
        sSort.shellSort(arr);
        for (int i : arr) {
            System.out.print(i + "\t");
        }
    }
}