package SortingMethods;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Created by mari.avetisyan on 24/09/2020.
 */
public class SelectionSortTest {
    @Test
    public void selectionSort() throws Exception {
        int[] arr_1 = {0};
        int[] arrResult_1 = {0};
        SelectionSort.selectionSort(arr_1);
        assertArrayEquals(arr_1, arrResult_1);

        int[] arr_2 = {0, -1};
        int[] arrResult_2 = {-1, 0};
        SelectionSort.selectionSort(arr_2);
        assertArrayEquals(arr_2, arrResult_2);

        int[] arr_3 = {-1, -3, -2};
        int[] arrResult_3 = {-3, -2, -1};
        SelectionSort.selectionSort(arr_3);
        assertArrayEquals(arr_3, arrResult_3);

        int[] arr_4 = {-1, 0, 0};
        int[] arrResult_4 = {-1, 0, 0};
        SelectionSort.selectionSort(arr_4);
        assertArrayEquals(arr_4, arrResult_4);

        int[] arr_5 = {-9, -4, 5, 7, 10, -6, 5};
        int[] arrResult_5 = {-9, -6, -4, 5, 5, 7, 10};
        SelectionSort.selectionSort(arr_5);
        assertArrayEquals(arr_5, arrResult_5);

        int[] arr_6 = {10, -10, 10, -10, -14};
        int[] arrResult_6 = {-14, -10, -10, 10, 10};
        SelectionSort.selectionSort(arr_6);
        assertArrayEquals(arr_6, arrResult_6);

        int[] arr_7 = {5, 0, -9, 5, -63, 57, 100, 25, 36, 6, 1, -5, 6, -7, 852, 1542, 2369, 52, -541, 0};
        int[] arrResult_7 = {-541, -63, -9, -7, -5, 0, 0, 1, 5, 5, 6, 6, 25, 36, 52, 57, 100, 852, 1542, 2369};
        SelectionSort.selectionSort(arr_7);
        assertArrayEquals(arr_7, arrResult_7);

        int[] arr_8 = {1, 4, 3, 2, 64, 3, 2, 4, 5, 5, 2, 12, 14, 5, 3, 0, -1};
        int[] arrResult_8 = {-1, 0, 1, 2, 2, 2, 3, 3, 3, 4, 4, 5, 5, 5, 12, 14, 64};
        SelectionSort.selectionSort(arr_8);
        assertArrayEquals(arr_8, arrResult_8);
    }
}
