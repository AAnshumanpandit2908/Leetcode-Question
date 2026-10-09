class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int[] mn = new int[m + n];
        int i = 0, j = 0, k = 0;
        while (i < m && j < n) {
            if (nums1[i] < nums2[j]) {
                mn[k++] = nums1[i++];
            } else {
                mn[k++] = nums2[j++];
            }
        }
        while (i < m) mn[k++] = nums1[i++];
        while (j < n) mn[k++] = nums2[j++];
        
        int len = mn.length;
        if (len % 2 == 1) {
            return mn[len / 2]; 
        } else {
            return (mn[len / 2 - 1] + mn[len / 2]) / 2.0;
        }
    }
}
