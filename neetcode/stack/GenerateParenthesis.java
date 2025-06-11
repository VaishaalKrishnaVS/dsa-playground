package neetcode.stack;

import util.IBaseClassV2;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class GenerateParenthesis implements IBaseClassV2<List<String>, Integer> {
    public static void main(String[] args) {
        var cls = new GenerateParenthesis();
        List<String> resultFromIntuition = cls.intution(2);
        System.out.println("\nValid Combinations from Intuition method:");
        for (String s : resultFromIntuition) {
            System.out.println(s);
        }
        List<String> resultFromOptimal = cls.optimal(2);
        System.out.println("\nValid Combinations from Optimal method:");
        for (String s : resultFromOptimal) {
            System.out.println(s);
        }
    }

    @Override
    public List<String> intution(Integer param) {
        List<String> ans = new ArrayList<>();
        helper(ans, param, new StringBuilder(), 0);
        return ans;
    }

    private void helper(List<String> ans, int n, StringBuilder sb, int depth) {
        System.out.printf("%s→ %s\n", "  ".repeat(depth), sb.toString());
        if (sb.length() == 2 * n) {
            if (validateString(sb)) {
                ans.add(sb.toString());
                System.out.printf("%s✔ Valid: %s\n", "  ".repeat(depth), sb);
            } else {
                System.out.printf("%s✘ Invalid: %s\n", "  ".repeat(depth), sb);
            }
            return;
        }

        // Add '('
        sb.append('(');
        helper(ans, n, sb, depth + 1);
        sb.deleteCharAt(sb.length() - 1); // backtrack

        // Add ')'
        sb.append(')');
        helper(ans, n, sb, depth + 1);
        sb.deleteCharAt(sb.length() - 1); // backtrack
    }

    private boolean validateString(StringBuilder sb) {
        Stack<Character> st = new Stack<>();
        for (char ch : sb.toString().toCharArray()) {
            if (ch == '(') {
                st.push('(');
            } else {
                if (st.isEmpty()) return false;
                st.pop();
            }
        }
        return st.isEmpty();
    }

    @Override
    public List<String> optimal(Integer n) {
        List<String> ans = new ArrayList<>();
        optimalHelper(ans,n,n,new StringBuilder());
        return ans;
    }

    private void optimalHelper(List<String>ans, int open, int close, StringBuilder sb){
        if(open==0 && close==0){
            ans.add(sb.toString());
            return;
        }
        if(open>0){
            sb.append('(');
            optimalHelper(ans, open-1, close, sb);
            sb.deleteCharAt(sb.length()-1);
        }
        if(close>0 && close>open){
            sb.append(')');
            optimalHelper(ans, open, close-1, sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
