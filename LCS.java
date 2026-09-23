import java.util.*;

public class LCS {

    // Function to calculate LCS length and build DP table
    public static int[][] lcsLength(String X, String Y) {
        int m = X.length();
        int n = Y.length();

        // dp[i][j] = length of LCS of X[0..i-1] and Y[0..j-1]
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {

                if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp;
    }

    // Function to reconstruct the actual LCS
    public static String buildLCS(String X, String Y, int[][] dp) {
        int i = X.length();
        int j = Y.length();

        StringBuilder result = new StringBuilder();

        while (i > 0 && j > 0) {

            if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                result.append(X.charAt(i - 1));
                i--;
                j--;
            } 
            else if (dp[i - 1][j] >= dp[i][j - 1]) {
                i--;
            } 
            else {
                j--;
            }
        }

        // Reverse because characters were added from the end
        return result.reverse().toString();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first string: ");
        String X = sc.nextLine();

        System.out.print("Enter second string: ");
        String Y = sc.nextLine();

        // Calculate DP table
        int[][] dp = lcsLength(X, Y);

        // Build actual LCS
        String lcs = buildLCS(X, Y, dp);

        System.out.println("\nLCS: " + lcs);
        System.out.println("LCS Length: " + lcs.length());

        sc.close();
    }
}
