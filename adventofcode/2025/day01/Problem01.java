package adventofcode.year2025.day01;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Problem01 {

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
            Long turns = Long.valueOf(s.substring(1)) % 100;

            switch (dir) {
                case L -> {
                    start -= turns;
                    start = start < 0 ? start + 100 : start;
                }
                case R -> {
                    start += turns;
                    start %= 100;
                }
            }
            count += start == 0 ? 1 : 0;
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
