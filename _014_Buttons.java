/*
--------------------------------------------
Problem: #14 - Buttons
Problem Link  : https://codeforces.com/problemset/problem/1858/A

Problem Statement Summary:
Anna and Katie are in a lab with a + b + c buttons.
- a buttons only Anna can press.
- b buttons only Katie can press.
- c buttons either can press.

They play a game, taking turns pressing any remaining unpressed button.
Anna goes first.
A button can be pressed only once.
The girl who can't press a button on her turn loses.

Determine the winner if both play optimally.

Input Format:
- The first line contains a single integer t (1 ≤ t ≤ 10⁴)
- Each test case contains three integers a, b, and c (1 ≤ a, b, c ≤ 10⁹)

Output Format:
- For each test case, output "First" if Anna wins.
- Otherwise, output "Second".

Example:
Input:
5
1 1 1
9 3 3
1 2 3
6 6 9
2 2 8

Output:
First
First
Second
First
Second
*/

import java.util.*;

public class _014_Buttons {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in); // Scanner to read input
        int t = sc.nextInt(); // Read number of test cases

        while (t-- > 0) {
            int a = sc.nextInt(); // Number of buttons only Anna can press
            int b = sc.nextInt(); // Number of buttons only Katie can press
            int c = sc.nextInt(); // Number of common buttons

            // Case 1: If Anna has more exclusive buttons, she wins
            if (a > b) {
                System.out.println("First");
            }
            // Case 2: If Katie has more exclusive buttons, she wins
            else if (a < b) {
                System.out.println("Second");
            }
            // Case 3: Equal exclusive buttons, winner depends on parity of common buttons
            else {
                // If c is odd → Anna gets one extra turn → she wins
                if (c % 2 == 1) {
                    System.out.println("First");
                } else {
                    System.out.println("Second");
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

- Anna and Katie alternate pressing buttons. Anna always goes first.
- There are 3 categories:
   1. Buttons *only* Anna can press (a)
   2. Buttons *only* Katie can press (b)
   3. Buttons *either* can press (c)

- The goal is to determine who will be **unable to move** first — she loses.

- If `a > b` → Anna has more personal buttons, so she’ll last longer → she wins.

- If `b > a` → Katie has more personal buttons → she wins.

- If `a == b`:
   - Then common buttons (c) are evenly split.
   - But since Anna starts first, if `c` is **odd**, she gets **1 more turn**.
   - So:
     - If c is odd → Anna wins
     - If c is even → Katie wins

--------------------------------------------
USAGE OF DATA STRUCTURES:
--------------------------------------------

1. Scanner:
   - Purpose: Fast input reading for competitive problems
   - Initialization:
     ```java
     Scanner sc = new Scanner(System.in);
     ```
   - Functions used:
     - `sc.nextInt()` → Reads integers from input

No additional data structures were needed due to the simplicity of the problem.

--------------------------------------------
TIME COMPLEXITY AND PERFORMANCE ANALYSIS
--------------------------------------------

PER TEST CASE:
- Input reading: O(1)
- Decision logic: O(1)

TOTAL for t test cases:
- O(t) → where t ≤ 10⁴

✅ Confirmed efficient under standard competitive programming limits.

COMPETITIVE LIMITS:
- 1 sec → ~10⁸ operations allowed
- Our code: Only ~10⁴ comparisons and outputs → completely safe

--------------------------------------------
SPACE COMPLEXITY
--------------------------------------------

- O(1) extra space per test case
- O(1) total as no arrays or collections are used

--------------------------------------------
SUMMARY
--------------------------------------------

- Checks who has more exclusive buttons.
- If same, uses parity of common buttons to decide winner.
- Only basic control flow and math used.
- Scanner used for input, no other data structures.
- Handles all edge cases: large values, ties, parity logic.
*/
