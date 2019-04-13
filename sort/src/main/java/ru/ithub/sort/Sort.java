package ru.ithub.sort;

import java.util.Arrays;

public class Sort {
    public static void main(String[] args) {
        Integer[] arr = {4, 2, 7, 9, 0, 5};
        int[] arr2 = {4, 2, 7, 9, 0, 5};
        int[] arr3 = {4, 2, 7, 9, 0, 5};

        simpleSort(arr);
        sort(arr2);
        quickSort(arr3, 5);
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(arr2));
        System.out.println(Arrays.toString(arr3));
    }

    public static void simpleSort(Integer[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[j].compareTo(arr[j + 1]) > 0) {
                    int item = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = item;
                }
            }
        }
    }

    public static void sort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int item = arr[i];
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] > item) {
                    arr[j + 1] = arr[j];
                    arr[j] = item;
                } else {
                    break;
                }

            }
        }
    }

    public static void quickSort(int[] array, int endIndex) {
        int startIndex = 0;
        doSort(array, startIndex, endIndex);
    }

    private static void doSort(int[] array, int start, int end) {
        if (start >= end){
            return;
        }
            int i = start, j = end;
        int center = start - (start - end) / 2;
        while (i < j) {
            while (i < center && (array[i] <= array[center])) {
                i++;
            }
            while (j > center && (array[j] >= array[center])) {
                j--;
            }
            if (i < j) {
                int tmp = array[i];
                array[i] = array[j];
                array[j] = tmp;
                if (i == center) {
                    center = j;
                } else if (j == center) {
                    center = i;
                }
            }
        }
        doSort(array, start, center);
        doSort(array, center + 1, end);
    }


    public static void quickSort(int[] array, int begin, int end) {
        int central = array.length / 2;

        for (int i = begin; i < central; i++) {
            if (array[i] > array[central]) {
                for (int j = central; j <= array.length; j++) {
                    if (array[j] <= array[central]) {
                        int tmp = array[j];
                        array[j] = array[i];
                        array[i] = tmp;
                    }
                }
            } else {
                for (int j = central + 1; j < array.length; j++) {
                    if (array[j] <= array[central]) {
                        int tmp = array[central];
                        array[central] = array[j];
                        array[j] = tmp;
                    }
                }
            }
        }
        quickSort(array, begin, central);
        quickSort(array, central + 1, array.length);
    }
}
