public class MinimumCostOfClothing {
    public static int findMinimumCost(int[][] price) {
        int N = price.length;
        if (N != 3) {
            throw new IllegalArgumentException("The number of people (N) must be 3.");
        }

        // Initialize the minimum costs for the first person with the costs of the first set of clothing options
        int minCost1 = price[0][0];
        int minCost2 = price[0][1];
        int minCost3 = price[0][2];

        // Iterate through the remaining people to calculate the minimum cost of clothing for each person
        for (int i = 1; i < N; i++) {
            // Store the previous minimum costs for each clothing option
            int prevMinCost1 = minCost1;
            int prevMinCost2 = minCost2;
            int prevMinCost3 = minCost3;

            // Calculate the minimum cost for each clothing option for the current person
            minCost1 = price[i][0] + Math.min(prevMinCost2, prevMinCost3);
            minCost2 = price[i][1] + Math.min(prevMinCost1, prevMinCost3);
            minCost3 = price[i][2] + Math.min(prevMinCost1, prevMinCost2);
        }

        // The final result is the minimum of the minimum costs for all clothing options
        return Math.min(minCost1, Math.min(minCost2, minCost3));
    }

    public static void main(String[] args) {
        int[][] price = {
            {14, 4, 11},
            {11, 14, 3},
            {14, 2, 10}
        };
        int result = findMinimumCost(price);
        System.out.println("Minimum cost required: " + result); // Expected Output: 9
    }
}
