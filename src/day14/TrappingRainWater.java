package day14;

public class TrappingRainWater {


    public int trap(int[] arr) {

        int total = 0;
        int[] prefixMax = getPrefixMax(arr);
        int[] suffixMax = getSuffixMax(arr);
        for(int i =0; i<arr.length; i++) {
            int leftMax = prefixMax[i];
            int rightMax = suffixMax[i];
            if(leftMax > arr[i] && arr[i] < rightMax) {
                total += Math.min(leftMax, rightMax) - arr[i];
            }
        }

        return total;
    }

    public int[] getPrefixMax(int[] arr) {
        int n = arr.length;
        int[] prefix = new int[n];
        prefix[0] = arr[0];
        for(int i=1; i<n; i++) {
            prefix[i] = Math.max(prefix[i-1], arr[i]);
        }
        return prefix;
    }

    public int[] getSuffixMax(int[] arr) {
        int n = arr.length;
        int[] suffix = new int[n];
        suffix[n-1] = arr[n-1];
        for(int i=n-2; i>=0; i--) {
            suffix[i] = Math.max(suffix[i+1], arr[i]);
        }
        return suffix;
    }

    // optimal solution
    public static int findTotal(int[] arr) {
        int n = arr.length;
        int leftMax = 0;
        int rightMax = 0;
        int left = 0;
        int right = n - 1;
        int total = 0;
        while(left < right) {
            if(arr[left] < arr[right]) {
                if(leftMax > arr[left]) {
                    total += leftMax - arr[left];
                } else {
                    leftMax = arr[left];
                }
                left+=1;
            } else {
                if(rightMax > arr[right]) {
                    total += rightMax - arr[right];
                } else {
                    rightMax = arr[right];
                }
                right-=1;
            }
        }
        return total;
    }
}
