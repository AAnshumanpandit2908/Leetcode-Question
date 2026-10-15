class Solution {
    public int[] rearrangeArray(int[] nums) {
        TreeMap <Integer , Integer> freq = new TreeMap<>();
        int maxFreq = 0;    
        for(int x : nums){
            int count = freq.getOrDefault(x , 0) + 1;
            freq.put(x , count);
            maxFreq = Math.max(maxFreq , count);
        }
        int [] ans = new int[nums.length];
        int idx = 0;
        for (int r = 1; r <= maxFreq; r++) {
            for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
                if (entry.getValue() >= r) {
                    ans[idx++] = entry.getKey();
                }
            }
        }

        return ans;
    }
}