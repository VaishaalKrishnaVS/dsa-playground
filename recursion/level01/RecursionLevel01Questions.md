# Recursion Level 01 - Problem Questions

## 1. KeyPad Combination Problem
**Problem:** Given a string containing digits from 1-8, return all possible letter combinations that the number could represent on a phone keypad.

**Keypad Mapping:**
```
1: ABC, 2: DEF, 3: GHI, 4: JKL, 5: MNO, 6: PQRS, 7: TUV, 8: WXYZ
```

**Example:** Input "12" → Output ["AD", "AE", "AF", "BD", "BE", "BF", "CD", "CE", "CF"]

---

## 2. Stairs Path Problem
**Problem:** Given n stairs, find all possible ways to reach the top where you can take 1, 2, or 3 steps at a time.

**Example:** n=3 → Output ["111", "12", "21", "3"]
- "111": take 1 step three times
- "12": take 1 step then 2 steps
- "21": take 2 steps then 1 step
- "3": take 3 steps at once

---

## 3. Maze Paths Problem
**Problem:** Find all possible paths from source (sr, sc) to destination (dr, dc) in a maze where you can only move horizontally right ('h') or vertically down ('v').

**Example:** From (1,1) to (3,3) → Output ["hhvv", "hvhv", "hvvh", "vhhv", "vhvh", "vvhh"]

---

## 4. Maze Path With Jumps Problem
**Problem:** Find all possible paths from source to destination where you can make variable-sized jumps in three directions:
- Horizontal jumps (H): move right by 1 to n steps
- Vertical jumps (V): move down by 1 to n steps
- Diagonal jumps (D): move diagonally down-right by 1 to n steps

**Example:** From (1,1) to (3,3) includes paths like "H2", "V1H1V1", "D2"

---

## 5. Subsequence of String Problem
**Problem:** Generate all possible subsequences of a given string. A subsequence is formed by deleting some (possibly zero) characters without changing the order of remaining characters.

**Example:** Input "abc" → Output ["", "a", "b", "c", "ab", "ac", "bc", "abc"]

---

## 6. String Permutations Problem
**Problem:** Generate and print all possible permutations of a given string. A permutation is a rearrangement of characters where each character appears exactly once.

**Example:** Input "abc" → Output ["abc", "acb", "bac", "bca", "cab", "cba"]

---

## 7. String Encodings Problem
**Problem:** Given a numeric string, print all possible decodings where: 1='a', 2='b', ..., 26='z'

**Example:** Input "123" → Output ["abc", "aw", "lc"]
- "123" can be decoded as "1-2-3" → "abc"
- "123" can be decoded as "12-3" → "lc"
- "123" can be decoded as "1-23" → "aw"

**Constraints:** Numbers 01-09 are invalid, only 1-26 are valid encodings

---

## 8. Flood Fill Path Finding Problem
**Problem:** Find all possible paths from top-left to bottom-right in a 2D board where 'O' represents open cells and '.' represents blocked cells.

**Movement directions:** 't' = top (up), 'l' = left, 'r' = right, 'd' = down

**Example:** 3×3 board with some blocked cells

---

## 9. Target Sum Subsets Problem
**Problem:** Find and print all subsets of given array that sum to target value. Each element can be either included or excluded from the subset.

**Example:** Array [10, 20, 30], Target 30 → Output ["10 20 ", "30 "]
- Subset {10, 20} sums to 30
- Subset {30} sums to 30

---

## 10. N-Queens Problem
**Problem:** Place N queens on an N×N chessboard such that no two queens attack each other. Queens can attack horizontally, vertically, and diagonally.

**Example:** 4×4 board has 2 solutions
- Solution 1: Queens at (0,1), (1,3), (2,0), (3,2)
- Solution 2: Queens at (0,2), (1,0), (2,3), (3,1)

---

## 11. Knight's Tour Problem
**Problem:** Find a sequence of moves for a knight on a chessboard such that the knight visits every square exactly once.

**Knight moves:** L-shape: 2 squares in one direction, 1 square perpendicular (8 possible directions)

**Example:** 8×8 board has multiple solutions where knight visits all 64 squares

---

## Common Patterns:
- **Time Complexity:** Most problems are O(2^n) or exponential
- **Space Complexity:** O(n) for recursion depth + problem-specific storage
- **Algorithm:** Backtracking with choice exploration
- **Approach:** Make choice → Recurse → Backtrack (undo choice)