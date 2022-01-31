//using greedy approach(Faster)
class Solution {
    public boolean increasingTriplet(int[] nums) {
        int min = Integer.MAX_VALUE, secMin = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= min) {
                min = nums[i];
            } else if (secMin > nums[i]) {
                secMin = nums[i];
            }else if (secMin < nums[i])
                return true;
        }
        return false;
    }
}


//using stack next greater element(Slow)
class Solution {
    public boolean increasingTriplet(int[] nums) {
        if (nums.length < 3)
            return false;
        boolean[] leftToRight = new boolean[nums.length];
        boolean[] rightToLeft = new boolean[nums.length];
        Stack<Integer> st = new Stack<>();
        st.push(nums[0]);
        for (int i = 1; i < rightToLeft.length; i++) {
            while (!st.isEmpty() && st.peek() >= nums[i]) {
                st.pop();
            }
            if (st.isEmpty())
                leftToRight[i] = false;
            else
                leftToRight[i] = true;
            st.push(nums[i]);
        }
        st = new Stack<>();
        st.push(nums[nums.length - 1]);
        for (int i = nums.length - 2; i >= 0; i--) {
            while (!st.isEmpty() && st.peek() <= nums[i]) {
                st.pop();
            }
            if (st.isEmpty())
                rightToLeft[i] = false;
            else
                rightToLeft[i] = true;
            st.push(nums[i]);
        }
        for (int i = 1; i < rightToLeft.length - 1; i++) {
            if (leftToRight[i] && rightToLeft[i])
                return true;
        }
        return false;
    }
}
