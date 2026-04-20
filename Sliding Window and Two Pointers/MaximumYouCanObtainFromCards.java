public class MaximumYouCanObtainFromCards {
    public static int Optimal(int arr[] , int k) {
        int total = 0;
        for(int i=0; i<k; i++) {
            total = total + arr[i];
        }
        int max = total;
        for(int i=0; i<k; i++) {
            max = max - arr[k-1-i];
            max = max + arr[arr.length-1-i];
            Math.max(max , total);
        }
        return max;
    }
    public static void main(String args []) { 
        int arr[] = {6,2,3,4,7,2,1,7,1};
        int k = 4;

        System.out.println(Optimal(arr, k));


    }
}
