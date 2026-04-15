public class LongestRepeatingCharacterReplacement {
    public static int Brute(String s , int k) {
        int maxLen = 0;
        int n = s.length();

        for(int i=0; i<n; i++) {
            int freq[] = new int[26];
            int maxFreq = 0;
            for(int j=i; j<n; j++) {
                freq[s.charAt(j) - 'A']++;
                int len = j-i+1;
                maxFreq = Math.max(maxFreq , freq[s.charAt(j) - 'A']);
                int replacements = len - maxFreq;

                if(replacements <= k) {
                    maxLen = Math.max(len , maxLen);
                }
            }
        }
        return maxLen;
    }
    public static void main (String args[]) {
        String s = "AABABBA";
        int k = 2;
        System.out.println(Brute(s, k));
    }
}
