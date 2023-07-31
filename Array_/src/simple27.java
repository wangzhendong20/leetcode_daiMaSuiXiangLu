public class simple27 {
    public int removeElement(int[] nums, int val) {
        int slow = 0;
        int fast = 0;
        for (fast = 0; fast < nums.length; fast++) {
            if (nums[fast] != val){
                nums[slow++] = nums[fast];
            }
        }

        return slow;
    }
}
