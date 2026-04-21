public class Floor {
    public static int floor(int arr[] , int target) {
        int low = 0;
        int high = arr.length-1;
        int ans = -1;
        
        while(low <= high){
            int mid = (low + high)/2;
            if(arr[mid] <= target) {
                ans = mid;
                low = mid+1;
            }else{
                high = mid-1;
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
