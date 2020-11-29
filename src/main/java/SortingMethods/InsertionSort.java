package SortingMethods;

/**
 * Created by mari.avetisyan on 29/11/2020.
 */
public class InsertionSort {
    static void insertionSort(int[] arr) {
      int size = arr.length;

      for(int i = 1; i < size; ++i) {
          int tmp = arr[i];

          for(int j = i - 1; j >= 0; --j) {
              if(tmp < arr[j]) {
                  arr[j + 1] = arr[j];

                  if(j == 0) {
                      arr[0] = tmp;
                  } else if(tmp >= arr[j - 1]) {
                      arr[j] = tmp;
                  }
              }
          }
      }
    }

    public static void main(String[] args) {
        int[] arr = {0, -5, 10, 56, -7, 0};

        insertionSort(arr);
        Helper.printArray(arr);
    }
}
