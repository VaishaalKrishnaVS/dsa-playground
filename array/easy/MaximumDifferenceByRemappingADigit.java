package array.easy;

import util.IBaseClass;

import java.util.Arrays;
import java.util.stream.Collectors;
//leetCode 2566
public class MaximumDifferenceByRemappingADigit implements IBaseClass {
    public static final int num = 11891;

    public static void main(String[] args) {
        var cls = new MaximumDifferenceByRemappingADigit();
        cls.better();
    }
    @Override
    public void bruteForce() {
        var ar = String.valueOf(num).chars().map(ch->ch-'0').toArray();
        int min = ar[0];
        int max = ar[0];
        for(int i:ar){
            if(i!=9){
                max=i;
                break;
            }
        }
        final int m = max;
        var nar = Integer.parseInt(Arrays.stream(ar).map(i->i==m?9:i).mapToObj(String::valueOf).collect(Collectors.joining()));
        var iar = Integer.parseInt(Arrays.stream(ar).map(i->i==min?0:i).mapToObj(String::valueOf).collect(Collectors.joining()));
        System.out.println(nar);
        System.out.println(iar);
        System.out.println(nar-iar);

    }

    @Override
    public void better() {
        var n = String.valueOf(num);
        char min = n.charAt(0);
        char max = n.charAt(0);;
        for(char ch:n.toCharArray()) if(ch!='9'){
            max = ch;
            break;
        }
        var ans = Integer.parseInt(n.replace(max,'9' ))-Integer.parseInt(n.replace(min,'0' ));
        System.out.println(ans);

    }

    @Override
    public void optimal() {

    }
}
