public class FindTarget {
    public static int iterative(int arr[] , int target) {
        int low = 0;
        int high = arr.length - 1;
        while(low <= high) {
            int mid = (low + high) / 2;
            if(arr[mid] == target) {
                return mid;
            }
            if(arr[mid] < target) {
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return -1;
    }
    public static int recursive(int arr[], int low, int high, int target) {
         int mid = (low + high) / 2;
         if(arr[mid] == target) {
            return mid;
         }else if(arr[mid] > target) {
            return recursive(arr, low, mid-1, target);
         }else {
            return recursive(arr, mid+1, high, target);
         }
    }
    public static void main (String args[]) {
        int arr [] = {-1,0,3,5,9,12};
        int target = 9;
        System.out.println(iterative(arr , target));
        System.out.println(recursive(arr ,0,arr.length-1, target));
    }
}