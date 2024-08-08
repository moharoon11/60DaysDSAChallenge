package day16;

import java.util.ArrayList;
import java.util.List;

public class RemoveKDigits {

    public String removeKdigits(String num, int k) {
        if(k == num.length()) return "0";

        List<Character> list = new ArrayList<>();
        StringBuilder result = new StringBuilder("");

        for(int i=0; i<num.length(); i++) {

            while(!list.isEmpty() &&  k > 0 && list.get(list.size()-1) - '0' > num.charAt(i) - '0') {
                list.remove(list.size() - 1);
                k -= 1;
            }

            list.add(num.charAt(i));
        }

        while(!list.isEmpty() && k > 0) {
            list.remove(list.size() - 1);
            k -= 1;
        }

        // we need to remove all the leading zeros
        for (char c : list) {
            if (result.length() == 0 && c == '0') {
                continue; // Skip leading zeros
            }
            result.append(c);
        }



        if(result.length() == 0) return "0";
        return result.toString();
    }

}
