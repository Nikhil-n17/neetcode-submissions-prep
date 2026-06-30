class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 0;
        int res = 0;
        Set<Character> seen = new HashSet<>(); 
        while(right < s.length()) {
            while(seen.contains(s.charAt(right))) {
                seen.remove(s.charAt(left));
                left+=1;
            }
            seen.add(s.charAt(right));
            res = Math.max(res, right - left + 1);
            right += 1;
        }
        return res;
    }
}
