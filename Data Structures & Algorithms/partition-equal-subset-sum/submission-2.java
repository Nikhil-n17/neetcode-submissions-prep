class Solution {
    // returns true, if there is a subset where sum = target, from index to 0 
    private boolean hasSum(int[] nums, int index, int target, int[][] dp) {
        if(index == 0) return nums[0] == target;
        if(target == nums[index]) return true;
        if(dp[index][target] != -1) return dp[index][target] == 1 ? true : false;
        boolean exclude = hasSum(nums, index - 1, target, dp);
        boolean include = false;
        if(target > nums[index]) {  
            include = hasSum(nums, index - 1, target - nums[index], dp);
        }
        dp[index][target] = ( include || exclude) ? 1 : 0;
        return dp[index][target] == 1 ? true : false;
    }
    private boolean hasSubSetWithSum(int[] nums, int target) {
        boolean[][] dp = new boolean[nums.length][target+1];
        int n  = nums.length;
        for(int index = 0 ; index < n ; index++) {
            for(int curr = 0 ; curr <= target ; curr++) {
                if(index == 0) {
                    dp[0][curr] = nums[0] == curr;
                } else if (curr == nums[index]) {
                    dp[index][curr] = true;
                } 
                else {
                    boolean exclude = dp[index - 1][curr];
                    boolean include = false;
                    if(curr > nums[index]) {  
                        include = dp[index - 1][curr-nums[index]];
                    }
                    dp[index][curr] = exclude || include;
                }
                
            }
        }
        return dp[n-1][target];
    }
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int each : nums) sum+=each;
        int target = sum / 2;
        if(sum % 2 == 1) return false;
        return hasSubSetWithSum(nums, target);
    }
}
