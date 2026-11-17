class Solution {
    public int characterReplacement(String s, int k) {

        int left = 0;
        int maxFreq = 0;
        int maxLen = 0;

        int freq[] = new int[26];

        for (int right = 0; right < s.length(); right++) {

            char ch = s.charAt(right);

            freq[ch - 'A']++;

            maxFreq = Math.max(maxFreq, freq[ch - 'A']);

            int window = right - left + 1;

            if (window - maxFreq > k) {

                freq[s.charAt(left) - 'A']--;
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}