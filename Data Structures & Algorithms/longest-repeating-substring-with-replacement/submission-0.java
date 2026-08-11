class Solution {
    private boolean isValid(int[] count, int n, int k) {
        int maxCount = 0;
        for(int each : count) maxCount = Math.max(maxCount, each);
        return maxCount + k >= n;
    }
    public int characterReplacement(String s, int k) {
        int right = 0;
        int left = 0;
        int n = s.length();
        int res = 0;
        int[] count = new int[26];
        while(right < n) {
            count[s.charAt(right) - 'A'] += 1;
            int windowSize = right - left + 1;
            if(!isValid(count, windowSize, k)) {
                count[s.charAt(left) - 'A'] -= 1;
                left+=1;
            }
            res = Math.max(res, right - left + 1);
            right+=1;
        }
        return res;
    }
}
