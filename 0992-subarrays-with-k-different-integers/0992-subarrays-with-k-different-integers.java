class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return helper(nums, k) - helper(nums, k - 1);
    }
    public int helper(int[] nums, int k) {
        if (k <= 0)
            return 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int left = 0;
        int maxLen = 0;
        for (int right = 0; right < nums.length; right++) {
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);
            while (map.size() > k) {
                map.put(nums[left], map.get(nums[left]) - 1);
                if (map.get(nums[left]) == 0) {
                    map.remove(nums[left]);
                }
                left++;
            }
            maxLen += right - left + 1;
        }
        return maxLen;
    }
}