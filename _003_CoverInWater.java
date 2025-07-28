/*
--------------------------------------------
Problem: #3 - Cover in Water
Problem Link  : https://codeforces.com/problemset/problem/1900/A

Problem Statement Summary:
Filip has a row of cells, some of which are blocked, and some are empty. 
He wants all empty cells to have water in them. He has two actions at his disposal:
1 — place water in an empty cell.
2 — remove water from a cell and place it in any other empty cell.
If at some moment cell 𝑖 (2 ≤ 𝑖 ≤ 𝑛 − 1) is empty and both cells 𝑖−1 and 𝑖+1 contain water, 
then it becomes filled with water.

Find the minimum number of times he needs to perform action 1 in order to fill all empty cells with water.

Note: You don't need to minimize the use of action 2. Blocked cells neither contain water nor can Filip place water in them.

Input Format:
- The first line contains the number of test cases 𝑡 (1 ≤ 𝑡 ≤ 100).
- Each test case:
  - The first line contains an integer 𝑛 (1 ≤ 𝑛 ≤ 100) — number of cells.
  - The second line contains a string 𝑠 of length 𝑛 consisting of '.' and '#'.

Output Format:
- For each test case, print the minimum number of type 1 actions needed to fill all empty cells with water.

Example:
Input:
5
3
...
7
##....#
7
..#.#..
4
####
10
#...#..#.# 

Output:
2
2
5
0
2
*/

import java.util.*;

public class _003_CoverInWater {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); // number of test cases

        while (t-- > 0) {
            int n = sc.nextInt(); // number of cells
            String s = sc.next(); // input string of cells

            char[] sArray = s.toCharArray(); // convert to character array
            int total = 0; // total minimum actions of type 1 needed
            int consecutive = 0; // count consecutive '.' cells between '#' or end

            for (int i = 0; i < sArray.length; i++) {
                if (sArray[i] == '#') {
                    // If we hit a blocked cell, evaluate the segment just before
                    if (consecutive == 0) {
                        continue;
                    } else if (consecutive == 1 || consecutive == 2) {
                        // Small segments of 1 or 2 can be covered by 1 or 2 actions
                        total += consecutive;
                    } else {
                        // Any segment of 3 or more requires at most 2 actions
                        total = 2;
                        break;
                    }
                    consecutive = 0; // reset for next segment
                    continue;
                } else if (sArray[i] == '.') {
                    if (i == sArray.length - 1) {
                        // If last character and it's '.', finalize the segment
                        if (consecutive == 0 || consecutive == 1) {
                            total += consecutive + 1;
                        } else {
                            total = 2;
                        }
                        break;
                    }
                    consecutive++; // count consecutive empty cells
                }
            }

            System.out.println(Math.min(total, 2)); // result is capped at 2
        }
    }
}


/*
--------------------------------------------
DETAILED EXPLANATION OF LOGIC AND ANALYSIS
--------------------------------------------

APPROACH (Very Easy to Understand):

- Filip can only place water using action 1, and it spreads via action 2 or automatic filling if surrounded.
- Water spreads when an empty cell has water on both left and right.
- We divide the row into segments of consecutive '.' (empty cells) between '#' or ends.
- For each such segment:
   - If length is 1 → requires 1 action.
   - If length is 2 → requires 2 actions.
   - If length ≥ 3 → at most 2 actions are enough using strategic placement and spreading.
- Therefore, for each segment of consecutive '.', we count its length and update the total accordingly.
- Since problem guarantees max requirement is 2 actions for any test case, we cap total at 2.

--------------------------------------------
USAGE OF DATA STRUCTURES:
--------------------------------------------

1. char[] sArray:
   - Purpose: To iterate character-by-character for checking '.' and '#'
   - Initialization:
     ```java
     char[] sArray = s.toCharArray();
     ```
   - Functions used:
     - Access via index (e.g., `sArray[i]`)

2. Scanner sc:
   - Purpose: Read input efficiently
   - Initialization:
     ```java
     Scanner sc = new Scanner(System.in);
     ```
   - Functions used:
     - `sc.nextInt()` → read integers
     - `sc.next()` → read string

--------------------------------------------
TIME COMPLEXITY AND PERFORMANCE ANALYSIS
--------------------------------------------

PER TEST CASE:
- Input reading: O(n)
- Logic (single pass over n): O(n)

TOTAL:
- O(t * n), where t ≤ 100, n ≤ 100 ⇒ max 10,000 operations

✅ Confirmed efficient under standard competitive programming limits.

COMPETITIVE LIMITS:
- 1 sec → 10^8 operations allowed
- Our code: Max ~10^4 operations (well within limit)

--------------------------------------------
SPACE COMPLEXITY
--------------------------------------------

- O(n) for the character array `sArray`
- O(1) auxiliary variables (`total`, `consecutive`)

--------------------------------------------
SUMMARY
--------------------------------------------

- We iterate through each string and break it into segments of consecutive empty cells.
- Each segment contributes either 1, 2, or at most 2 actions depending on its length.
- We cap the total result at 2 because longer segments never require more.
- This greedy + segment-based approach ensures correctness and efficiency.
*/
