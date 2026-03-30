class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        List<Integer> res = new ArrayList<>();
        int n = temperatures.length;
        for(int i = 0 ; i < n ; i++) {
            int curr = temperatures[i];
            int j = i + 1;
            int count = 1;
            while( j < n && temperatures[j] <= curr) {
                j++;
                count++;
            }
            if(j != n) {
                res.add(count);
            } else {
                res.add(0);
            }
        }
        return res.stream().mapToInt(i -> i).toArray();
    }
}
