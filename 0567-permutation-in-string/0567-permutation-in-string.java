class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        int[] s1Freq = new int[26];
        int[] windowFreq = new int[26];
        // Step 1: Calculate frequency of s1
        for (int i = 0; i < s1.length(); i++) {
            char ch = s1.charAt(i);
            s1Freq[ch - 'a']++;
        }
        int left = 0;
        int windowSize = s1.length();
        // Step 2: Sliding Window
        for (int right = 0; right < s2.length(); right++) {
            // Add current character
            char ch = s2.charAt(right);
            windowFreq[ch - 'a']++;
            // Maintain fixed window size
            if (right - left + 1 > windowSize) {
                char leftChar = s2.charAt(left);
                // Remove leftmost character
                windowFreq[leftChar - 'a']--;
                left++;
            }
            // Step 3: Compare frequencies
            if (right - left + 1 == windowSize) {
                if (Arrays.equals(s1Freq, windowFreq)) {
                    return true;
                }
            }
        }
        return false;
    }
}
