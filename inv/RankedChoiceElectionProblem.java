package inv;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.PriorityQueue;

public class RankedChoiceElectionProblem {

    static class Contestants implements Comparable<Contestants> {
        Character name;
        int points;
        int p1Rank;
        int p2Rank;
        int p3Rank;

        public Contestants(Character name) {
            this.name = name;
        }

        @Override
        public int compareTo(Contestants o) {
            if (this.points != o.points) return Integer.compare(o.points, this.points);
            if (this.p1Rank != o.p1Rank) return Integer.compare(o.p1Rank, this.p1Rank);
            if (this.p2Rank != o.p2Rank) return Integer.compare(o.p2Rank, this.p2Rank);
            return Integer.compare(o.p3Rank, this.p3Rank);
        }

    }

    public static void main(String[] args) {
        List<List<String>> votes = List.of(List.of("K", "B", "C"), List.of("K", "B", "C"), List.of("K", "Z"), List.of("B"), List.of("C", "B"));
        var map = new HashMap<Character, Contestants>();
        for (List<String> vote : votes) {
            int points = 3;
            for (String s : vote) {
                map.computeIfAbsent(s.charAt(0), _ -> new Contestants(s.charAt(0))).points += points;
                switch (points) {
                    case 1 -> map.get(s.charAt(0)).p3Rank++;
                    case 2 -> map.get(s.charAt(0)).p2Rank++;
                    case 3 -> map.get(s.charAt(0)).p1Rank++;
                }
                points--;
            }
        }
        PriorityQueue<Contestants> pq = new PriorityQueue<>();
        pq.addAll(map.values());
        System.out.println(Objects.requireNonNull(pq.poll()).name);
    }
}
