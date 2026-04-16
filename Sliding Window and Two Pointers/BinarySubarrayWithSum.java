public class BinarySubarrayWithSum {
    public static int Solution(int arr[] , int goal) {
        return helper(arr, goal) - helper(arr, goal-1);
    }
    public static int helper(int arr[] , int goal) {
        if(goal < 0) {
            return 0;
        }
        int r = 0;
        int l = 0;
        int n = arr.length;
        int count = 0;
        int sum = 0;

        while(r<n) {
            sum = sum + arr[r];
            while(sum > goal){
                sum = sum - arr[l];
                l++;
            }
            count = count + (r-l+1);
            r++;
        }
        return count;
    }
    public static void main (String args[]) {
        int arr [] = {1,0,0,1,1,0};
        int goal = 2;
        System.out.println(Solution(arr, goal));
    }
}
