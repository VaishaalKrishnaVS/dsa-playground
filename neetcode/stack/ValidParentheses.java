package neetcode.stack;

import util.IBaseClassV2;

import java.util.Stack;

public class ValidParentheses implements IBaseClassV2<Boolean, String> {
    public static void main(String[] args) {
        var cls = new ValidParentheses();
        System.out.println(cls.intution("()[]{}"));
    }

    @Override
    public Boolean intution(String s) {
        var st = new Stack<Character>();
        for(char ch:s.toCharArray()){
            if(ch=='['||ch=='{'||ch=='(')st.addElement(ch);
            else{
                if(ch==']'&&st.pop()!='[') return false;
                else if(ch=='}'&&st.pop()!='{') return false;
                else if(ch==')'&&st.pop()!='(') return false;
            }
        }
        return st.empty();
    }
}
