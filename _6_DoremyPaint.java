/*
--------------------------------------------
Problem: #6 - Doremy's Paint 3
Problem Link  : https://codeforces.com/problemset/problem/1890/A

Problem Statement Summary:
An array b of length n is called good if the sum of every two adjacent elements is the same.
Given an array a, determine if any permutation of a can be a good array.
This must be done for t test cases.
Each test case provides an array of length n. The goal is to print "Yes" if the array can be permuted into a good array, otherwise "No".
A good array has all adjacent sums equal, i.e., b1+b2 = b2+b3 = ... = bn−1+bn.

Input Format:
- First line: t — number of test cases
- For each test case:
    - First line: n — number of elements
    - Second line: n integers a[i]

Output Format:
- For each test case, output "Yes" if a permutation of a is good, otherwise output "No"

Example:
Input:
3
2
1 1
4
1 2 1 2
5
1 2 3 4 5

Output:
Yes
Yes
No
*/

import java.util.*;

public class _6_DoremyPaint {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); // number of test cases
        while (t-- > 0) {
            int n = sc.nextInt(); // size of the array
            int[] a = new int[n];
            Set<Integer> distinct = new HashSet<>(); // stores unique elements
            Map<Integer, Integer> frequency = new HashMap<>(); // stores frequency of each element

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt(); // input element
                distinct.add(a[i]); // add to set
                frequency.put(a[i], frequency.getOrDefault(a[i], 0) + 1); // update frequency
            }

            if (distinct.size() == 1) {
                // all elements are same → good array
                System.out.println("Yes");
            } else if (distinct.size() == 2) {
                // two unique elements → check their frequencies
                Iterator<Integer> it = distinct.iterator();
                int first = it.next();
                int second = it.next();
                int f1 = frequency.get(first);
                int f2 = frequency.get(second);

                if (f1 == f2 || Math.abs(f1 - f2) == 1) {
                    // frequencies equal or differ by 1 → valid alternating pattern
                    System.out.println("Yes");
                } else {
                    // invalid frequency difference
                    System.out.println("No");
                }
            } else {
                // more than 2 unique elements → cannot form alternating pattern
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

We want to check if the array can be rearranged into a "good" alternating pattern.

Observation:
The equation b1 + b2 = b2 + b3 simplifies to b1 = b3, b2 = b4, etc.
→ This means the array must alternate: x, y, x, y, ...

So:
- If there's only 1 unique element → valid (all values same)
- If there are exactly 2 unique elements:
  - Frequencies must be equal (e.g., [1,2,1,2])
  - Or differ by just 1 (e.g., [2,1,2])
- If more than 2 elements → cannot satisfy alternating pattern

Hence, we use:
- A Set to track distinct elements
- A Map to count frequencies
Then we apply the above logic.

--------------------------------------------
USAGE OF DATA STRUCTURES:
--------------------------------------------

1. HashSet:
   - Purpose: Track all unique elements in array
   - Initialization:
     ```java
     Set<Integer> distinct = new HashSet<>();
     ```
   - Functions used:
     - `add(x)` → Adds element to set if not already present
     - `size()` → Returns number of unique elements
     - `iterator()` → Retrieves iterator to loop through values

2. HashMap:
   - Purpose: Store frequency of each element
   - Initialization:
     ```java
     Map<Integer, Integer> frequency = new HashMap<>();
     ```
   - Functions used:
     - `put(key, value)` → Assigns frequency to key
     - `get(key)` → Returns frequency of a key
     - `getOrDefault(key, default)` → Returns existing frequency, else assigns default (used in frequency count logic)

--------------------------------------------
TIME COMPLEXITY AND PERFORMANCE ANALYSIS
--------------------------------------------

PER TEST CASE:
- Input reading: O(n)
- HashSet/HashMap updates: O(n)
- Decision logic: O(1)

TOTAL:
- O(t × n) where t ≤ 100 and n ≤ 100 → Max operations = 10^4

Efficient under standard competitive programming limits.

--------------------------------------------
SPACE COMPLEXITY
--------------------------------------------

- O(n) for storing the array
- O(k) for storing frequencies and distinct elements (k = unique elements ≤ 100)

--------------------------------------------
SUMMARY
--------------------------------------------

- We check if a permutation of array forms an alternating sequence
- This requires at most 2 distinct elements with balanced frequency
- HashSet helps count distinct values
- HashMap helps track their frequencies
- Handles all edge cases cleanly
