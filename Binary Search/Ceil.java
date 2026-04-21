public class Ceil {
    public static int floor(int arr[] , int target) {
        int ans = -1;
        int low = 0;
        int high = arr.length-1;
        
        while(low <= high) {
            int mid = (low + high) / 2;
            if(arr[mid] >= target) {
                ans = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return ans;
    }
    public static void main (String args[]) {
        int arr[] = {1, 2, 8, 10, 11, 12, 19};
        int target = 5;
        System.out.println(floor(arr, target));
    }
}
