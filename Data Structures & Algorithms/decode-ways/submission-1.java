class Solution {
    private boolean isValid(int index, String s) {
         if (index + 1 >= s.length()) return false;

            int num = (s.charAt(index) - '0') * 10
                    + (s.charAt(index + 1) - '0');

            return num >= 10 && num <= 26;
    }
    private int getWays(int index, String s, int[] dp) {
        if(index >= s.length()) return 1;
        if(s.charAt(index) == '0') return 0;
        if(dp[index] != -1) return dp[index];
        int first = getWays(index+1, s, dp);
        int second = 0 ;
        if(isValid(index, s)) {
            second = getWays(index+2, s, dp);
        }
        dp[index] = first + second;
        return dp[index];
    }
    public int numDecodings(String s) {
        int[] dp = new int[s.length()];
        Arrays.fill(dp, -1);
        return getWays(0, s, dp);
    }
}
