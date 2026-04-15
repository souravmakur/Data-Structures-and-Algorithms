public class maximumConsecutiveOnes{
    class Solution {
        public static int Brute(int nums[] , int k) {
            int maxLen = 0;
            int n = nums.length;
            for(int i=0; i<n; i++) {
                int zeros = 0;
                for(int j=i; j<n; j++) {
                    if(nums[j] == 0) {
                        zeros++;
                    }
                    if(zeros <= k) {
                        int len = j - i + 1;
                        maxLen = Math.max(len , maxLen);
                    }else{
                        break;
                    }
                }
            }
            return maxLen;
        }
        public static int Better(int nums[] , int k) {
            int n = nums.length;
            int l = 0;
            int r = 0;
            int maxLen = 0;
            int zeroCount = 0;

            while(r < n) {
                if(nums[r] == 0) {
                    zeroCount++;
                }
                if(zeroCount > k){
                    if(nums[l] == 0) {
                        zeroCount--;
                    }
                    l++;
                }
                int len = r-l+1;
                maxLen = Math.max(maxLen, len);
                r++;
        }
        return maxLen;
    }
    public static int Optimal(int nums[] , int k) {
        int n = nums.length;
        int r = 0;
        int l = 0;
        int maxLen = 0;
        int zeroCount = 0;
        
        while(r<n){
            if(nums[r] == 0) {
                zeroCount ++;
            }
            while(zeroCount > k) {
                if(nums[l] == 0) {
                    zeroCount--;
                }
                l++;
            }
            int len = r-l+1;
            maxLen = Math.max(maxLen, len);
            r++;
        }
        return maxLen;
    }
}
    public static void main(String args []) {
        int nums [] = {1,1,1,0,0,0,1,1,1,1,0};
        int k = 2;

        maximumConsecutiveOnes ref = new maximumConsecutiveOnes();
        Solution sol = ref.new Solution();
        
        System.out.println(sol.Brute(nums , k));
        System.out.println(sol.Better(nums , k));
        System.out.println(sol.Optimal(nums, k));

        }
}
