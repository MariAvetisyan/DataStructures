package SortingMethods;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by mari.avetisyan on 24/09/2020.
 */

public class Helper {
    public static final Logger log = LoggerFactory.getLogger("root");

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void printArray(int[] arr) {
        int size = arr.length;

        for(int i = 0; i < size; ++i) {
            System.out.print(arr[i] + " ");
        }

        System.out.println();
    }
}
