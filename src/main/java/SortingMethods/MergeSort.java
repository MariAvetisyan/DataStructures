package SortingMethods;

/**
 * Created by mari.avetisyan on 29/11/2020.
 */
public class MergeSort {
    static void mergeSort(int[] arr) {
        dividingArray(arr, 0, arr.length - 1);
    }

    static void dividingArray(int[] arr, int firstIndex, int lastIndex) {
        if(firstIndex < lastIndex) {
            dividingArray(arr, firstIndex, (firstIndex+ lastIndex) / 2);
            dividingArray(arr, (firstIndex + lastIndex) / 2 + 1, lastIndex);
            mergeSort(arr, firstIndex, (firstIndex + lastIndex) / 2, lastIndex);
        }
    }

    private static void mergeSort(int[] arr, int firstIndex, int middleIndex, int lastIndex) {
        int[] arrayOfFirstHalf = new int[middleIndex - firstIndex + 1];
        int[] arrayOfSecondHalf = new int[lastIndex - middleIndex];

        int sizeOfFirstHalf = arrayOfFirstHalf.length;
        int sizeOfSecondHalf = arrayOfSecondHalf.length;

        for(int i = 0; i < sizeOfFirstHalf; ++i) {
            arrayOfFirstHalf[i] = arr[firstIndex + i];
        }

        for(int j = 0; j < sizeOfSecondHalf; ++j) {
            arrayOfSecondHalf[j] = arr[middleIndex + 1 + j];
        }

        int firstHalfIterator = 0;
        int secondHalfIterator = 0;
        int arrIterator = firstIndex;

        while(firstHalfIterator < sizeOfFirstHalf && secondHalfIterator < sizeOfSecondHalf) {
            if(arrayOfFirstHalf[firstHalfIterator] < arrayOfSecondHalf[secondHalfIterator]) {
                arr[arrIterator] = arrayOfFirstHalf[firstHalfIterator];
                firstHalfIterator++;
            } else {
                arr[arrIterator] = arrayOfSecondHalf[secondHalfIterator];
                secondHalfIterator++;
            }

            arrIterator++;
        }

        while (firstHalfIterator < sizeOfFirstHalf) {
            arr[arrIterator] = arrayOfFirstHalf[firstHalfIterator];
            firstHalfIterator++;
            arrIterator++;
        }

        while (secondHalfIterator < sizeOfSecondHalf) {
            arr[arrIterator] = arrayOfSecondHalf[secondHalfIterator];
            secondHalfIterator++;
            arrIterator++;
        }
    }

    public static void main(String[] args) {
        int arr[] = {12, 11, 13, 5, 6, 7};
        mergeSort(arr);
        Helper.printArray(arr);
    }
}
