import java.util.*;

class GfG {
    // Returns LIS of subarray ending with index i.
    static int lisEndAtI(int[] arr, int i) {
        // Base case
        if (i == 0)
            return 1;

        // Consider all elements on left of i,
        // recursively compute LISs ending with 
        // them and consider the largest
        int mx = 1;
        for (int prev = 0; prev < i; prev++)
            if (arr[prev] < arr[i])
                mx = Math.max(mx, lisEndAtI(arr, prev) + 1);
        return mx;
    }

    static int lis(int[] arr) {
        int n = arr.length;
        int res = 1;
        for (int i = 1; i < n; i++)
            res = Math.max(res, lisEndAtI(arr, i));
        return res;
    }

    // Driver program to test above function
    public static void main(String[] args) {
        int[] arr = {10, 22, 9, 33, 21, 50, 41, 60};

        // Function call
        System.out.println("Length of lis is " + lis(arr));
    }
}
