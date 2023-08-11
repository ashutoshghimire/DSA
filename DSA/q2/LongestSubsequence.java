public class LongestSubsequence {

    /**
     * Finds the length of the longest subsequence where the absolute difference between
     * consecutive elements is at most 'k'.
     *
     * @param nums An array of integers representing the sequence.
     * @param k    The maximum allowed absolute difference between consecutive elements.
     * @return The length of the longest subsequence.
     */
    public static int longestSubsequence(int[] nums, int k) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = 1;

        // Dynamic programming approach to find the length of the longest subsequence
        for (int i = 1; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                // Check if the difference between elements at positions 'i' and 'j' is within the limit 'k'
                if (nums[i] < nums[j] && Math.abs(nums[i] - nums[j]) <= k) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int maxLength = 0;
        // Find the maximum length from the dynamic programming array
        for (int length : dp) {
            maxLength = Math.max(maxLength, length);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        int[] nums = {8, 5, 4, 2, 1, 4, 3, 4, 3, 1, 15};
        int k = 3;
        int result = longestSubsequence(nums, k);
        System.out.println("Length of the longest subsequence: " + result); // Expected Output: 5
    }
}
