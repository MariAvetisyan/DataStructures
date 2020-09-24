package SortingMethods;

/**
 * Created by mari.avetisyan on 24/09/2020.
 */

class Helper {
    static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    static void printArray(int[] arr) {
        int size = arr.length;
        for(int i = 0; i < size; ++i) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
