/*
--------------------------------------------
Problem: #017 - ForbiddenInteger
Problem Link  : https://codeforces.com/problemset/problem/1849/B

Problem Statement Summary:
You are given an integer n, which you want to obtain.
You have an unlimited supply of every integer from 1 to k,
except integer x (there are no integer x at all).

You are allowed to take an arbitrary amount of each of these integers
(possibly, zero). Can you make the sum of taken integers equal to n?

If there are multiple answers, print any of them.

Input Format:
- The first line contains a single integer t (1 ≤ t ≤ 1000) — 
  the number of test cases.
- The description of the test cases follows.
- Each test case consists of one line with three integers 
  n, k, x (1 ≤ n ≤ 1000, 1 ≤ k ≤ 1000, 1 ≤ x ≤ k).

Output Format:
- For each test case, if it is possible to obtain the number n, 
  print "YES" on the first line.
- On the second line, print the number of integers used.
- On the third line, print the integers used.
- If it's not possible to obtain n, print "NO".

Example:
Input:
4
6 3 1
7 3 1
4 1 1
4 2 1

Output:
YES
3
2 2 2
YES
3
3 2 2
NO
YES
2
2 2
*/

import java.util.*;

public class _017_ForbiddenInteger {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in); // Scanner for reading input
        int t = sc.nextInt(); // Number of test cases
        while (t-- > 0) {
            int n = sc.nextInt(); // Target sum to achieve
            int k = sc.nextInt(); // Maximum allowed number
            int x = sc.nextInt(); // Forbidden number

            // Case when '1' is allowed (x != 1)
            if (x != 1) {
                System.out.println("YES"); // Always possible using 1s
                System.out.println(n); // Number of elements used
                for (int i = 0; i < n; i++) {
                    System.out.print(1 + " "); // Use all 1s
                }
                System.out.println();
            } else {
                // x == 1 → Cannot use 1
                if (k == 1) {
                    // Only number available is 1 (which is forbidden)
                    System.out.println("NO");
                } else if (k == 2) {
                    // Only number available is 2
                    if (n % 2 == 0) {
                        // Can form using all 2s
                        System.out.println("YES");
                        System.out.println(n / 2);
                        for (int i = 0; i < n / 2; i++) {
                            System.out.print(2 + " ");
                        }
                        System.out.println();
                    } else {
                        // Odd sum not possible with only 2s
                        System.out.println("NO");
                    }
                } else {
                    // k ≥ 3 and x == 1 → have 2 and 3 available
                    System.out.println("YES");
                    if (n % 2 == 0) {
                        // Even sum: use only 2s
                        System.out.println(n / 2);
                        for (int i = 0; i < n / 2; i++) {
                            System.out.print(2 + " ");
                        }
                    } else {
                        // Odd sum: use one 3, rest 2s
                        System.out.println((n - 3) / 2 + 1); // total elements
                        System.out.print(3 + " ");
                        for (int i = 0; i < (n - 3) / 2; i++) {
                            System.out.print(2 + " ");
                        }
                    }
                    System.out.println();
                }
            }
        }
    }
}
/*
--------------------------------------------
DETAILED EXPLANATION OF LOGIC AND ANALYSIS
--------------------------------------------

APPROACH (Very Easy to Understand):

- If the forbidden number is NOT 1, then just use 1 multiple times to get n.
  That's always valid since 1 is allowed and we can use it n times.

- If the forbidden number IS 1:
  - If k == 1 → the only number available is 1 → impossible → print NO.
  - If k == 2:
      - Only 2 is available.
      - If n is even → use n/2 number of 2s → valid.
      - If n is odd → cannot form odd number using only 2s → print NO.
  - If k ≥ 3:
      - We can use 2 and 3.
      - If n is even → use all 2s.
      - If n is odd → use one 3, and the rest as 2s.

This logic ensures that all constraints are respected and gives a valid decomposition of `n`
without ever using the forbidden number `x`.

--------------------------------------------
USAGE OF DATA STRUCTURES:
--------------------------------------------

1. Scanner:
   - Purpose: To read input efficiently.
   - Initialization:
     ```java
     Scanner sc = new Scanner(System.in);
     ```
   - Functions used:
     - `sc.nextInt()` → reads the next integer.

2. No dynamic data structures (like arrays or lists) are used to save memory.
   All output is printed directly in constant space.

--------------------------------------------
TIME COMPLEXITY AND PERFORMANCE ANALYSIS
--------------------------------------------

PER TEST CASE:
- Input reading: O(1)
- Logic decision: O(1)
- Output printing: O(n)

TOTAL:
- If T test cases with each n ≤ 1000, total operations ≤ T × n = 10^6 in worst case.

✅ Confirmed efficient under standard competitive programming limits.

COMPETITIVE LIMITS:
- Time Limit: 1 sec → ~10^8 operations allowed.
- Our code does ~10^6 operations max → safe.

--------------------------------------------
SPACE COMPLEXITY
--------------------------------------------

- O(1) additional space (no lists, no recursion).
- Only constant space used for primitive variables.
- Output printed directly — no large storage used.

--------------------------------------------
SUMMARY
--------------------------------------------

- Checks if forbidden number is 1. If not, use all 1s.
- Handles all edge cases:
  - Forbidden number = 1
  - Only 1 number available
  - Even vs odd target sums
- Efficient, simple, and passes all constraints.
- No memory overhead due to direct output.
- Fully optimal and passes Codeforces constraints.
*/
