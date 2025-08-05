/*
--------------------------------------------
Problem: #16 - Desorting
Problem Link  : https://codeforces.com/problemset/problem/1853/A

Problem Statement Summary:
Call an array a of length n sorted if a₁ ≤ a₂ ≤ … ≤ aₙ.
Ntarsis has an array a of length n.

He is allowed to perform one type of operation on it (zero or more times):
- Choose an index i (1 ≤ i ≤ n−1).
- Add 1 to a₁, a₂, …, aᵢ.
- Subtract 1 from aᵢ₊₁, aᵢ₊₂, …, aₙ.

The values of a can be negative after an operation.

Determine the minimum number of operations needed to make a not sorted.

Input Format:
- The first line contains the number of test cases t 
  (1 ≤ t ≤ 100).
- The description of the test cases follows.
- The first line of each test case contains a single 
  integer n (2 ≤ n ≤ 500).
- The next line contains n integers a₁, a₂, …, aₙ 
  (1 ≤ aᵢ ≤ 10⁹).
- It is guaranteed that the sum of n across all 
  test cases does not exceed 500.

Output Format:
- Output the minimum number of operations needed 
  to make the array not sorted.
- Output each answer on a new line.
 
Example:
Input:
4
2
1 1
4
1 8 10 13
3
1 3 2
3
1 9 14

Output:
1
2
0
3
*/

import java.io.*;
import java.util.*;

public class _016_Desorting {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // Fast input reader
        int t = Integer.parseInt(br.readLine()); // Read number of test cases

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine()); // Read size of array
            int[] a = new int[n]; // Array to store elements

            StringTokenizer st = new StringTokenizer(br.readLine()); // Read array elements
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken()); // Fill array
            }

            boolean isSorted = true; // Flag to check if array is sorted
            int minDiff = Integer.MAX_VALUE; // Minimum adjacent difference

            for (int i = 1; i < n; i++) {
                // Check if already unsorted
                if (a[i - 1] > a[i]) {
                    isSorted = false; // No operation needed
                    break;
                } else {
                    // Update minimum adjacent difference
                    minDiff = Math.min(minDiff, a[i] - a[i - 1]);
                }
            }

            // Output result based on sortedness
            System.out.println(isSorted ? (minDiff / 2) + 1 : 0);
        }
    }
}

/*
--------------------------------------------
DETAILED EXPLANATION OF LOGIC AND ANALYSIS
--------------------------------------------

APPROACH (Very Easy to Understand):

1. First, check whether the given array is already not sorted.
   - If any a[i-1] > a[i], it's already not sorted → answer is 0.

2. If the array is sorted:
   - Then compute the minimum adjacent difference between consecutive elements.
   - This value controls how easily we can break the sorted order using the given operation.
   - The operation increases the left segment and decreases the right segment.
   - So to disturb a pair (a[i-1], a[i]), the difference must shrink and flip order.
   - Formula: Minimum operations = (minDiff / 2) + 1

3. Final output is either 0 (already unsorted) or calculated using the formula above.

--------------------------------------------
USAGE OF DATA STRUCTURES:
--------------------------------------------

1. int[] a:
   - Purpose: To store the array input for each test case
   - Initialization:
     ```java
     int[] a = new int[n];
     ```
   - Functions used:
     - `a[i] = Integer.parseInt(token);` → Read and store input
     - `a[i-1] > a[i]` → Check if sorted
     - `a[i] - a[i-1]` → Compute adjacent difference

2. boolean isSorted:
   - Purpose: Track whether the array is sorted
   - Initialization:
     ```java
     boolean isSorted = true;
     ```
   - Functions used:
     - Set to false on first occurrence of a[i-1] > a[i]

3. int minDiff:
   - Purpose: Keep track of the smallest adjacent difference
   - Initialization:
     ```java
     int minDiff = Integer.MAX_VALUE;
     ```
   - Functions used:
     - `minDiff = Math.min(minDiff, a[i] - a[i-1]);`

--------------------------------------------
TIME COMPLEXITY AND PERFORMANCE ANALYSIS
--------------------------------------------

PER TEST CASE:
- Input reading: O(n)
- Logic to check sorted and find min difference: O(n)

TOTAL:
- Total complexity = O(Σn) where Σn ≤ 500
- So worst-case operations = 500 (very small)

✅ Confirmed efficient under standard competitive programming limits.

COMPETITIVE LIMITS:
- 1 sec → ~10^8 operations allowed
- Our code: ≤ 500 operations in total → Extremely fast

--------------------------------------------
SPACE COMPLEXITY
--------------------------------------------

- O(n) for array input
- O(1) extra for variables (`minDiff`, `isSorted`, etc)

--------------------------------------------
SUMMARY
--------------------------------------------

- The solution first checks whether the array is already unsorted.
- If not, it finds the minimum adjacent difference in the sorted array.
- Uses formula (minDiff / 2) + 1 to compute the fewest operations needed to break the order.
- Efficient and clean logic using only arrays and basic control flow.
- Correctly handles all edge cases and stays within competitive limits.
- Uses BufferedReader and StringTokenizer to avoid memory issues.
*/
