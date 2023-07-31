public class simple26 {
    public int removeDuplicates(int[] nums) {
        int slow = 0;
        for (int fast = 1; fast < nums.length; fast++) {
            if (nums[fast] != nums[fast - 1]){
                nums[++slow] = nums[fast];
            }
        }

        return slow+1;
    }
}
