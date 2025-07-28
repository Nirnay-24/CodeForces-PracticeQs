/*
--------------------------------------------
Problem: #1 - Halloumi Boxes
Problem Link : https://codeforces.com/problemset/problem/1903/A

Problem Statement Summary:
Theofanis needs to sort an array of `n` box labels using a peculiar machine. This machine can reverse 
any subarray of length at most `k`. Given multiple test cases, determine for each if it's possible 
to sort the array in non-decreasing order using any number of such subarray reversals.

Input Format:
- t test cases (1 ≤ t ≤ 100)
- For each test case:
  - Two integers n and k (1 ≤ k ≤ n ≤ 100)
  - Array of n integers a[i] (1 ≤ a[i] ≤ 10^9)

Output Format:
- Print "Yes" if it's possible to sort the array using allowed reversals, otherwise "No".
- Output is case-insensitive.
*/

import java.util.*;
import java.util.Arrays; // Included in java.util.* (not needed separately)
import java.lang.*;      // Built-in package (not needed explicitly)
import java.io.*;        // Not used here (advanced I/O classes)

public class _001_HalloumiBoxes {
    public static void main(String args[]) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); // Number of test cases

        while (t-- > 0) { 
            int n = sc.nextInt(); // Number of boxes
            int k = sc.nextInt(); // Maximum allowed length of subarray to reverse

            int a[] = new int[n]; // Original array of box labels
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt(); // Read array elements
            }

            int copy[] = a.clone(); // Clone array to preserve original order
            Arrays.sort(copy);      // Sort cloned array for comparison

            if (Arrays.equals(copy, a)) {
                // Already sorted → no operation needed
                System.out.println("Yes");
            } else {
                if (k <= 1) {
                    // Cannot sort array with only 1-length reversals
                    System.out.println("No");
                } else {
                    // If k ≥ 2, any sequence can eventually be sorted
                    System.out.println("Yes");
                }
            }
        }
    }
}

/*
--------------------------------------------
DETAILED EXPLANATION OF LOGIC AND ANALYSIS
--------------------------------------------

PROBLEM INTERPRETATION:
- The machine can reverse any subarray of length ≤ k.
- Need to determine if the array can be sorted using any number of such operations.

KEY LOGIC:
- If the array is already sorted → Output "Yes"
- If k == 1:
  - Only individual elements can be reversed → No effective change → Output "No"
- If k ≥ 2:
  - We can simulate any swap through overlapping subarray reversals.
  - Eventually, we can sort the array fully → Output "Yes"

WHY THIS WORKS:
- k ≥ 2 is sufficient to emulate arbitrary swaps and permutations via reversals.
- Reversals can overlap and chain to sort any part of the array over time.

EDGE CASES:
- k = 1 → nothing changes → check if already sorted
- k = n → whole array can be reversed → fully sortable

EXAMPLES:
- [1, 2, 3], k = 2 → already sorted → "Yes"
- [3, 1], k = 1 → cannot be sorted → "No"
- [3, 1], k = 2 → reverse entire → becomes [1, 3] → "Yes"

--------------------------------------------
TIME COMPLEXITY AND PERFORMANCE ANALYSIS
--------------------------------------------

PER TEST CASE:
- Cloning array: O(n)
- Sorting array: O(n log n)
- Comparing arrays: O(n)

OVERALL:
- For t test cases → Total Time: O(t × n log n)
- Given constraints (t ≤ 100, n ≤ 100), this is very efficient

--------------------------------------------
SUMMARY
--------------------------------------------
- This problem reduces to two cases:
  - If array is already sorted → "Yes"
  - If not sorted:
    - k = 1 → "No"
    - k ≥ 2 → "Yes"
- Uses array cloning, sorting, and comparison
- Time-efficient for all valid constraints
*/
