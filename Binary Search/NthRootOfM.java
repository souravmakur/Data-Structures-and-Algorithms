import java.util.*;
public class NthRootOfM {
    public static int helper (int i , int n) {
        int answer = 1;
        for(int j = 0; j<n; j++) {
            answer = answer * i;
        }
        return answer;
    }
    public static boolean answer(int n , int m) {
        int ans = 0;
        for(int i = 1; i <= n; i++) {
            if(helper(i , n) == m) {
                return true;
            }
        }
        return false;
    }
    public static void main (String args[]) {
        int n = 4;
        int m = 69;
        System.out.println(answer(n , m));
    }
}
