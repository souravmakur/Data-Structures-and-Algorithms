import java.util.ArrayList;

public class FirstAndLastOccurence {
    public static int [] SolutionBrute(int arr[] , int target) {
        int first = -1;
        int last = -1;
        int ans [] = new int [2];
        for(int i=0; i<arr.length; i++) {
            if(arr[i] == target) {
                if(first == -1) {
                    first = i;
                }
                last = i;
            }
        }
        ans[0] = first;
        ans[1] = last;
        return ans;
    }
    public static int lowerBound (int arr[] , int target) {
        int ans = arr.length;
        int n = arr.length;
        int low = 0;
        int high = n-1;

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
    public static int upperBound (int arr[] , int target) {
        int ans = arr.length;
        int n = arr.length;
        int low = 0;
        int high = n-1;

        while(low <= high) {
            int mid = (low + high) / 2;
            if(arr[mid] > target) {
                ans = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return ans;
    }
    public static int[] SolutionBetter(int arr[] , int target) {
        int lb = lowerBound(arr, target);
        if (lb == arr.length || arr[lb] != target) {
            return new int[]{-1, -1};
        }
        int ub = upperBound(arr, target);
        return new int[]{lb, ub - 1};
    }
    public static int firstOccurence(int nums[] , int target) {
        int low = 0;
        int high = nums.length-1;
        int ans = -1;

        while(low <= high) {
            int mid = (low + high) / 2;
            if(nums[mid] == target) {
                ans = mid;
                high = mid-1;
            }else if (nums[mid] < target) {
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return ans;
    }
    public static int lastOccurence(int nums[] , int target) {
        int low = 0;
        int high = nums.length-1;
        int ans = -1;

        while(low <= high) {
            int mid = (low + high) / 2;
            if(nums[mid] == target) {
                ans = mid;
                low = mid + 1;
            }else if (nums[mid] > target) {
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return ans;
    }
    public static int[] SolutionOptimal(int nums[] , int target) {
        int arr[] = new int [2];
        int first = firstOccurence(nums, target);
        int last = lastOccurence(nums, target);
        arr[0] = first;
        arr[1] = last;
        return arr;
    }
    public static void main (String args []) {
        int arr[] = {2,4,6,8,8,8,11,13};
        int target = 8;
        int ans[] = new int [2];
        // ans = SolutionBrute(arr, target);
        ans = SolutionOptimal(arr, target);
        for(int i=0; i<ans.length;i++) {
            System.out.print(ans[i]+", ");
        }
    }
}
