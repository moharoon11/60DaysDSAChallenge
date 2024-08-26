package day30;

import java.util.*;

public class GenerateValidParanthesisOfSizeN {

    public static List<String> generateParenthesis(int n) {
        return generateValidParanthesis(n, "(", 1, 0, 1);
    }

    public static List<String> generateValidParanthesis(int n, String s, int opc, int cpc, int count)  {

        if(count < 0) {
            return new ArrayList<>();
        }

        if(s.length() == n * 2) {
            if(count == 0) {
                List<String> validParanthesis = new ArrayList<>();
                validParanthesis.add(s);
                return validParanthesis;
            }
        }


        ArrayList<String> answer = new ArrayList<>();
        if(opc <= n) {
            answer.addAll(generateValidParanthesis(n, s + "(", opc + 1, cpc, count + 1));
        }

        if(cpc <= n) {
            answer.addAll(generateValidParanthesis(n, s + ")", opc, cpc + 1, count - 1));
        }

        return answer;
    }

    public static void main(String[] args) {
        int n = 3;
        System.out.println(generateParenthesis(3));
    }
}
