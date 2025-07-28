/*
--------------------------------------------
Problem: #10 - Target Practice
Problem Link  : https://codeforces.com/problemset/problem/1873/C

Problem Statement Summary:
A 10×10 target is divided into 5 rings.  
Each ring has a specific point value.  
The outermost ring gives 1 point.  
The next ring gives 2 points, and so on.  
The center ring gives 5 points.  
Each 'X' marks an arrow on the grid.  
Count the total score from all arrows.

Input Format:
The first line contains one integer t (1 ≤ t ≤ 1000).  
It represents the number of test cases.  
Each test case has exactly 10 lines.  
Each line has 10 characters.  
Each character is either 'X' or '.'.  
'X' means an arrow hit. '.' means empty.

Output Format:
For each test case, print a single integer.  
It is the total score from the arrows.
*/

import java.util.*;

public class _10_TargetPractice {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in); // Scanner to read input
        int t = sc.nextInt(); // Number of test cases
        sc.nextLine(); // Consume the newline character after integer input

        while (t-- > 0) {
            String[] target = new String[10]; // To store 10 lines of the grid

            // Predefined score values based on ring location
            int[][] totalPoints = {
                {1,1,1,1,1,1,1,1,1,1},
                {1,2,2,2,2,2,2,2,2,1},
                {1,2,3,3,3,3,3,3,2,1},
                {1,2,3,4,4,4,4,3,2,1},
                {1,2,3,4,5,5,4,3,2,1},
                {1,2,3,4,5,5,4,3,2,1},
                {1,2,3,4,4,4,4,3,2,1},
                {1,2,3,3,3,3,3,3,2,1},
                {1,2,2,2,2,2,2,2,2,1},
                {1,1,1,1,1,1,1,1,1,1},
            };

            int total = 0; // Variable to keep track of the total score

            for (int i = 0; i < 10; i++) {
                target[i] = sc.nextLine(); // Read each line of the grid
                char[] targetArray = target[i].toCharArray(); // Convert line to character array
                for (int j = 0; j < 10; j++) {
                    if (targetArray[j] == 'X') { // If arrow hit detected
                        total += totalPoints[i][j]; // Add corresponding point from ring map
                    }
                }
            }

            System.out.println(total); // Output the total score for the test case
        }
    }
}

/*
--------------------------------------------
DETAILED EXPLANATION OF LOGIC AND ANALYSIS
--------------------------------------------

APPROACH (Very Easy to Understand):

- A 10×10 grid represents the target.
- The target is divided into concentric rings.
- Each ring has a score from 1 to 5, increasing towards the center.
- A predefined 2D array `totalPoints` holds these values.
- For each test case, read all 10 lines.
- For each character in the grid:
    - If it is 'X', that means an arrow landed.
    - Add the corresponding ring score from `totalPoints`.
- After scanning all characters, print the total score.

--------------------------------------------
USAGE OF DATA STRUCTURES:
--------------------------------------------

1. `String[] target`:
   - Purpose: To store each line (row) of the 10x10 target grid.
   - Initialization:
     ```java
     String[] target = new String[10];
     ```
   - Functions used:
     - `sc.nextLine()` → to read each row from input

2. `int[][] totalPoints`:
   - Purpose: To map every cell of the grid to its respective score based on the ring position.
   - Initialization:
     ```java
     int[][] totalPoints = { ... };
     ```
   - Functions used:
     - Direct indexing `totalPoints[i][j]` to fetch score

3. `char[] targetArray`:
   - Purpose: To convert a string line into a character array for easy traversal.
   - Initialization:
     ```java
     char[] targetArray = target[i].toCharArray();
     ```
   - Functions used:
     - `toCharArray()` → to process each cell in a row

--------------------------------------------
TIME COMPLEXITY AND PERFORMANCE ANALYSIS
--------------------------------------------

PER TEST CASE:
- Input reading: O(10) lines * O(10) characters = O(100)
- Logic: Each cell checked once → O(100)

TOTAL:
- For T test cases: O(100 * T)
- Max T = 1000 → 100 * 1000 = 10^5 operations

✅ Confirmed efficient under standard competitive programming limits.

COMPETITIVE LIMITS:
- 1 sec → up to ~10^8 operations allowed
- Our code: ~10^5 operations (very fast)

--------------------------------------------
SPACE COMPLEXITY
--------------------------------------------

- O(1) auxiliary space (excluding input) because:
  - Fixed-size arrays (10x10)
  - No dynamic data structures used
- Input: 10x10 characters per test case → negligible (at most 1 MB total)

--------------------------------------------
SUMMARY
--------------------------------------------

- A simple 10x10 grid scan for 'X' marks.
- Used a predefined matrix to assign points.
- Straightforward addition for scoring.
- Code is clean, readable, and efficient.
- Handles all edge cases correctly.
*/
