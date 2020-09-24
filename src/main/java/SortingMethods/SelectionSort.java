package SortingMethods;

/**
 * Created by mari.avetisyan on 24/09/2020.
 */
public class SelectionSort {
    static void selectionSort(int[] arr) {
        int size = arr.length;
        int minElementOfArray;
        int minElementIndex;

        for(int i = 0; i < size ; ++i) {
            minElementOfArray = arr[i];
            minElementIndex = i;
            for(int j = i + 1; j < size; ++j) {
                if (arr[j] < minElementOfArray) {
                    minElementOfArray = arr[j];
                    minElementIndex = j;
                }
            }

            Helper.swap(arr, i, minElementIndex);
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 4, 3, 2, 64, 3, 2, 4, 5, 5, 2, 12, 14, 5, 3, 0, -1};

        selectionSort(arr);
        Helper.printArray(arr);
    }
}
