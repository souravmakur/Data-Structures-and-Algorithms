public class FindPeakElement {
    public static int BruteForce(int arr[]) {
        for(int i = 0; i<arr.length; i++){
            boolean left = (i == 0) || (arr[i] >= arr[i-1]);
            boolean right = (i == arr.length - 1) || (arr[i] <= arr[i+1]);
            if(left && right){
                return i;
            }
        }
        return -1;
    }
    public static int OptimalSolution(int arr[]) {
        int n = arr.length;
        int low = 1;
        int high = n-2;
        // if(n == 1) {
        //     return 0;
        // }
        // if(arr[0] > arr[1]) {
        //     return 0;
        // }
        // if(arr[n-1] > arr[n-2]) {
        //     return n-1;
        // }
        while(low <= high) {
            int mid = (low + high) /2;
            if(arr[mid] > arr[mid + 1] && arr[mid] > arr[mid - 1]) {
                return mid;
            }else if (arr[mid] > arr[mid - 1]) {
                low = mid + 1;
            }else if (arr[mid] > arr[mid + 1]) {
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return - 1;
    }

    public static void main (String args[]) {
        int arr [] = {1,2,1,3,5,6,4};
        System.out.println(OptimalSolution(arr));
    }
}
