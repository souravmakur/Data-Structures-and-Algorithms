public class SingleElementInSortedArray {
    public static int SolutionBrute (int arr []) {
        for(int i=0; i<arr.length; i++) {
            if(i == 0) {
                if(arr[i] != arr[i+1]) {
                    return arr[i];
                }
            }else if(i == arr.length - 1) {
                if(arr[i] != arr[i-1]) {
                    return arr[i];
                }
            }else {
                if(arr[i] != arr[i+1] && arr[i] != arr[i-1]) {
                    return arr[i];
                }
            }
        }
        return -1;
    }
    public static void main (String args []) {
        int arr [] = {1,1,2,2,3,3,4,5,5,6,6};
        System.out.println(SolutionBrute(arr));
    }
}
