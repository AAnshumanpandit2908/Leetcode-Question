class Solution {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int left = 0 ;
        int right = 0 ; 
        int countZero = 0; 
        int MaxLength = 0;
        for( right = 0 ; right < n ; right++){
            if(nums[right] == 0){
                countZero++;
            }
            while(countZero > k){
                if(nums[left] == 0){
                   countZero--;
                }
                left++;
               
            }
            MaxLength = Math.max(MaxLength , right-left+1);
        }
        return MaxLength;
    }
}