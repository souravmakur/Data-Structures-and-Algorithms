public class NumberOfSubstringsWithAllTheCharacters {
    public static int Brute(String s) {
        int count = 0;
        for(int i=0; i<s.length(); i++) {
            int hash[] = new int[3];
            for(int j=i; j<s.length(); j++) {
                hash[s.charAt(j) - 'a']++;
                if(hash[0] > 0 && hash[1] > 0 && hash[2] > 0)  {
                    count++;
                }
            }
        }
        return count;
    }
    public static int Optimal(String s) {
        int count = 0;
        int l = 0;
        int r = 0;
        int n = s.length();
        int freq[] = new int[3];
        
        while(r<n) {
            freq[s.charAt(r) - 'a']++;
            while(freq[0] > 0 && freq[1] > 0 && freq[2] > 0) {
                count = count + (s.length() - r);

                freq[s.charAt(l) - 'a']--;
                l++;
            }
            r++;
        }
        return count;
    }
    public static void main (String args[]) {
        String s = "abcabc";
        System.out.println(Brute(s));
        System.out.println(Optimal(s));
    }
}