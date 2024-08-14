package day21;

public class NumberOfSubstringContainingAll3Characters {


    /*
       BRUTE APPROACH
       TC: O(n ^ 2)
       SC: O(1)
     */
    public int numberOfSubstrings(String s) {
        int count = 0;
        int n = s.length();
        for(int i=0; i<n; i++) {
            int[] hash = new int[3];
            for(int j=i; j<n; j++) {
                hash[s.charAt(j) - 'a'] = 1;
                if(hash[0] + hash[1] + hash[2] == 3) {
                    count += (n - j);
                    break;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {

    }
}
