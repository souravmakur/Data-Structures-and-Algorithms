import java.util.Arrays;

public class MinimumNumberOfBouquets {
    public static boolean isPossible(int bloomDays[] , int day , int m , int k) {
        int count = 0;
        int bouquets = 0 ;
        for(int bloom : bloomDays) {
            if(bloom <= day) {
                count++;
                if(count == k) {
                    bouquets++;
                    count = 0;
                }
            }else{
                count =0;
            }
        }
        return bouquets >= m;
    }
    public static int BruteForce (int bloomDays[] , int m , int k) {
        int min = Arrays.stream(bloomDays).min().getAsInt();
        int max = Arrays.stream(bloomDays).max().getAsInt();

        for(int day = min; day <= max ; day++) {
            if(isPossible(bloomDays, day, m, k)) {
                return day;
            }
        }
        return -1;
    }
    public static int Optimal(int bloomDays[] , int m , int k) {
        int required = m*k;
        if(required > bloomDays.length) {
            return -1;
        }
        int low = Arrays.stream(bloomDays).min().getAsInt();
        int high = Arrays.stream(bloomDays).max().getAsInt();
        int ans = -1;

        while(low <= high) {
            int mid = (low + high) / 2;
            if(isPossible(bloomDays, mid, m, k)) {
                ans = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return ans;
    }
    public static void main (String args[]) {
        int arr[] = {7 , 7 , 7 , 7 , 13 , 11 , 12 , 7};
        int arr2[] = {1 , 10 , 3 , 10 , 2};
        int m = 3;
        int k = 2;

        System.out.println(BruteForce(arr, m, k));
        System.out.println(BruteForce(arr2, m, k));
        System.out.println(Optimal(arr, m, k));
    }
}