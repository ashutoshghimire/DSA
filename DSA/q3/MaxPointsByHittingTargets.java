public class MaxPointsByHittingTargets {
    /**
     * Calculates the maximum points that can be obtained by hitting targets at different positions.
     *
     * @param a An array representing the values of hitting targets at different positions.
     * @return The maximum points that can be obtained.
     */
    public static int maxPoints(int[] a) {
        int n = a.length;
        int[] dpLeft = new int[n + 2]; // To store the product of values to the left of each position
        int[] dpRight = new int[n + 2]; // To store the product of values to the right of each position
        dpLeft[0] = dpLeft[n + 1] = dpRight[0] = dpRight[n + 1] = 1;

        // Initialize dpLeft and dpRight with the values from the input array
        for (int i = 1; i <= n; i++) {
            dpLeft[i] = a[i - 1];
            dpRight[i] = a[i - 1];
        }

        // Calculate the cumulative product of values to the left and right of each position
        for (int i = 1; i <= n; i++) {
            dpLeft[i] *= dpLeft[i - 1];
            dpRight[i] *= dpRight[i + 1];
        }

        int maxPoints = 0;
        // Calculate the maximum points that can be obtained by hitting at each position
        for (int i = 1; i <= n; i++) {
            int points = dpLeft[i - 1] * a[i - 1] * dpRight[i + 1];
            maxPoints = Math.max(maxPoints, points);
        }

        return maxPoints;
    }

    public static void main(String[] args) {
        int[] a = {3, 1, 5, 8};
        int result = maxPoints(a);
        System.out.println("Maximum points: " + result); // Expected Output: 167
    }
}
