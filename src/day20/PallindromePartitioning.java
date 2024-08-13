package day20;
import java.util.List;
import java.util.ArrayList;

public class PallindromePartitioning {

    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        List<String> path = new ArrayList<>();
        func(s, 0, result, path);
        return result;
    }

    public void func(String s, int index, List<List<String>> result, List<String> path) {
        if(index == s.length()) {
            result.add(new ArrayList<>(path));
            return;
        }

        for(int i = index; i<s.length(); i++) {
            if(isPallindrome(s, index, i)) {
                path.add(s.substring(index, i+1));
                func(s, i + 1, result, path);
                path.remove(path.size() - 1);
            }
        }
    }


    public boolean isPallindrome(String s, int left,int right) {

        while(left <= right) {
            if(s.charAt(left++) != s.charAt(right--)) {
                return false;
            }
        }

        return true;
    }

}
