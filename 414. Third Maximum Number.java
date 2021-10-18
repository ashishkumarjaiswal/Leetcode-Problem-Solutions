//By Priority Queue
class Solution {
    public int thirdMax(int[] nums) {
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < nums.length; i++) {
            q.add(nums[i]);
        }
        int max = q.poll();
        int ans = max;
        int k = 3;
        k--;
        while (k > 0) {
            if (q.size() == 0) {
                return ans;
            }
            int x = q.poll();
            if (x == max)
                continue;
            max = x;
            k--;
        }
        return max;
    }
}

