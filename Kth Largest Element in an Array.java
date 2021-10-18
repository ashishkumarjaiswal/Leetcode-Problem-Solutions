//By Sorting
class Solution {
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        return nums[n - k];
    }
}

//By Priority Queue
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < nums.length; i++) {
            q.add(nums[i]);
        }
        int max = 0;
        while (k-- > 0) {
            max = q.poll();
        }
        return max;
    }
}
