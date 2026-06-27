class Solution {
    public boolean canCross(int[] stones) {
        int n = stones.length;

        // dp[i][k] = can we reach stone i with jump k
        boolean[][] dp = new boolean[n][n + 1];

        dp[0][0] = true;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {

                int k = stones[i] - stones[j];

                if (k > n) continue;

                // check if we can reach j with k-1, k, or k+1
                if (dp[j][k] || 
                   (k - 1 >= 0 && dp[j][k - 1]) || 
                   (k + 1 <= n && dp[j][k + 1])) {

                    dp[i][k] = true;
                }
            }
        }

        // check last stone
        for (int k = 0; k <= n; k++) {
            if (dp[n - 1][k]) return true;
        }

        return false;
    }
}