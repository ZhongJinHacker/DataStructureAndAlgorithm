package sort;

import org.junit.Test;

import static org.junit.Assert.*;

public class MergeSortTest {

    @Test
    public void mergeSort() {
        int [] arr = { 8, 4, 5, 7, 1, 3, 6, 2 };
        for (int i : arr) {
            System.out.print(i + "\t");
        }
        System.out.println("\n---");

        MergeSort sort = new MergeSort();
        int[] result = sort.mergeSort(arr);

        for (int i : result) {
            System.out.print(i + "\t");
        }
    }

    @Test
    public void merge() {
        int[] left = {1, 3, 5, 7, 9};
        int[] right = {2, 4, 6, 8, 10};
        MergeSort sort = new MergeSort();
        int[] result = sort.merge(left, right);
        for (int i : result) {
            System.out.print(i + "\t");
        }
    }
}