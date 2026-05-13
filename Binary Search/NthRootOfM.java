import java.lang.management.OperatingSystemMXBean;
import java.util.*;
public class NthRootOfM {
    public static int helper (int i , int n) {
        int answer = 1;
        for(int j = 0; j<n; j++) {
            answer = answer * i;
        }
        return answer;
    }
    public static boolean Brute(int n , int m) {
        int ans = 0;
        for(int i = 1; i <= n; i++) {
            if(helper(i , n) == m) {
                return true;
            }
        }
        return false;
    }
    public static int Optimal(int n , int m) {
        if(m == 0) {
            return 0;
        }
        if(m == 1) {
            return 1;
        }
        int low = 1;
        int high = n;
        while(low <= high) {
            int mid = (low + high) / 2;
            if(helper(mid, n) == m) {
                return mid;
            }else if(helper(mid, n) > m) {
                high = mid - 1;
            }else {
                low = mid + 1;
            }
        }
        return -1;
    }
    public static void main (String args[]) {
        int n = 3;
        int m = 27;
        int n1 = 4;
        int m1= 69;
        System.out.println(Brute(n , m));
        System.out.println(Optimal(n , m));
        System.out.println();
        System.out.println(Brute(n1 , m1));
        System.out.println(Optimal(n1 , m1));
    }
}
