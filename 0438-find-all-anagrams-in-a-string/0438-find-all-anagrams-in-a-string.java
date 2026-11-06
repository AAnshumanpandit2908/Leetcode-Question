class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        if (p.length() > s.length()) {
            return list;
        }
        int[] pFreq = new int[26];
        int[] windowFreq = new int[26];
        // Calculate frequency of p
        for (int i = 0; i < p.length(); i++) {
            pFreq[p.charAt(i) - 'a']++;
        }
        int left = 0;
        int windowSize = p.length();
        // Sliding Window
        for (int right = 0; right < s.length(); right++) {
            // Add current character
            char ch = s.charAt(right);
            windowFreq[ch - 'a']++;
            // Maintain fixed window size
            if (right - left + 1 > windowSize) {
                char leftChar = s.charAt(left);
                windowFreq[leftChar - 'a']--;
                left++;
            }
            // Compare frequencies
            if (right - left + 1 == windowSize) {
                if (Arrays.equals(pFreq, windowFreq)) {
                    list.add(left);
                }
            }
        }
        return list;
    }
}
