package array.medium;

import util.IIntutuionClass;
import util.IOptimalClass;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
//leetCode 1686
public class StoneGameVI implements IIntutuionClass, IOptimalClass {
    public static final int[] aliceValues = {1, 3}, bobValues = {2, 1};

    public static void main(String[] args) {
        var cls = new StoneGameVI();
        cls.bruteForce();
    }

    class PointsI implements Comparable<PointsI>{
        int v;
        int i;

        public PointsI(int v, int i) {
            this.v = v;
            this.i = i;
        }

        @Override
        public int compareTo(PointsI o) {
            return o.v - this.v;
        }
    }

    @Override
    public void optimal() {
        PointsI[] pArr = new PointsI[aliceValues.length];
        for(int i=0;i<pArr.length;i++){
            pArr[i] = new PointsI(aliceValues[i]+bobValues[i], i);
        }
        Arrays.sort(pArr);
        var a =0;
        var b =0;
        for(int i=0;i< pArr.length;i++) {
            if(i%2==0) a+=aliceValues[pArr[i].i];
            else b+=bobValues[pArr[i].i];
        }
        int ans = Integer.compare(a,b);
        System.out.println(ans);
    }

    class Points implements Comparable<Points>{
        int m, a, b;

        public Points(int m, int a, int b) {
            this.m = m;
            this.a = a;
            this.b = b;
        }

        @Override
        public int compareTo(Points o) {
            return o.m-this.m;
        }
    }

    @Override
    public void bruteForce() {
        var pq = new PriorityQueue<Points>(Collections.reverseOrder());
        for (int i = 0; i < aliceValues.length; i++) {
            pq.offer(new Points(aliceValues[i]+bobValues[i],aliceValues[i],bobValues[i]));
        }
        System.out.println(pq);
        int a = 0;
        int b = 0;
        var flag = true;
        while (!pq.isEmpty()) {
            if (flag) {
                a += pq.poll().a;
                flag = false;
            } else {
                b += pq.poll().b;
                flag = true;
            }
        }
        var ans = Integer.compare(a, b);
        System.out.println(ans);
    }
}
