package array.easy;

import util.IBaseClass;
//leetCode 2864
public class MaximumOddBinaryNumber implements IBaseClass {
    public static final String s = "01011";

    public static void main(String[] args) {
        var cls = new MaximumOddBinaryNumber();
        cls.better();
    }
    @Override
    public void bruteForce() {
        int o=0;
        int n = s.length();
        for(char ch: s.toCharArray()){
            if(ch=='1')  o++;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("1".repeat(Math.max(0, o-1)));
        sb.append("0".repeat(Math.max(0, n - o)));
        sb.append("1");
        System.out.println(sb);

    }

    @Override
    public void better() {
        var chArr = s.toCharArray();
        int i=0,j=s.length()-1;
        while(i<=j){
            while (chArr[j]=='0')j--;
            while (chArr[i]=='1')i++;
            if(i<=j && chArr[i]=='0' && chArr[j]=='1') swap(chArr, i ,j);
            i++;
            j--;
        }
        swap(chArr, i-1, s.length()-1);
        System.out.println(chArr);
    }
    private static void swap(char[] arr, int i, int j){
        char ch = arr[i];
        arr[i] = arr[j];
        arr[j] = ch;
    }

    @Override
    public void optimal() {

    }
}
