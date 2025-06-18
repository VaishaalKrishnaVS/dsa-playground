package neetcode.stack;

import util.IBaseClassV2;

import java.util.Stack;

public class LargestRectangleInHistogram implements IBaseClassV2<Integer, int[]> {
    public static void main(String[] args) {
        var cls = new LargestRectangleInHistogram();
        System.out.println("Intuition:");
        System.out.println(cls.intution(new int[]{2, 1, 5, 6, 2, 3}));
        System.out.println("Optimal:");
        System.out.println(cls.optimal(new int[]{2, 1, 5, 6, 6, 6, 2, 3}));
    }

    @Override
    public Integer intution(int[] h) {
        int[] pse = calcPSE(h);
        int[] nse = calcNSE(h);
        int ans = Integer.MIN_VALUE;
        for(int i=0;i<h.length;i++){
            ans = Math.max(ans, h[i]*(nse[i]-pse[i]-1));
        }
        return ans;
    }

    private int[] calcPSE(int[] arr) {
        int[] ans = new int[arr.length];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < arr.length; i++) {
            while (!st.isEmpty() && arr[i] <= arr[st.peek()]) {
                st.pop();
            }
            if (st.isEmpty()) {
                ans[i] = -1;
                st.push(i);
                continue;
            }
            ans[i] = st.peek();
            st.push(i);
        }
        return ans;
    }

    private int[] calcNSE(int[] arr) {
        int[] ans = new int[arr.length];
        Stack<Integer> st = new Stack<>();

        for (int i = arr.length - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[i] <= arr[st.peek()]) st.pop();
            if (st.isEmpty()) {
                ans[i] = arr.length;
            } else ans[i] = st.peek();
            st.push(i);
        }
        return ans;
    }

    @Override
    public Integer optimal(int[] h) {
        Stack<Integer>st = new Stack<>();
        int ans = Integer.MIN_VALUE;
        for(int i=0;i<h.length;i++){
            while(!st.isEmpty() && h[i]<h[st.peek()]){
                int tv = h[st.pop()];
                int pi = st.isEmpty()?-1:st.peek();
                ans = Math.max(ans, tv*(i-pi-1));
            }
            st.push(i);
        }
        while(!st.isEmpty()){
            int tv = h[st.pop()];
            int pi = st.isEmpty()?-1:st.peek();
            ans = Math.max(ans, tv*(h.length-pi-1));
        }
        return ans;
    }
}
