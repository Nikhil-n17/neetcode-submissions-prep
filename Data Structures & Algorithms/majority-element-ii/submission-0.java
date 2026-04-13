class Solution {
    public List<Integer> majorityElement(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();
        for(int num: nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }
        int n = (int)Math.ceil(nums.length / 3);
        List<Integer> res = new ArrayList<>();
        count.forEach((key, value) -> {
            if(value > n) res.add(key);
        });
        return res;
    }
}