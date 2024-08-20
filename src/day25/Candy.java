package day25;

public class Candy {

    public static int func(int[] arr) {
        int sum = 0;
        int[] left = new int[arr.length];
        int[] right = new int[arr.length];
        left[0] = 1;
        right[arr.length - 1] = 1;

        for(int i=1; i<arr.length; i++) {
            if(arr[i] > arr[i-1]) {
                left[i] = left[i-1] + 1;
            } else {
                left[i] = 1;
            }
        }

        for(int i=arr.length - 2; i>=0; i--) {
            if(arr[i] > arr[i+1]) {
                right[i] = right[i + 1] + 1;
            } else {
                right[i] = 1;
            }
        }

        for(int i=0; i<arr.length; i++) {
            sum += Math.max(left[i], right[i]);
        }

        return sum;
    }

    public static void main(String[] args) {

    }

}
