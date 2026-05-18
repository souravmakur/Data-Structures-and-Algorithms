import java.util.Arrays;

public class KokoEatingBananas {
    public static int calculateTotalHours (int piles[] , int speed) {
        int totalHours = 0;
        for(int i =0; i<piles.length; i++) {
            totalHours += (int)Math.ceil((double)piles[i]  / speed);
        }
        return totalHours;
    }
    public static int minEatingSpeed(int piles[] , int h) {
        int maxPile = Arrays.stream(piles).max().getAsInt();
        int low = 1;
        int high = maxPile;
        int ans = maxPile;
        while(low <= high) {
            int mid = (low + high) / 2;
            int maxHours = calculateTotalHours(piles, mid);

            if(maxHours <= h) {
                ans = mid;
                high = mid - 1; 
            }else{
                low = mid + 1;
            }
        }
        return ans;
    }
    public static void main (String args[]) {
        int[] piles = {3, 6, 7, 11};
        int h = 8;
        System.out.println(minEatingSpeed(piles, h));
    }
}