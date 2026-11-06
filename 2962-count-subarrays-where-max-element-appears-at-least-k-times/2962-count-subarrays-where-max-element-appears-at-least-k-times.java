
class Solution {
    public long countSubarrays(int[] nums, int k) {
        int max = nums[0];
        // Step 1: Find global maximum
        for (int num : nums){
            max = Math.max(max, num);
        }
        int left = 0;
        int maxCount = 0;
        long count = 0;
        // Step 2: Sliding Window
        for (int right = 0; right < nums.length; right++) {
            // Count occurrences of maximum
            if (nums[right] == max){
                maxCount++;
            }
            // Step 3: Shrink while window is valid
            while (maxCount >= k){
                // All subarrays starting at left
                // and ending at or after right are valid
                count += nums.length - right;
                // Remove leftmost element
                if (nums[left] == max){
                    maxCount--;
                }
                left++;
            }
        }
        return count;
    }
}
