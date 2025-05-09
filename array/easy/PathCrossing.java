package array.easy;

import util.IBaseClass;

import java.util.HashSet;

//leetCode 1496
public class PathCrossing implements IBaseClass {

    private static final String path = "NES";
    private record Dir(int ns, int ew){}

    public static void main(String[] args) {
        var cls = new PathCrossing();
        cls.better();
    }

    @Override
    public void bruteForce() {
        var map = new HashSet<Dir>();
        map.add(new Dir(0,0));
        int ns = 0;
        int ew =0;
        for(char ch: path.toCharArray()){
            switch (ch){
                case 'N'-> ns++;
                case 'E'-> ew++;
                case 'S'-> ns--;
                case 'W'-> ew--;
                default -> {}
            }
            var cur = new Dir(ns,ew);
            if(map.contains(cur)){
                System.out.println(true);
                return;
            }
            map.add(cur);
        }
        System.out.println(false);
    }

    @Override
    public void better() {
        int[][] arr = new int[10001][10001];
        arr[0][0] = -1;
        int ns = 0;
        int ew = 0;
        for(char ch: path.toCharArray()){
            switch (ch){
                case 'N'-> ns++;
                case 'E'-> ew++;
                case 'S'-> ns--;
                case 'W'-> ew--;
                default -> {}
            }
            if(arr[ns][ew]==-1) {
                System.out.println(true);
                return;
            }
            arr[ns][ew] =-1;
        }
        System.out.println(false);
    }

    @Override
    public void optimal() {
        var map = new HashSet<String>();
        map.add("0.0");
        int ns = 0;
        int ew =0;
        for(char ch: path.toCharArray()){
            switch (ch){
                case 'N'-> ns++;
                case 'E'-> ew++;
                case 'S'-> ns--;
                case 'W'-> ew--;
                default -> {}
            }
            var cur = ns+"."+ew;
            if(map.contains(cur)){
                System.out.println(true);
                return;
            }
            map.add(cur);
        }
        System.out.println(false);
    }
}
