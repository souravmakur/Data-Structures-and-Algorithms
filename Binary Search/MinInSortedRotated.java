public class MinInSortedRotated {
    public static int Solution(int arr[]) {
        int low = 0;
        int high = arr.length - 1;

        while(low < high) {
            int mid = (low + high) / 2;
            if(arr[mid] > arr[high]){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return arr[low];
    }
    public static void main (String args []) {
        int arr[] = {10,9,8,7,6,5,4,1,2,3};
        System.out.println(Solution(arr));
    }
}
