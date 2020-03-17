package sort;

import org.junit.Test;

import static org.junit.Assert.*;

public class InsertSortTest {

    @Test
    public void insertSort() {
        int [] arr = {10, 11, 1, 5, -1, 7};
        for (int i : arr) {
            System.out.print(i + "\t");
        }
        System.out.println("\n---");

        InsertSort sort = new InsertSort();
        sort.insertSort(arr);
        for (int i : arr) {
            System.out.print(i + "\t");
        }
    }
}