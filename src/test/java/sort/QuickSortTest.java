package sort;

import org.junit.Test;

import static org.junit.Assert.*;

public class QuickSortTest {

    @Test
    public void quickSort() {
        int [] arr = {-9, 78, 0, 23, -567, 70};
        for (int i : arr) {
            System.out.print(i + "\t");
        }
        System.out.println("\n---");

        QuickSort qSort = new QuickSort();
        qSort.quickSort(arr);

        for (int i : arr) {
            System.out.print(i + "\t");
        }
    }
}