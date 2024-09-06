package day34.StringParanthesisProblems;

import java.util.*;

public class GenerateParanthesis {

    public List<String> generateParenthesis(int n) {
        return func("(" , n, 1, 0, 1);
    }

    public List<String> func(String s, int n, int opc, int cpc, int count) {

        if(count < 0) return new ArrayList<>();

        if(s.length() == n * 2) {
            if(count == 0) {
                ArrayList<String> list = new ArrayList<>();
                list.add(s);
                return list;
            }
        }


        List<String> validParanthesis = new ArrayList<>();
        if(opc <= n) {
            validParanthesis.addAll(func(s + "(", n, opc + 1, cpc, count + 1));
        }

        if(cpc <= n) {
            validParanthesis.addAll(func(s + ")", n, opc, cpc + 1, count - 1));
        }

        return validParanthesis;
    }
}
