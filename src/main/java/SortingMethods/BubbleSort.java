package SortingMethods;

/**
 * Created by mari.avetisyan on 24/09/2020.
 */
public class BubbleSort {
    public static void bubbleSort(int[] arr) {
        for(int i = 0; i < arr.length - 1; ++i) {
            for(int j = i + 1; j < arr.length; ++j) {
                if(arr[i] > arr[j]) {
                    Helper.swap(arr, i, j);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 4, 3, 2, 64, 3, 2, 4, 5, 5, 2, 12, 14, 5, 3, 0, -1};

        bubbleSort(arr);
        Helper.printArray(arr);
    }
}
