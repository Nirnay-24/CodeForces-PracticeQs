/*
--------------------------------------------
Problem: #7 - Don't Try to Count
Problem Link  : https://codeforces.com/problemset/problem/1881/A

Problem Statement Summary:
Given a string 𝑥 of length 𝑛 and a string 𝑠 of length 𝑚 (𝑛⋅𝑚≤25), consisting of lowercase Latin letters, you can apply any number of operations to the string 𝑥.

In one operation, you append the current value of 𝑥 to the end of the string 𝑥. Note that the value of 𝑥 will change after this.

For example, if 𝑥="aba", then after applying operations, 𝑥 will change as follows: "aba" → "abaaba" → "abaabaabaaba".

After what minimum number of operations 𝑠 will appear in 𝑥 as a substring? A substring of a string is defined as a contiguous segment of it.

Input Format:
- The first line contains a single integer 𝑡 (1 ≤ 𝑡 ≤ 10⁴) — the number of test cases.
- Each test case consists of three lines:
    - First line: two integers 𝑛 and 𝑚 (1 ≤ 𝑛⋅𝑚 ≤ 25) — lengths of strings 𝑥 and 𝑠.
    - Second line: the string 𝑥 of length 𝑛.
    - Third line: the string 𝑠 of length 𝑚.

Output Format:
- For each test case, output a single number — the minimum number of operations after which 𝑠 will appear in 𝑥 as a substring. If this is not possible, output −1.

Example:
Input:
12
1 5
a
aaaaa
5 5
eforc
force
2 5
ab
ababa
3 5
aba
ababa
4 3
babb
bbb
5 1
aaaaa
a
4 2
aabb
ba
2 8
bk
kbkbkbkb
12 2
fjdgmujlcont
tf
2 2
aa
aa
3 5
abb
babba
1 19
m
mmmmmmmmmmmmmmmmmmm

Output:
3
1
2
-1
1
0
1
3
1
0
2
5
*/

import java.util.*;

public class _7_DontTryToCount {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt(); // number of test cases
        while (t-- > 0) {
            int n = in.nextInt(); // length of string x
            int m = in.nextInt(); // length of string s
            String x = in.next(); // original string x
            String s = in.next(); // target string s
            String str = x; // start with the original string
            int ops = 0; // count of operations
            int maxOps = 6; // at most 6 operations are sufficient (since n*m <= 25)

            // Keep doubling x until s becomes a substring or we exceed 6 operations
            while (!str.contains(s) && ops <= maxOps) {
                str += str; // append current x to itself
                ops++; // increment operation count
            }

            // Output the number of operations if s found, else -1
            System.out.println(str.contains(s) ? ops : -1);
        }
    }
}

/*
--------------------------------------------
DETAILED EXPLANATION OF LOGIC AND ANALYSIS
--------------------------------------------

APPROACH (Very Easy to Understand):

1. You are given a string `x`, and in each operation, you double it (i.e., x = x + x).
2. You need to find how many such operations are required until the target string `s` becomes a substring of `x`.
3. If after a reasonable number of operations (max 6 is enough due to the input constraint `n * m ≤ 25`), `s` is not found, return -1.
4. Otherwise, return the number of operations taken to reach the point where `s` appears in `x`.

This works because string length increases exponentially and max combined length is small.

--------------------------------------------
USAGE OF DATA STRUCTURES:
--------------------------------------------

1. `Scanner`:
   - Purpose: To read input efficiently from standard input.
   - Initialization:
     ```java
     Scanner in = new Scanner(System.in);
     ```
   - Functions used:
     - `nextInt()` → Reads next integer.
     - `next()` → Reads next token (word).

2. `String`:
   - Purpose: To hold the growing version of `x` and search for substring `s`.
   - Initialization:
     ```java
     String str = x;
     ```
   - Functions used:
     - `contains(s)` → Checks if `s` is a substring of `str`.
     - `+=` operator → To double the current string.

--------------------------------------------
TIME COMPLEXITY AND PERFORMANCE ANALYSIS
--------------------------------------------

PER TEST CASE:
- Input reading: O(1)
- String doubling: O(2^k) for at most k=6 ⇒ bounded operations.
- contains() check: O(L), where L is current length of `str`.

TOTAL:
- At most 6 doublings × string check → negligible due to very small max total size (≤ 25 characters).

✅ Confirmed efficient under standard competitive programming limits.

COMPETITIVE LIMITS:
- 1 sec → 10^8 ops allowed
- Our code: << max 6 string doublings of size ≤ 25 → well under limit.

--------------------------------------------
SPACE COMPLEXITY
--------------------------------------------

- O(1) for scalar values
- O(n + m) per test case for the strings

--------------------------------------------
SUMMARY
--------------------------------------------

- We simulate appending `x` to itself up to 6 times.
- After each step, we check if `s` appears in the new version of `x`.
- We use `.contains()` for substring checking and simple string concatenation.
- The exponential growth ensures we reach any required combination quickly, and due to the constraints, it remains efficient.
*/
