public class MaxPointsFromShootingTargets {
    /**
     * Calculates the maximum points that can be obtained by shooting targets.
     *
     * @param a An array representing the values of targets at different positions.
     * @return The maximum points that can be obtained.
     */
    public static int maxPoints(int[] a) {
        int n = a.length;
        
        // Create an array paddedTargets to add boundary padding for easier calculation
        int[] paddedTargets = new int[n + 2];
        paddedTargets[0] = paddedTargets[n + 1] = 1;
        System.arraycopy(a, 0, paddedTargets, 1, n);

        // Create a 2D array dp to store the maximum points for shooting targets within specific ranges
        int[][] dp = new int[n + 2][n + 2];

        // Dynamic programming approach to calculate the maximum points
        for (int len = 1; len <= n; len++) {
            for (int left = 1; left <= n - len + 1; left++) {
                int right = left + len - 1;
                for (int i = left; i <= right; i++) {
                    dp[left][right] = Math.max(dp[left][right],
                            dp[left][i - 1] + paddedTargets[left - 1] * paddedTargets[i] * paddedTargets[right + 1] + dp[i + 1][right]);
                }
            }
        }

        return dp[1][n]; // Maximum points for shooting all targets
    }

    public static void main(String[] args) {
        int[] a = {3, 1, 5, 8};
        int result = maxPoints(a);
        System.out.println("Maximum points: " + result); // Expected Output: 167
    }
}
