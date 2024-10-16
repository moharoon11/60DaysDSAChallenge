package day37;

public class NinjasTraining {

    // Recursive approach
    public static int train(int day, int lastTask, int[][] tasks) {

        if(day == 0) {
            int max = 0;
            for(int task = 0; task <= 2; task++) {
                if(task != lastTask) {
                    max = Math.max(tasks[day][task], max);
                }
            }

            return max;
        }

        int max = 0;
        for(int task = 0; task <= 2; task++) {
            if(task != lastTask) {
                int point = tasks[day][task] + train(day - 1, task, tasks);
                max = Math.max(point, max);
            }
        }

        return max;
    }

    // Memoization
    public static int trainMemoization(int day, int lastTask, int[][] tasks, int[][] dp) {
        // Memoization check
        if(dp[day][lastTask] != -1) {
            return dp[day][lastTask];
        }

        // Base case: if it's the first day, find the maximum task (excluding lastTask)
        if(day == 0) {
            int max = 0;
            for(int task = 0; task <= 2; task++) {
                if(task != lastTask) {
                    max = Math.max(tasks[day][task], max);
                }
            }
            // Memoize and return the result for the first day
            return dp[day][lastTask] = max;
        }

        // Recursive case: for each task, find the maximum points excluding lastTask
        int max = 0;
        for(int task = 0; task <= 2; task++) {
            if(task != lastTask) {
                int point = tasks[day][task] + trainMemoization(day - 1, task, tasks, dp);
                max = Math.max(point, max);
            }
        }

        // Memoize and return the result for the current day and lastTask
        return dp[day][lastTask] = max;
    }



    // Tabulation
    public static int maximumPoints(int arr[][], int N) {
        int[][] dp = new int[N][4];

        dp[0][0] = Math.max(arr[0][1], arr[0][2]);
        dp[0][1] = Math.max(arr[0][0], arr[0][2]);
        dp[0][2] = Math.max(arr[0][0], arr[0][1]);
        dp[0][3] = 0;

        for(int i=0; i<=2; i++) {
            dp[0][3] = Math.max(dp[0][3], arr[0][i]);
        }


        for(int day = 1; day < N; day++) {

            for(int last=0; last<=3; last++) {

                for(int task = 0; task <= 2; task++) {
                    if(task != last) {
                        int point = arr[day][task] + dp[day-1][task];
                        dp[day][last] = Math.max(dp[day][last], point);
                    }
                }
            }
        }


        return dp[N-1][3];
    }


    // space optimization
    public int maximumPointsOptimized(int arr[][], int N) {
        int[] prev = new int[4];

        prev[0] = Math.max(arr[0][1], arr[0][2]);
        prev[1] = Math.max(arr[0][0], arr[0][2]);
        prev[2] = Math.max(arr[0][0], arr[0][1]);
        prev[3] = 0;

        for(int i=1; i<=2; i++) {
            prev[3] = Math.max(prev[3], arr[0][i]);
        }


        for(int day=1; day<N; day++) {
            int[] temp = new int[4];

            for(int last = 0; last <= 3; last++) {
                temp[last] = 0;  // Initialize current last task's value
                for(int task = 0; task <= 2; task++) {
                    if (task != last) {  // Can't take the same task as last
                        temp[last] = Math.max(temp[last], arr[day][task] + prev[task]);
                    }
                }
            }

            prev = temp;
        }

        return prev[3];
    }

    public static void main(String... args) {
        int[][] arr = {
                {2,1,3},
                {3,4,6},
                {10,1, 6},
                {8, 3, 7}
        };


        System.out.println(train(3,3,arr));
        System.out.println(maximumPoints(arr, arr.length));
        int[][] dp = new int[4][4];
        for(int i=0; i<dp.length; i++) {
            for(int j=0; j<dp[i].length; j++) {
                dp[i][j] = -1;
            }
        }
        System.out.println(trainMemoization(3,3,arr,dp));
    }
}
