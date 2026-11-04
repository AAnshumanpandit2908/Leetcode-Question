class Solution {
    public int totalFruit(int[] fruits) {
        HashMap<Integer , Integer > map = new HashMap<>();
        int left = 0 ;
        int maxlen = 0 ;
        for(int right = 0 ; right < fruits.length ; right++){
            int num = fruits[right];
            map.put(num , map.getOrDefault(num , 0)+1);
            while(map.size() > 2){
                int leftnum = fruits[left];
                map.put(leftnum , map.get(leftnum)-1);
                if(map.get(leftnum) == 0){
                    map.remove(leftnum);
                }
                left++;
            }
            maxlen = Math.max(maxlen , right - left + 1);
        }
        return maxlen;
    }
}