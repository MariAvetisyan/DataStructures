package SortingMethods;

/**
 * Created by mari.avetisyan on 30/11/2020.
 */
public class QuickSort {
    static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    static int partition(int[] arr, int firstIndex, int lastIndex) {
        int size = lastIndex - firstIndex + 1;
        int pivot = arr[lastIndex];
        int index = firstIndex - 1;

        for(int j = firstIndex; j < lastIndex; ++j) {
            if(arr[j] < pivot) {
                index++;
                Helper.swap(arr, index, j);
            }
        }

        Helper.swap(arr, index + 1, lastIndex);

        return index + 1;
    }

    static void quickSort(int[] arr, int firstIndex, int lastIndex) {
        if(firstIndex < lastIndex) {
            int pivot = partition(arr, firstIndex, lastIndex);

            quickSort(arr, firstIndex, pivot - 1);
            quickSort(arr, pivot + 1, lastIndex);
        }
    }

    public static void main(String[] args) {
        int[] arr = {10, 80, 30, 90, 40, 50, 70};
        quickSort(arr);
        Helper.printArray(arr);
    }

}
