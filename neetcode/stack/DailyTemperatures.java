package neetcode.stack;

import util.IBaseClassV2;

import java.util.Arrays;
import java.util.Stack;

public class DailyTemperatures implements IBaseClassV2<int[], int[]> {
    public static void main(String[] args) {
        var cls = new DailyTemperatures();
        System.out.println(Arrays.toString(cls.optimal(new int[]{73, 74, 75, 71, 69, 72, 76, 73})));
    }
    @Override
    public int[] intution(int[] temp) {
        int n = temp.length;
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[n];
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && temp[i]>=temp[st.peek()]) st.pop();
            if(!st.isEmpty()) ans[i] = st.peek()-i;
            st.push(i);
        }
        return ans;
    }

    // space optimised
    @Override
    public int[] optimal(int[] temp) {
        int n = temp.length;
        int[]ans = new int[n];
        int h=-1;
        for(int i=n-1;i>=0;i--){
            if(temp[i]>=h){
                h=temp[i];
                continue;
            }
            int d=1;
            while(temp[i+d]<=temp[i]) d+=ans[i+d];
            ans[i] = d;
        }
        return ans;
    }
}
