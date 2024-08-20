package day25;

import java.util.Arrays;

public class JobSequenceProgram {

    public static class Job {

        int id;
        int deadLine;
        int profit;

        public Job(int id, int deadLine, int profit) {
            this.id = id;
            this.deadLine = deadLine;
            this.profit = profit;
        }

    }

    public static int[] getMaxProfit(Job[] arr, int n) {
        Arrays.sort(arr, (Job a, Job b) -> b.profit - a.profit);
        int maxi = 0;

        for(int i=0; i<n; i++) {
            maxi = Math.max(maxi, arr[i].deadLine);
        }

        int[] hash = new int[maxi + 1];

        for (int i = 1; i <= maxi; i++) {
            hash[i] = -1;
        }
        int countJobs = 0;
        int maxProfit = 0;

        for(int i=0; i<n; i++) {

            for(int j = arr[i].deadLine; j > 0; j--) {
                if(hash[j] == -1) {
                    hash[j] = i;
                    countJobs++;
                    maxProfit += arr[i].profit;
                    break;
                }
            }
        }

        return new int[] {countJobs, maxProfit};
    }

    public static void main(String[] args) {

    }

}
