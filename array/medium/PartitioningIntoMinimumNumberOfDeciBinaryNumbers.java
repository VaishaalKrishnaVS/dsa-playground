package array.medium;

import util.IIntutuionClass;
//leetCode 1689
public class PartitioningIntoMinimumNumberOfDeciBinaryNumbers implements IIntutuionClass {
    public static final String n = "27346209830709182346";

    public static void main(String[] args) {
        var cls = new PartitioningIntoMinimumNumberOfDeciBinaryNumbers();
        cls.bruteForce();
    }
    @Override
    public void bruteForce() {
        int max = Integer.MIN_VALUE;
        for(char ch: n.toCharArray()){
            max = Math.max(max, Character.getNumericValue(ch));
        }
        System.out.println(max);
    }
}
