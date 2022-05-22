class Solution {
    public boolean circularArrayLoop(int[] nums) {
        if (nums.length <= 1)
            return false;

        for (int i = 0; i < nums.length; i++) {
            int slow = i;
            int fast = i;
            boolean direction = nums[i] > 0;

            while (true) {
                slow = fun(nums, direction, slow);
                if (slow == -1)
                    break;

                fast = fun(nums, direction, fast);
                if (fast == -1)
                    break;

                fast = fun(nums, direction, fast);
                if (fast == -1)
                    break;

                if (slow == fast)
                    return true;

            }
        }

        return false;
    }

    int fun(int[] nums, boolean direction, int index) {
        int newIndex = (nums[index] + index) % nums.length;

        if (newIndex < 0) {
            newIndex = nums.length + newIndex;
        }

        boolean newDirection = nums[index] > 0;

        if (newIndex == index || newDirection != direction)
            return -1;

        return newIndex;
    }
}
