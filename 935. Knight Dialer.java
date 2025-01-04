//Approach-1 (Using Recursion + Memoization)
//T.C : O(n*9) Total n*k states
//S.C : O(n*9)
public class Solution {
    private static final int M = 1000000007;
    private static final List<List<Integer>> adj = Arrays.asList(
            Arrays.asList(4, 6),
            Arrays.asList(6, 8),
            Arrays.asList(7, 9),
            Arrays.asList(4, 8),
            Arrays.asList(3, 9, 0),
            Arrays.asList(),
            Arrays.asList(1, 7, 0),
            Arrays.asList(2, 6),
            Arrays.asList(1, 3),
            Arrays.asList(2, 4)
    );

    private int[][] t = new int[5001][10];

    private int solve(int n, int cell) {
        if (n == 0) {
            return 1;
        }

        if (t[n][cell] != -1) {
            return t[n][cell];
        }

        int result = 0;

        for (int nextCell : adj.get(cell)) {
            result = (result + solve(n - 1, nextCell)) % M;
        }

        return t[n][cell] = result;
    }

    public int knightDialer(int n) {
        int result = 0;
        Arrays.stream(t).forEach(row -> Arrays.fill(row, -1));

        for (int cell = 0; cell <= 9; cell++) {
            result = (result + solve(n - 1, cell)) % M;
        }

        return result;
    }
}


//Approach-2 (Using Bottom Up - Just write from the recursion)
//T.C : O(n*10)
//S.C : O(n*10)
public class Solution {
    private static final int M = 1000000007;
    private static final List<List<Integer>> adj = Arrays.asList(
            Arrays.asList(4, 6),
            Arrays.asList(6, 8),
            Arrays.asList(7, 9),
            Arrays.asList(4, 8),
            Arrays.asList(3, 9, 0),
            Arrays.asList(),
            Arrays.asList(1, 7, 0),
            Arrays.asList(2, 6),
            Arrays.asList(1, 3),
            Arrays.asList(2, 4)
    );

    public int knightDialer(int n) {
        int result = 0;

        // t[i][j] = number of ways to form a number of length i when I am currently at cell j
        int[][] t = new int[n][10];

        for (int cell = 0; cell < 10; cell++) {
            t[0][cell] = 1; // for n == 0, we always return 1
        }

        for (int i = 1; i < n; i++) { // This is the length of the number
            for (int cell = 0; cell <= 9; cell++) {
                int ans = 0;
                for (int nextCell : adj.get(cell)) {
                    ans = (ans + t[i - 1][nextCell]) % M;
                }
                t[i][cell] = ans;
            }
        }

        for (int cell = 0; cell <= 9; cell++) {
            result = (result + t[n - 1][cell]) % M;
        }

        return result;
    }
}
