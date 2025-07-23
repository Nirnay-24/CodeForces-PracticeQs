/*
--------------------------------------------
Problem: #4 - Game with Integers
Problem Link  : https://codeforces.com/problemset/problem/1899/A

Problem Statement Summary:
Vanya and Vova are playing a game. Players are given an integer n. 
On their turn, the player can add 1 to the current integer or subtract 1. 
The players take turns; Vanya starts. If after Vanya's move the integer is divisible by 3, then he wins. 
If 10 moves have passed and Vanya has not won, then Vova wins.

Input Format:
- The first line contains the integer t (1≤t≤100) — the number of test cases.
- The single line of each test case contains the integer n (1≤n≤1000).

Output Format:
- For each test case, print "First" without quotes if Vanya wins, and "Second" without quotes if Vova wins.

Example:
Input:
6
1
3
5
100
999
1000

Output:
First
Second
First
First
Second
First
*/

import java.util.*;

public class _4_GameWithIntegers {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in); // Scanner to read input
        int t = sc.nextInt(); // Number of test cases
        while (t-- > 0) {
            int n = sc.nextInt(); // Read the integer n for each test case
            if (n % 3 == 0) {
                // If n is divisible by 3, then Vanya cannot make it divisible after his move
                System.out.println("Second");
            } else {
                // If n is not divisible by 3, Vanya can make it divisible by adding or subtracting 1
                System.out.println("First");
            }
        }
    }
}

/*
--------------------------------------------
DETAILED EXPLANATION OF LOGIC AND ANALYSIS
--------------------------------------------

APPROACH (Very Easy to Understand):

- Vanya starts first and can either add or subtract 1 from the number `n`.
- He wants the number to become divisible by 3 **after** his move to win.
- So we must check: can Vanya make `n ± 1` divisible by 3?
- This is only possible if `n % 3 != 0`:
   → If `n % 3 == 1` → `n - 1` is divisible by 3
   → If `n % 3 == 2` → `n + 1` is divisible by 3
- But if `n % 3 == 0`, Vanya cannot win in 1st move, and since both play optimally, Vova will delay the win indefinitely within 10 moves.
- So we print:
   → "First" if `n % 3 != 0`
   → "Second" if `n % 3 == 0`

--------------------------------------------
USAGE OF DATA STRUCTURES:
--------------------------------------------

1. Scanner:
   - Purpose: To read input from standard input
   - Initialization:
     ```java
     Scanner sc = new Scanner(System.in);
     ```
   - Functions used:
     - `sc.nextInt()` → Reads the next integer from input

No other data structures are used as logic is simple and constant-time per test case.

--------------------------------------------
TIME COMPLEXITY AND PERFORMANCE ANALYSIS
--------------------------------------------

PER TEST CASE:
- Input reading: O(1)
- Logic: O(1)

TOTAL:
- For t test cases: O(t)

✅ Confirmed efficient under standard competitive programming limits.

COMPETITIVE LIMITS:
- 1 sec → ~10^8 operations allowed
- Our code: At most 100 test cases × constant time = 100 operations → extremely fast

--------------------------------------------
SPACE COMPLEXITY
--------------------------------------------

- O(1) for input variables
- No additional space or data structures used

--------------------------------------------
SUMMARY
--------------------------------------------

- Checks if n % 3 == 0 → print "Second", else "First"
- Uses basic modulo math and no complex structures
- Clean handling of all edge cases due to simple math
- Efficient under all given constraints
*/
