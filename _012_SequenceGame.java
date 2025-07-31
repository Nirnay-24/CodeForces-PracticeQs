/*
--------------------------------------------
Problem: #12 - Sequence Game
Problem Link  : https://codeforces.com/problemset/problem/1862/B

Problem Statement Summary:
Tema and Vika are playing a game. Vika writes a sequence a of positive integers and transforms it to sequence b as follows:
- First element of b is a1.
- Then she adds ai to b if ai−1 ≤ ai (for 2 ≤ i ≤ m).
Given b, construct any valid sequence a (length m such that n ≤ m ≤ 2n) which could result in b.

Input Format:
- The first line contains a single integer t (1 ≤ t ≤ 10^4) — number of test cases.
- Each test case:
    - The first line contains a single integer n (1 ≤ n ≤ 2⋅10^5) — the length of the sequence b.
    - The second line contains n integers b1, b2, ..., bn (1 ≤ bi ≤ 10^9).

Output Format:
- For each test case, print two lines:
    - The first line contains a single integer m (n ≤ m ≤ 2⋅n) — the length of a.
    - The second line contains m integers a1, a2, ..., am — the assumed original sequence.

Example:
Input:
6
3
4 6 3
3
1 2 3
5
1 7 9 5 7
1
144
2
1 1
5
1 2 2 1 1

Output:
6
4 6 3 3
3
1 2 3
6
1 7 9 5 5 7
1
144
2
1 1
6
1 2 2 1 1 1
*/

import java.util.*;

public class _012_SequenceGame {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in); // Scanner to read input
        int t = sc.nextInt(); // Number of test cases
        
        while(t-- > 0){
            int n = sc.nextInt(); // Read size of b[]
            int[] b = new int[n]; // Array to store b[]
            int[] a = new int[2 * n]; // Array a[] (max possible size is 2n)
            int j = 0; // Pointer to build a[]
            
            for(int i = 0; i < n; i++){
                b[i] = sc.nextInt(); // Read b[i]
                
                if(i == 0){
                    a[j++] = b[i]; // Always include first element
                    continue;
                }

                if(b[i] >= b[i - 1]){
                    a[j++] = b[i]; // If current is >= previous, include once
                } else {
                    a[j++] = b[i]; // Else, include it twice to allow a drop
                    a[j++] = b[i];
                }
            }
            
            System.out.println(j); // Length of generated a[]
            for(int i = 0; i < j; i++){
                System.out.print(a[i] + " "); // Print elements of a[]
            }
            System.out.println();
        }
    }
}

/*
--------------------------------------------
DETAILED EXPLANATION OF LOGIC AND ANALYSIS
--------------------------------------------

APPROACH (Very Easy to Understand):

- Vika creates sequence b[] from a[] such that:
    - First element a[0] is always kept in b[]
    - From a[1] to a[m-1], element is added to b[] if it's >= previous a[i-1]

- Given b[], the goal is to reconstruct a possible a[] that could've created b[].

- The idea is:
    - Start with b[0] → always add it to a[]
    - For i from 1 to n-1:
        - If b[i] >= b[i-1], add b[i] once to a[]
        - If b[i] < b[i-1], then add b[i] **twice** to a[]
            - Why twice? Because that way, the first one can be skipped (as b[i] < prev), and the second one can be kept (as b[i] ≥ prev)

- This guarantees that when a[] is processed using the same transformation logic, we will get exactly b[].

--------------------------------------------
USAGE OF DATA STRUCTURES:
--------------------------------------------

1. Array `int[] b`
   - Purpose: Store input sequence b[]
   - Initialization:
     ```java
     int[] b = new int[n];
     ```
   - Functions used:
     - `sc.nextInt()` to read input values into it

2. Array `int[] a`
   - Purpose: Build the original sequence a[]
   - Initialization:
     ```java
     int[] a = new int[2 * n];
     ```
     Because in worst case every element of b[] may be added twice
   - Functions used:
     - Standard array assignment to build and print the result

--------------------------------------------
TIME COMPLEXITY AND PERFORMANCE ANALYSIS
--------------------------------------------

PER TEST CASE:
- Input reading: O(n)
- Logic building a[]: O(n)
- Output printing: O(n)

TOTAL:
- O(n) per test case
- Since sum of all n across test cases ≤ 2*10^5, total operations = O(2*10^5) = ✅ Acceptable

✅ Confirmed efficient under standard competitive programming limits.

COMPETITIVE LIMITS:
- 1 second → ~10^8 operations allowed
- Our code: At most ~2*10^5 operations → ✅ well within limit

--------------------------------------------
SPACE COMPLEXITY
--------------------------------------------

- O(n) for storing b[]
- O(2n) for a[]
- Total: O(n) auxiliary space per test case

--------------------------------------------
SUMMARY
--------------------------------------------

- The key idea is to duplicate b[i] when there's a drop (b[i] < b[i−1])
- This guarantees enough elements in a[] to skip one and keep one to match transformation logic
- Arrays are used for simplicity and efficiency
- Handles all edge cases including strictly increasing, constant, and decreasing sequences
*/
