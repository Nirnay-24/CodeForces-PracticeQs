/*
--------------------------------------------
Problem: #8 - How Much Does Daytona Cost?
Problem Link  : https://codeforces.com/problemset/problem/1878/A

Problem Statement Summary:
You are given an array `a` of size `n`. You are also given an integer `k`. 
You need to determine whether there exists a subsegment of `a` such that 
`k` is the most frequent element in that subsegment.

Input Format:
- The first line contains a single integer `t` (1 ≤ t ≤ 1000) — the number of test cases.
- The first line of each test case contains two integers `n` and `k` (1 ≤ n ≤ 100, 1 ≤ k ≤ 100).
- The second line contains `n` integers a₁, a₂, ..., aₙ (1 ≤ aᵢ ≤ 100) — the elements of the array.

Output Format:
For each test case, print "YES" if there exists a subsegment in which `k` is the most frequent element.
Otherwise, print "NO".

Example:
Input:
3
5 4
1 4 3 4 1
4 1
2 3 4 4
5 6
43 5 60 4 2

Output:
YES
NO
NO
*/

import java.util.*;

public class _8_HowMuchDoesDaytonaCost {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); // Number of test cases
        while (t-- > 0) {
            int n = sc.nextInt(); // Size of array
            int k = sc.nextInt(); // Target element
            boolean found = false; // To track if k appears at least once
            for (int i = 0; i < n; i++) {
                int x = sc.nextInt(); // Read array element
                if (x == k) found = true; // If current element is equal to k
            }
            // If k was found at least once, it forms a valid subsegment
            System.out.println(found ? "YES" : "NO");
        }
    }
}


/*
--------------------------------------------
DETAILED EXPLANATION OF LOGIC AND ANALYSIS
--------------------------------------------

APPROACH (Very Easy to Understand):

Note: A subsegment is any contiguous sequence of elements (including of length 1).

- The problem asks if there exists any subsegment where `k` is the most frequent.
- A subsegment can be of any length, including just 1 element.
- So, if the value `k` exists even once in the array, then it itself forms a subsegment 
  where `k` is obviously the most frequent (since it's the only one).
- Therefore, the only condition we need to check is: Does `k` appear in the array at least once?

--------------------------------------------
USAGE OF DATA STRUCTURES:
--------------------------------------------

1. `Scanner`:
   - Purpose: To read input from the user.
   - Initialization:
     ```java
     Scanner sc = new Scanner(System.in);
     ```
   - Functions used:
     - `sc.nextInt()` → Reads the next integer from input.

2. `boolean` variable `found`:
   - Purpose: To indicate whether `k` has been found in the array.
   - Initialization:
     ```java
     boolean found = false;
     ```
   - Usage:
     - Set to `true` if any array element equals `k`.

--------------------------------------------
TIME COMPLEXITY AND PERFORMANCE ANALYSIS
--------------------------------------------

PER TEST CASE:
- Input reading: O(n)
- Logic (scan array once): O(n)

TOTAL:
- For `t` test cases with max `n = 100`:
  → Max operations = t * n = 1000 * 100 = 10^5 → ✅ Efficient

✅ Confirmed efficient under standard competitive programming limits.

COMPETITIVE LIMITS:
- 1 second = approx 10^8 operations allowed
- Our code performs at most 10^5 operations → Very Safe

--------------------------------------------
SPACE COMPLEXITY
--------------------------------------------

- O(1) additional space used per test case.
- No extra data structures like arrays or maps used.

--------------------------------------------
SUMMARY
--------------------------------------------

- We simply check if `k` appears at least once in the array.
- If yes → single-element subsegment with value `k` exists → answer is "YES".
- If no → `k` cannot be most frequent anywhere → answer is "NO".
- Time and space efficient, handles edge cases like smallest and largest n.
*/
