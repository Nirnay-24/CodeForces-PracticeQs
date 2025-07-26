/*
--------------------------------------------
Problem: #9 - Goals of Victory
Problem Link  : https://codeforces.com/problemset/problem/1877/A

Problem Statement Summary:
There are n teams in a football tournament. Each pair of teams plays once.
The efficiency of a team is the total goals scored by that team minus the total goals conceded.
The efficiency of (n - 1) teams is given. Find the efficiency of the remaining team.

Input Format:
- The first line contains an integer t (1 ≤ t ≤ 500) — the number of test cases.
- For each test case:
    - The first line contains a single integer n (2 ≤ n ≤ 100) — the number of teams.
    - The second line contains n - 1 integers a1, a2, ..., a(n−1) (−100 ≤ ai ≤ 100) — the efficiency of the known teams.

Output Format:
- For each test case, output one line containing an integer — the efficiency of the missing team.

Example:
Input:
2
4
3 -4 5
11
-30 12 -57 7 0 -81 -68 41 -89 0

Output:
-4
265
*/

import java.util.*;

public class _9_GoalsOfVictory {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in); // Scanner to read input
        int t = sc.nextInt(); // Number of test cases
        while(t-- > 0){
            int n = sc.nextInt(); // Number of teams
            int[] a = new int[n]; // Array to store (n - 1) known efficiencies and last one as sum
            a[n-1] = 0; // Initialize last element as 0 to accumulate sum of efficiencies
            for(int i = 0; i < n-1; i++){
                a[i] = sc.nextInt(); // Read efficiency of each of the (n - 1) teams
                a[n-1] += a[i]; // Accumulate total efficiency of known teams
            }
            System.out.println((-1) * a[n-1]); // The missing team's efficiency is negative of the total
        }
    }
}


/*
--------------------------------------------
DETAILED EXPLANATION OF LOGIC AND ANALYSIS
--------------------------------------------

APPROACH (Very Easy to Understand):

- Each team's efficiency is defined as: (total goals scored) - (total goals conceded).
- In a full round-robin tournament, all goals scored by one team are goals conceded by another.
- Therefore, the **sum of all teams' efficiencies must be 0**.
- If efficiencies of (n - 1) teams are given, then the missing team's efficiency is:
  
        missing = -(sum of the given (n-1) efficiencies)

- The code reads all given efficiencies, sums them, and prints the negative of that sum.

--------------------------------------------
USAGE OF DATA STRUCTURES:
--------------------------------------------

1. int[] array `a`:
   - Purpose: To store the given efficiencies and use the last slot to store the sum.
   - Initialization:
     ```java
     int[] a = new int[n];
     a[n - 1] = 0;
     ```
   - Functions used:
     - `a[i] = sc.nextInt()` → reads input into the array
     - `a[n-1] += a[i]` → sums up all given efficiencies into the last index

--------------------------------------------
TIME COMPLEXITY AND PERFORMANCE ANALYSIS
--------------------------------------------

PER TEST CASE:
- Input reading: O(n)
- Summation logic: O(n)

TOTAL:
- Overall complexity per test case: O(n)
- Total operations in worst case (500 test cases, 100 teams each) = 500 * 100 = 50,000 operations

✅ Confirmed efficient under standard competitive programming limits.

COMPETITIVE LIMITS:
- 1 sec → ~10^8 operations allowed
- Code operations: ~50,000 in worst case

--------------------------------------------
SPACE COMPLEXITY
--------------------------------------------

- O(n) for the integer array to hold efficiencies (at most size 100)

--------------------------------------------
SUMMARY
--------------------------------------------

- The code reads (n - 1) efficiency values per test case.
- The missing team's efficiency is just the negative sum of the given ones.
- An array is used to store and sum up efficiently.
- Guaranteed to run efficiently for all valid inputs within problem constraints.
*/
