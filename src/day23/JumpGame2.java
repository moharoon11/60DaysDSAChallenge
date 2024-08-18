package day23;

public class JumpGame2 {

    public static int jump(int[] nums) {
        return func(0, 0, nums);
    }

    public static int func(int index, int jump, int[] nums) {

        if(index >= nums.length - 1) return jump;

        int mini = Integer.MAX_VALUE;


        for(int i=1; i<=nums[index]; i++) {
            mini = Math.min(mini, func(index + i, jump + 1, nums));
        }

        return mini;
    }

    public static void main(String[] args) {
        int[] arr = {2,3,1,1,4};
        int ans = jump(arr);
        System.out.println(ans);
    }
}
