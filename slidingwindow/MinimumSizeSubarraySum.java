package slidingwindow;

public class MinimumSizeSubarraySum {
    public static int minSubArrayLen(int target, int[] nums) {
         int low = 0, high = 0, minLength = Integer.MAX_VALUE;
         int sum = 0;
         while (high < nums.length) {
            sum += nums[high];  // include high in the information

            while (sum >= target) {     //  
                minLength = Math.min(minLength, high - low++ + 1);
                sum -= nums[low - 1];
            }
            high++;
         }
         return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }

    public static void main(String[] args) {
        int[]  nums = { 2,3,1,2,4,3 };
        int minLength = minSubArrayLen(7, nums);
        System.out.println(minLength);
    }
}
