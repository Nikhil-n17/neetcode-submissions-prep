class Solution {
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
        int[][] dp = new int[nums.length][target+1];
        for(int[] row : dp) Arrays.fill(row, -1);
        return hasSum(nums, nums.length - 1, target, dp);
    }
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int each : nums) sum+=each;
        int target = sum / 2;
        if(sum % 2 == 1) return false;
        return hasSubSetWithSum(nums, target);
    }
}
