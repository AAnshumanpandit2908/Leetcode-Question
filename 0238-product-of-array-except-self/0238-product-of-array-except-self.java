class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int answer[] = new int[n];
        int product = 1;
        answer[0] =1;
        for(int i = 1 ; i < n ; i++){
            product *= nums[i-1];
            answer[i] = product;
        }
        int rightProduct =1;
        for(int i = n-1 ; i >= 0 ; i--){
            answer[i] *= rightProduct;

            rightProduct *= nums[i];
        }
        return answer;
    }
}