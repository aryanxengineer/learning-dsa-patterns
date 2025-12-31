package twopointerpatterns;

public class SortedSquare {

    public static int[] sortedSquares(int[] nums) {

        // lets find the count of negative and positive

        int n = nums.length, i = 0, pos = 0, neg = 0, j = 0;

        for (i = 0; i < n; i++) {
            if (nums[i] > 0)
                pos++;
            if (nums[i] < 0)
                neg++;
        }

        // Square of all elements
        for (i = 0; i < n; i++) {
            nums[i] = nums[i] * nums[i];
        }

        // all are positive
        if (neg == 0) {
            return nums;
        }

        // all are negative
        i = 0;
        if (pos == 0) {
            j = n - 1;
            while (i < j) {
                int temp = nums[i];
                nums[i++] = nums[j];
                nums[j--] = temp;
            }
            return nums;
        }

        // negative and positive
        int[] newArr = new int[n];
        i = neg - 1;
        j = neg;
        pos = 0;
        while(i >= 0 && j < n) {
            if(nums[i] <= nums[j]) {
                newArr[pos++] = nums[i--];
            }
            else {
                newArr[pos++] = nums[j++];
            }
        }

        // if i exhausted
        while(j < n && pos < n) {
            newArr[pos++] = nums[j++];
        }

        // if j exhausted
        while(i >= 0 && pos < n) {
            newArr[pos++] = nums[i--];
        }

        return newArr;

    }

    public static void main(String[] args) {
        int[] arr = { -4, -1, 0, 3, 10 };
        sortedSquares(arr);

    }
}
