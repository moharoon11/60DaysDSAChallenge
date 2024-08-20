package day25;

import java.util.Arrays;

public class ShortestJobFirstOrCPUScheduling {

    static int solve(int bt[] ) {

        Arrays.sort(bt);

        int time = 0;
        int wt = 0;
        for(int i=0; i<bt.length; i++) {
            time += wt;
            wt += bt[i];
        }

        return (int) Math.floor(time / bt.length);
    }

}
