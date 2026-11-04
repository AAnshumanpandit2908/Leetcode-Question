class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int n = nums.length;
        int left = 0 ; 
        int right = 0 ; 
        int product  = 1;
        int length = 0;
        if(k <= 1) return 0;
        for(right = 0 ; right < n ; right++){
            product *= nums[right];
            while(product >= k){
                product /= nums[left];
                left++;
            }
            length = length + right - left + 1;
        }
        return length;
       

    }
}