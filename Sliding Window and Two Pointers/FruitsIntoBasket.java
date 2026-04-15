import java.util.*;
public class FruitsIntoBasket {
    class Solution {
        public static int Brute(int arr[]) {
            int maxLen = 0;
            for(int i=0; i<arr.length; i++) {
                HashMap<Integer,Integer>map = new HashMap<>();
                int count = 0;
                for(int j=i; j<arr.length; j++) {
                    map.put(arr[j] , map.getOrDefault(arr[j] , 0) + 1);
                    if(map.size() > 2) {
                        break;
                    }
                    count++;
                }
                maxLen = Math.max(count , maxLen);
            }
            return maxLen;
        }
        public static int Better(int arr[]) {
            int maxLen = 0;
            HashMap<Integer , Integer> map = new HashMap<>();
            int r = 0;
            int l = 0;
            int n = arr.length;
            while(r<n) {
                map.put(arr[r] , map.getOrDefault(arr[r] , 0) + 1);

                if(map.size() > 2 ) {
                    map.put(arr[l] , map.get(arr[l]) - 1);
                    l++;
                }
                int len = r-l+1;
                maxLen = Math.max(maxLen , len);
                r++;
            }
            return maxLen;
        }
        public static int Optimal(int arr []) {
            int maxLen = 0;
            int n = arr.length;
            int r = 0;
            int l = 0;
            HashMap<Integer , Integer>map = new HashMap<>();

            while(r<n) {
                map.put(arr[r] , map.getOrDefault(arr[l], 0) + 1);
                if(map.size() > 2) {
                    map.put(arr[l] , map.get(arr[l]) - 1);
                    l++;
                }
                int len = r - l + 1;
                maxLen = Math.max(len , maxLen);
                r++;
            }
            return maxLen;
        }
    }
    public static void main (String args []) {
        int arr [] = {3,3,3,1,2,1,1,2,3,3,4};
        FruitsIntoBasket ref = new FruitsIntoBasket();
        Solution sol = ref.new Solution();

        System.out.println(sol.Brute(arr));
        System.out.println(sol.Better(arr));
        System.out.println(sol.Optimal(arr));
    }
}
