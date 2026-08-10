class Solution {
    private boolean isValid(int index, String s) {
         if (index + 1 >= s.length()) return false;

            int num = (s.charAt(index) - '0') * 10
                    + (s.charAt(index + 1) - '0');

            return num >= 10 && num <= 26;
    }
    public int numDecodings(String s) {
        int[] dp = new int[s.length() + 1];
        int n = s.length();
        dp[n] = 1;
        for(int index = n - 1 ; index >= 0 ; index--) {
            if(s.charAt(index) == '0') {
                dp[index] = 0;
            } else {
                int first = dp[index+1];
                int second = 0 ;
                if(isValid(index, s)) {
                    second = dp[index+2];
                }
                dp[index] = first + second;
            }
        }
        return dp[0];
    }
}
