public class LowerBound {
    public static int iterative(int arr[] , int target) {
        int ans = arr.length;
        int low = 0;
        int high = arr.length-1;
        while(low<=high) {
            int mid = (low+high)/2;
            if(arr[mid] >= target) {
                ans = mid;
                high = mid-1;
            }else{
                low = mid + 1;
            }
        }
        return ans;
    }

    
    public static void main (String args[]) {
        int arr[] = {2, 3, 7, 10, 11, 11, 25};
        int target = 9;
        System.out.println(iterative(arr, target));
    }
}
