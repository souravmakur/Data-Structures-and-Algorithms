import java.util.*;
public class lengthOfLongestSubstring {
    class SolutionBrute {
        public static int Brute(String s) {
            int maxLen = 0;
            int n = s.length();
            for(int i=0; i<n; i++) {
                int hash[] = new int[256];
                Arrays.fill(hash , 0);
                for(int j=i; j<n; j++) {
                    if(hash[s.charAt(j)] == 1) {
                        break;
                    }
                    hash[s.charAt(j)] = 1;
                    int len  = j - i + 1;
                    maxLen = Math.max(len , maxLen);
                }                
            }
            return maxLen;
        }
        public static int Optimal(String s) {
            int maxLen = 0;
            int n = s.length();
            int r = 0;
            int l = 0;

            int hash[] = new int[256];

            while(r < n) {
                if(hash[s.charAt(r)] >= l) {
                    l = Math.max(l , hash[s.charAt(r)] + 1);
                }
                hash[s.charAt(r)] = r;
                int len = r - l + 1;
                maxLen = Math.max(len , maxLen);
            }
            return maxLen;
        }
    }    

    public static void main (String args[]) {
        String s = "abcdefghabgahbfbbdbabbaaa";

        lengthOfLongestSubstring ref = new lengthOfLongestSubstring();

        SolutionBrute solB = ref.new SolutionBrute();
        System.out.println(solB.Brute(s));
        System.out.println(solB.Optimal(s));
       }
}