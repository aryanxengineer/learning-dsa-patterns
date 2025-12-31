package twopointerpatterns;

public class RemoveDuplicate {

    public static int removeDuplicates(int[] nums) {
        int police = 0, neta = 1;
        while (police < nums.length && neta < nums.length) {
            if (nums[neta] == nums[neta - 1]) {
                neta++;
            } else {
                nums[++police] = nums[neta++];
            }
        }
        return police + 1;
    }

    public static void main(String[] args) {
        int[] arr = { 2, 2, 3, 3, 3, 7, 7, 7, 11, 15 };
        int distinctCount = removeDuplicates(arr);
        System.out.println(distinctCount);
    }
}
