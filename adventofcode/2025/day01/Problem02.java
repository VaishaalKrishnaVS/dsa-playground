package adventofcode.year2025.day01;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Problem02 {

    public enum Dir {
        L("L"),
        R("R");

        private final String displayName;

        Dir(String displayName) {
            this.displayName = displayName;
        }

        public String getDisplayName() {
            return this.displayName;
        }
    }

    public static void main(String[] args) {
        int start = 50;
        int count = 0;
        var list = readFromFile();

        for (var s : list) {
            char directionChar = s.charAt(0);
            Dir dir = Dir.valueOf(String.valueOf(directionChar));
            Long turns = Long.valueOf(s.substring(1));
            count += turns / 100;
            turns %= 100;
            boolean isZ = start == 0 ? true : false;
            switch (dir) {
                case L -> {
                    start -= turns;
                    if (start < 0) {
                        count += isZ ? 0 : 1;
                        start += 100;
                    }
                }
                case R -> {
                    start += turns;
                    count += start == 100 ? 0 : start / 100;
                    start %= 100;
                }
            }
            count += start == 0 ? 1 : 0;
            System.out.println(String.format("Ans at itr: %d %d", start, count));

        }
        System.out.println(String.format("Ans: %d", count));
    }

    private static List<String> readFromFile() {
        var list = new ArrayList<String>();
        try (Scanner scn = new Scanner(new File("adventofcode/2025/day01/input_01.txt"))) {
            while (scn.hasNextLine()) {
                var data = scn.nextLine();
                list.add(data);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }
}
