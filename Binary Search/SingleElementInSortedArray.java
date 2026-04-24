public class SingleElementInSortedArray {

    public static int SolutionBrute(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            if (i == 0) {
                if (arr[i] != arr[i + 1]) {
                    return arr[i];
                }
            } else if (i == arr.length - 1) {
                if (arr[i] != arr[i - 1]) {
                    return arr[i];
                }
            } else {
                if (arr[i] != arr[i + 1] && arr[i] != arr[i - 1]) {
                    return arr[i];
                }
            }
        }
        return -1;
    }

    public static int SolutionOptimal(int arr[]) {
        int low = 1;                  // start from 1
        int high = arr.length - 2;   // end at second last

        if (arr.length == 1) {
            return arr[0];
        }
        if (arr[0] != arr[1]) {
            return arr[0];
        }

        // ✅ Bug 1 Fixed: arr[arr.length - 1] instead of arr[arr.length] - 1
        if (arr[arr.length - 1] != arr[arr.length - 2]) {
            return arr[arr.length - 1];
        }

        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] != arr[mid + 1] && arr[mid] != arr[mid - 1]) {
                return arr[mid];
            }

            // ✅ Bug 2 Fixed: mid % 2 instead of arr[mid] % 2
            if ((mid % 2 == 1 && arr[mid] == arr[mid - 1]) ||
                (mid % 2 == 0 && arr[mid] == arr[mid + 1])) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String args[]) {
        int arr[] = {1, 1, 2, 2, 3, 3, 4, 5, 5, 6, 6};
        System.out.println("Brute:   " + SolutionBrute(arr));
        System.out.println("Optimal: " + SolutionOptimal(arr));
    }
}