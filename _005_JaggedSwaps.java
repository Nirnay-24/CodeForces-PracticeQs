/*
--------------------------------------------
Problem: #5 - Jagged Swaps
Problem Link  : https://codeforces.com/problemset/problem/1896/A

Problem Statement Summary:
You are given a permutation† 𝑎 of size 𝑛. You can do the following operation:

Select an index 𝑖 from 2 to 𝑛−1 such that 𝑎𝑖−1<𝑎𝑖 and 𝑎𝑖>𝑎𝑖+1. Swap 𝑎𝑖 and 𝑎𝑖+1.

Determine whether it is possible to sort the permutation after a finite number of operations.

† A permutation is an array consisting of 𝑛 distinct integers from 1 to 𝑛 in arbitrary order.

Input Format:
- The first line contains the number of test cases 𝑡 (1≤𝑡≤5000).
- The first line of each test case contains a single integer 𝑛 (3≤𝑛≤10) — the size of the permutation.
- The second line of each test case contains 𝑛 integers 𝑎1,𝑎2,…,𝑎𝑛 (1≤𝑎𝑖≤𝑛).

Output Format:
- For each test case, print "YES" if it is possible to sort the permutation, and "NO" otherwise.

Example:
Input:
6
3
1 2 3
5
1 3 2 5 4
5
5 4 3 2 1
3
3 1 2
4
2 3 1 4
5
5 1 2 3 4

Output:
YES
YES
NO
NO
NO
NO
*/

import java.util.*;

public class _005_JaggedSwaps {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); // Read number of test cases
        while (t-- > 0) {
            int n = sc.nextInt(); // Read size of permutation
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt(); // Read permutation values
            }

            // Key logic: if the first element is 1, then the permutation can always be sorted
            // This is because no restriction prevents correct swaps from happening
            if (a[0] == 1) {
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

- The allowed swap operation only lets you swap when a[i-1] < a[i] > a[i+1] and i in [2, n-1].
- This seems restrictive, but there's a critical observation:
- If the **first element is 1**, then that '1' can be "pushed forward" through the permutation toward its correct place.
- This eventually enables all elements to bubble into place (like in bubble sort with specific conditions).
- But if the first element is not 1, then there's no way to bring '1' to the start, which breaks the ability to sort the array.
- Therefore, the final rule is:
  → If `a[0] == 1`, print "YES"
  → Otherwise, print "NO"

--------------------------------------------
USAGE OF DATA STRUCTURES:
--------------------------------------------

1. Array `a[]`:
   - Purpose: To store the permutation of integers for each test case.
   - Initialization:
     ```java
     int[] a = new int[n];
     ```
   - Functions used:
     - `a[i] = sc.nextInt();` → input reading
     - `a[0] == 1` → key condition for final answer

2. Scanner `sc`:
   - Purpose: Efficient input reading from standard input.
   - Initialization:
     ```java
     Scanner sc = new Scanner(System.in);
     ```
   - Functions used:
     - `sc.nextInt()` → reading integers

--------------------------------------------
TIME COMPLEXITY AND PERFORMANCE ANALYSIS
--------------------------------------------

PER TEST CASE:
- Input reading: O(n)
- Logic: O(1) — only checks if `a[0] == 1`

TOTAL:
- Worst case input: t = 5000 and n = 10 → 5000 * 10 = 50,000 operations
- All operations are simple and within allowed limits

✅ Confirmed efficient under standard competitive programming limits.

COMPETITIVE LIMITS:
- 1 sec → 10^8 ops allowed
- Our code: ~5 * 10^4 ops in worst case

--------------------------------------------
SPACE COMPLEXITY
--------------------------------------------

- O(n) for the array `a[]` in each test case
- O(1) for logic and condition check (no auxiliary structures used)

--------------------------------------------
SUMMARY
--------------------------------------------

- We only need to check whether the first element is `1`.
- If so, it is always possible to sort the permutation due to the way swap operations work.
- The logic is constant time per test case and highly optimized.
- Only simple data structures used — an array and standard Scanner.
- Cleanly handles all edge cases due to the nature of the constraint (n ≥ 3, all distinct from 1 to n).
