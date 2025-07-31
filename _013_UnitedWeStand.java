/*
--------------------------------------------
Problem: #13 - United We Stand
Problem Link  : https://codeforces.com/problemset/problem/1859/A

Problem Statement Summary:
Given an array 𝑎 of length 𝑛, containing integers. And there are two initially empty arrays 𝑏 and 𝑐. 
You need to add each element of array 𝑎 to exactly one of the arrays 𝑏 or 𝑐, in order to satisfy the following conditions:
- Both arrays 𝑏 and 𝑐 are non-empty.
- For any two indices 𝑖 and 𝑗 (1≤𝑖≤𝑙𝑏,1≤𝑗≤𝑙𝑐), 𝑐𝑗 is not a divisor of 𝑏𝑖.

Input Format:
- The first line contains a single integer 𝑡 (1≤𝑡≤500) — the number of test cases.
- The first line of each test case contains a single integer 𝑛 (2≤𝑛≤100) — the length of array 𝑎.
- The second line of each test case contains 𝑛 integers 𝑎1,𝑎2,…,𝑎𝑛 (1≤𝑎𝑖≤10^9) — the elements of array 𝑎.

Output Format:
- For each test case, output a single integer −1 if a solution does not exist.
- Otherwise, in the first line, output two integers 𝑙𝑏 and 𝑙𝑐 — the lengths of arrays 𝑏 and 𝑐 respectively.
- In the second line, output 𝑙𝑏 integers 𝑏1,𝑏2,…,𝑏𝑙𝑏 — the elements of array 𝑏.
- In the third line, output 𝑙𝑐 integers 𝑐1,𝑐2,…,𝑐𝑙𝑐 — the elements of array 𝑐.

Example:
Input:
5
3
2 2 2
5
1 2 3 4 5
3
1 3 5
7
1 7 7 2 9 1 4
5
4 8 12 12 4

Output:
-1
3 2
1 3 5 
2 4 
1 2
1 
3 5 
2 5
1 1 
2 4 7 7 9 
3 2
4 8 4 
12 12 
*/

import java.util.*;

public class _013_UnitedWeStand {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in); // Scanner to read input
        int t = sc.nextInt(); // Read number of test cases
        while(t-- > 0){
            int n = sc.nextInt(); // Read size of array a
            int[] a = new int[n]; // Array to store input
            int[] b = new int[n]; // Array b: will store elements not equal to max
            int bIndex = 0;       // Index to insert elements in array b
            int[] c = new int[n]; // Array c: will store all occurrences of max element
            int cIndex = 0;       // Index to insert elements in array c
            int max = Integer.MIN_VALUE; // Track maximum element in array

            // Read array a and simultaneously find the maximum element
            for(int i = 0; i < n; i++){
                a[i] = sc.nextInt();
                if(a[i] > max){
                    max = a[i];
                }
            }

            // Separate elements into b and c based on whether they are equal to max
            for(int i = 0; i < n; i++){
                if(a[i] == max){
                    c[cIndex] = a[i];
                    cIndex++;
                } else {
                    b[bIndex] = a[i];
                    bIndex++;
                }
            }

            // If all elements are equal (i.e., all elements are in c), print -1
            if(a.length == cIndex){
                System.out.print(-1);
            } else {
                // Print lengths of b and c
                System.out.println(bIndex + " " + cIndex);
                
                // Print elements of b
                for(int i = 0; i < bIndex; i++ ){
                    System.out.print(b[i] + " ");
                }
                System.out.println();
                
                // Print elements of c
                for(int i = 0; i < cIndex; i++ ){
                    System.out.print(c[i] + " ");
                }
            }
            System.out.println(); // Newline after each test case
        }
    }
}


/*
--------------------------------------------
DETAILED EXPLANATION OF LOGIC AND ANALYSIS
--------------------------------------------

APPROACH (Very Easy to Understand):

- The array is split into two arrays b and c.
- The key idea is to put the maximum value(s) in array c.
- All other smaller elements go into array b.
- This ensures the condition is satisfied: no element in c can divide any element in b.
- Why? Because all elements in b are strictly less than the maximum (elements in c),
  so no max can divide any smaller number.
- Special Case: If all elements are equal, then c will contain all elements and b will be empty.
  In this case, output -1 since both arrays must be non-empty.

--------------------------------------------
USAGE OF DATA STRUCTURES:
--------------------------------------------

1. int[] a
   - Purpose: To store the input array
   - Initialization:
     ```java
     int[] a = new int[n];
     ```
   - Functions used:
     - Reading inputs and storing values

2. int[] b
   - Purpose: To store all elements not equal to the maximum
   - Initialization:
     ```java
     int[] b = new int[n];
     ```
   - Functions used:
     - Manual insertion using `bIndex` pointer

3. int[] c
   - Purpose: To store all occurrences of the maximum element
   - Initialization:
     ```java
     int[] c = new int[n];
     ```
   - Functions used:
     - Manual insertion using `cIndex` pointer

4. Scanner sc
   - Purpose: For fast input reading
   - Initialization:
     ```java
     Scanner sc = new Scanner(System.in);
     ```

--------------------------------------------
TIME COMPLEXITY AND PERFORMANCE ANALYSIS
--------------------------------------------

PER TEST CASE:
- Input reading: O(n)
- Finding max and splitting into arrays: O(n)
- Printing result: O(n)

TOTAL:
- O(n) per test case
- In worst case (t = 500, n = 100): 500 * 100 = 50,000 operations

Confirmed efficient under standard competitive programming limits.

COMPETITIVE LIMITS:
- 1 sec → 10^8 operations allowed
- Our code: ≈ 5 * 10^4 ops → Well within limits

--------------------------------------------
SPACE COMPLEXITY
--------------------------------------------

- O(n) for input array `a`
- O(n) for arrays `b` and `c`
- Total: O(3n) → O(n)

--------------------------------------------
SUMMARY
--------------------------------------------

- The solution correctly partitions the array by separating the maximum element(s).
- Ensures both arrays are non-empty.
- Satisfies the divisor condition using a safe max-based strategy.
- Uses simple arrays and linear time logic.
- Handles edge cases like all elements being the same (returns -1).
*/
