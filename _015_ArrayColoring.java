/*
--------------------------------------------
Problem: #15 - Array Coloring
Problem Link  : https://codeforces.com/problemset/problem/1857/A

Problem Statement Summary:
You are given an array consisting of n integers.  
Determine if it is possible to color all its elements  
in two colors such that the sum of both colors  
has the same parity.  
Each color must have at least one element.

Input Format:
- The first line contains an integer t (1 ≤ t ≤ 1000)  
  — the number of test cases.  
- Each test case contains a line with an integer n (2 ≤ n ≤ 50)  
  — the number of elements.  
- The next line contains n integers a1, a2, ..., an (1 ≤ ai ≤ 50).

Output Format:
- For each test case, print "YES" if it is possible.  
- Otherwise, print "NO".  
- You can print each letter in any case.

Example:
Input:
7
8
1 2 4 3 2 3 5 4
2
4 7
3
3 9 8
2
1 7
5
5 4 3 2 1
4
4 3 4 5
2
50 48

Output:
YES
NO
YES
YES
NO
YES
YES
*/

import java.util.*;

public class _015_ArrayColoring {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in); // Scanner to read input
        int t = sc.nextInt(); // Read number of test cases
        while (t-- > 0) {
            int n = sc.nextInt(); // Read the size of array
            int[] a = new int[n]; // Array to store elements
            int odd = 0; // Counter to track number of odd elements

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt(); // Read array element
                if (a[i] % 2 == 1) { // Check if it's odd
                    odd++; // Increment odd counter
                }
            }

            // If number of odd elements is even, answer is YES. Else, NO.
            if (odd % 2 == 0) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }
}

/*
--------------------------------------------
DETAILED EXPLANATION OF LOGIC AND ANALYSIS
--------------------------------------------

APPROACH (Very Easy to Understand):

- The problem requires checking if the array can be split into 
  two colored parts such that:
  - Each part has at least one element.
  - The sum of each part has the same parity 
    (either both even or both odd).

- Key insight:
  - If the count of odd numbers in the array is even, 
    then it's possible to split them such that the parity 
    of sums of the two groups is the same.
  - If the count of odd numbers is odd, it becomes 
    impossible to have equal parity on both sides.

- So, the solution is to count the number of odd elements:
  - If that count is even → print "YES"
  - Otherwise → print "NO"

--------------------------------------------
USAGE OF DATA STRUCTURES:
--------------------------------------------

1. int[] array `a`:
   - Purpose: To store the input elements for each test case
   - Initialization:
     ```java
     int[] a = new int[n];
     ```
   - Functions used:
     - `sc.nextInt()` → reads each number from input and stores in `a[i]`
     - `a[i] % 2` → checks whether the number is odd

2. int variable `odd`:
   - Purpose: To count how many odd numbers are present in the array
   - Initialization:
     ```java
     int odd = 0;
     ```
   - Used inside loop with increment when odd condition is true

--------------------------------------------
TIME COMPLEXITY AND PERFORMANCE ANALYSIS
--------------------------------------------

PER TEST CASE:
- Input reading: O(n)
- Logic: O(n) for counting odd numbers

TOTAL:
- With t test cases and max n = 50: O(t * n) = O(1000 * 50) = 50,000 operations

✅ Confirmed efficient under standard competitive programming limits.

COMPETITIVE LIMITS:
- 1 sec → ~10^8 operations allowed
- Our code: ~5 * 10^4 operations in worst case

--------------------------------------------
SPACE COMPLEXITY
--------------------------------------------

- O(n) for input array per test case
- O(1) for integer counters

--------------------------------------------
SUMMARY
--------------------------------------------

- The code solves the problem by checking the parity of the 
  number of odd elements.
- If the number of odd numbers is even, equal parity 
  partitioning is always possible.
- Uses a simple integer array and counter; no complex structures.
- Cleanly handles all edge cases due to valid input constraints.
*/
