class Solution {
    public int appendCharacters(String s, String t) {
        int left = 0;
        for(int right = 0 ; right < s.length() ; right++) {
            if(t.charAt(left) == s.charAt(right)) {
                left+=1;
                if(left >= t.length()) return 0;
            }
        }
        return t.length() - left;
    }
}