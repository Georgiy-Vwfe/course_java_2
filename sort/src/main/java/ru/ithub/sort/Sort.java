package ru.ithub.sort;

import java.util.Arrays;

public class Sort {
    public static void main(String[] args) {
        Integer[] arr = {4, 2, 7, 9, 0, 5};
        int[] arr2 = {4, 2, 7, 9, 0, 5};

        simpleSort(arr);
        sort(arr2);
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(arr2));
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

}
