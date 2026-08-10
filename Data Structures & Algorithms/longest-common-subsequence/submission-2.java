class Solution {
    // return the lcs of t1[first...n-1] and t2[second...n-1]
    private int lcs(int first, int second, String t1, String t2, int[][] dp) {
        if(first >= t1.length() || second >= t2.length()) return 0;
        if(t1.charAt(first) == t2.charAt(second)) return 1 + lcs(first+1, second + 1, t1, t2,dp);
        if(dp[first][second] != -1) return dp[first][second];
        int include = lcs(first+1, second, t1, t2, dp);
        int exclude = lcs(first, second + 1, t1, t2, dp);
        dp[first][second]  = Math.max(include, exclude);
        return dp[first][second];
    }
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
        for(int first = text1.length() - 1 ; first >= 0 ; first--) {
            for(int second = text2.length() - 1 ; second >= 0 ; second--) {
                if(text1.charAt(first) == text2.charAt(second)) {
                    dp[first][second] = 1 + dp[first+1][second+1];
                } else {
                    int include = dp[first+1][second];
                    int exclude = dp[first][second+1];
                    dp[first][second]  = Math.max(include, exclude);
                }
            }
        }
        return dp[0][0];
    }
}
