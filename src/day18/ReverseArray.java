package day18;

import java.util.Arrays;

public class ReverseArray {

    public static void reverseWithRecursion(int[] arr, int left, int right) {
        if(left > right) return;
        swap(arr, left, right);
        reverseWithRecursion(arr, left + 1, right - 1);
    }

    public static void reverseWithOnePointerUsingRecursion(int[] arr, int left) {
        int mid = arr.length / 2;
        int n = arr.length;
        if(left > mid) return;

        swap(arr, left, n - 1 - left);
        reverseWithOnePointerUsingRecursion(arr, left + 1);
    }

    public static void swap(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        System.out.println("Before Reverse :: " + Arrays.toString(arr));
        reverseWithOnePointerUsingRecursion(arr, 0);
        System.out.println("After Reverse :: " + Arrays.toString(arr));
    }
}
