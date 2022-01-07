class Solution {
    int[] nums;
    Random rand = new Random();

    public Solution(ListNode head) {
        List<Integer> arr = new ArrayList<>();
        while (head != null) {
            arr.add(head.val);
            head = head.next;
        }
        nums = new int[arr.size()];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = arr.get(i);

        }
    }

    public int getRandom() {
        return nums[rand.nextInt(nums.length)];
    }
}
