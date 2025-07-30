/*
--------------------------------------------
Problem: #11 - A. Ambitious Kid
Problem Link  : https://codeforces.com/problemset/problem/1866/A

Problem Statement Summary:
Given an array of integers A1, A2, ..., AN.
In one operation, Chaneka can increase or decrease an element by 1.
What is the minimum number of operations to make A1 × A2 × ... × AN = 0?

Input Format:
The first line contains a single integer N (1 ≤ N ≤ 10^5).
The second line contains N integers A1, A2, ..., AN (−10^5 ≤ Ai ≤ 10^5).

Output Format:
Output a single integer — the minimum number of operations needed.

Example:
Input:
3
2 -6 5

Output:
2

Input:
1
-3

Output:
3

Input:
5
0 -1 0 1 0

Output:
0
*/

import java.util.*;

public class _011_AmbitiousKid {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in); // Scanner to read input
        int n = sc.nextInt(); // Read number of elements
        int[] a = new int[n]; // Declare array to hold input
        int smallestValue = Integer.MAX_VALUE; // Initialize with max value to find min abs

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt(); // Read each element

            // If any element is zero, answer is 0 and no need to continue
            if (a[i] == 0) {
                smallestValue = 0;
                break;
            }

            // Update smallestValue if current abs value is smaller
            if (Math.abs(a[i]) < smallestValue) {
                smallestValue = Math.abs(a[i]); // Take absolute value
            }
        }

        // Output the minimum number of operations required to make product zero
        System.out.println(smallestValue);
    }
}

/*
--------------------------------------------
DETAILED EXPLANATION OF LOGIC AND ANALYSIS
--------------------------------------------

APPROACH (Very Easy to Understand):

- To make the product of all elements zero, at least one element must be 0.
- If any element is already zero, then product is already zero. So answer is 0.
- If there is no zero, the smallest effort is to convert the number with the smallest absolute value to 0.
- This is because changing a number like 1 or -1 to 0 takes only 1 operation.
- Hence, find the element with the minimum absolute value and return that.

--------------------------------------------
USAGE OF DATA STRUCTURES:
--------------------------------------------

1. int[] array:
   - Purpose: To store the N integers given in the input.
   - Initialization:
     ```java
     int[] a = new int[n];
     ```
   - Functions used:
     - a[i] = sc.nextInt(); → to store each input number

2. Primitive int variable `smallestValue`:
   - Purpose: To track the minimum number of operations required.
   - Initialization:
     ```java
     int smallestValue = Integer.MAX_VALUE;
     ```
   - Functions used:
     - Math.abs(a[i]) → to get absolute value of element
     - Comparison and update logic

--------------------------------------------
TIME COMPLEXITY AND PERFORMANCE ANALYSIS
--------------------------------------------

PER TEST CASE:
- Input reading: O(n)
- Logic (finding min absolute): O(n)

TOTAL:
- Overall complexity: O(n)
- In worst case (n = 10^5), at most 10^5 operations performed.

✅ Confirmed efficient under standard competitive programming limits.

COMPETITIVE LIMITS:
- 1 sec → 10^8 ops allowed
- Our code: ~10^5 operations max

--------------------------------------------
SPACE COMPLEXITY
--------------------------------------------

- O(n) for input array `a`
- O(1) extra space for variables

--------------------------------------------
SUMMARY
--------------------------------------------

- Checked if any element is already zero → return 0 immediately.
- Otherwise, return the minimum absolute value among all elements.
- Used array to store values and a single pass to compute the answer.
- Efficient under all constraints and handles edge cases cleanly.
*/
