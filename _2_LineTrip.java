/*
--------------------------------------------
Problem: #2 - Line Trip
Problem Link : https://codeforces.com/problemset/problem/1901/A

Problem Statement Summary:
You're located at point 0 and need to travel to point x and return to 0 using a car that consumes 
1 liter of fuel per unit of distance. The car starts with a full tank, and there are n gas stations 
between 0 and x at positions a1, a2, ..., an. You can only refuel at gas stations (not at 0 or x). 
At each gas station, the tank is refilled to full capacity.

Your task is to determine the minimum possible tank capacity (in liters) that would allow the car 
to complete the entire round trip (0 → x → 0) without ever running out of fuel.

Input Format:
- The first line contains a single integer t (1 ≤ t ≤ 1000): number of test cases.
- Each test case consists of:
  - Two integers n and x (1 ≤ n ≤ 50; 2 ≤ x ≤ 100)
  - A second line of n integers a1, a2, ..., an (0 < a1 < a2 < ... < an < x)

Output Format:
- For each test case, print a single integer: the minimum required tank capacity.

Example:
Input:
3
3 7
1 2 5
3 6
1 2 5
1 10
7

Output:
4
3
7
*/

import java.util.*;
import java.lang.*;
import java.io.*;

public class _2_LineTrip {
    public static void main(String args[]) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); // Number of test cases

        while (t-- > 0) {
            int n = sc.nextInt(); // Number of gas stations
            int x = sc.nextInt(); // Destination point x
            int a[] = new int[n]; // Array to store gas station positions

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt(); // Reading positions of gas stations
            }

            int maxDist = a[0]; // Distance from start (0) to first station

            for (int i = 1; i < n; i++) {
                // Calculate distance between each pair of consecutive stations
                maxDist = Math.max(maxDist, a[i] - a[i - 1]);
            }

            // Consider the final leg: from last station to x and back (2 * one-way distance)
            maxDist = Math.max(maxDist, 2 * (x - a[n - 1]));

            System.out.println(maxDist); // Output minimum tank capacity required
        }
    }
}

/*
--------------------------------------------
DETAILED EXPLANATION OF LOGIC AND ANALYSIS
--------------------------------------------

APPROACH:
- The car starts with a full tank at point 0.
- It can only refuel at given stations. We must ensure the car never travels more than the tank can hold.
- So we find the **maximum gap** between any two refueling opportunities:
   1. From 0 to first gas station: a[0]
   2. Between all consecutive stations: a[i] - a[i-1]
   3. From last gas station to x and then back (since x has no station): 2 * (x - a[n-1])
- The largest of these three gaps determines the **minimum tank size required**.

USAGE OF FUNCTION:
- `Math.max(a, b)`:
   - Returns the greater of two values `a` and `b`.
   - Used to continuously track the largest distance between two refueling stops.

EXAMPLE ANALYSIS:
Test Case 1:
- n = 3, x = 7, a = [1, 2, 5]
- Gaps: 0→1 = 1, 1→2 = 1, 2→5 = 3, last gap to x and back = 2*(7-5) = 4
- max = 4 → Output: 4

Test Case 3:
- a = [7], x = 10
- Gaps: 0→7 = 7, 2*(10 - 7) = 6 → max = 7

--------------------------------------------
TIME COMPLEXITY AND PERFORMANCE ANALYSIS
--------------------------------------------

PER TEST CASE:
- Reading n elements: O(n)
- Loop to compute max gap: O(n)
- Math.max is constant time → O(1) per call

OVERALL:
- For t test cases: O(t × n)
- Constraints: t ≤ 1000, n ≤ 50 → total work is at most 50,000 operations → highly efficient

COMPETITIVE LIMITS:
- With 1 second time limit and 10^8 operations/second:
  Maximum allowable work ≈ 100 million operations
- Our code does at most 5 × 10^4 operations → comfortably within time limits

SPACE COMPLEXITY:
- O(n) space per test case to store the array `a`
- No additional data structures used → very low memory usage

--------------------------------------------
SUMMARY
--------------------------------------------
- Problem reduces to finding the largest gap between fuel stops.
- Key edge: x has no station → requires round-trip from last station.
- Final tank capacity = maximum of:
    a[0], a[i] - a[i-1], 2*(x - a[n-1])
- Simple, clean, and optimal O(n) solution per test case
- Uses `Math.max()` for continuous tracking of maximum segment
- Easily meets time and memory constraints for competitive programming
*/
