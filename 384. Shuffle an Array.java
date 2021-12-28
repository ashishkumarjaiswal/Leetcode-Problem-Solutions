class Solution {
    int nums[];
    Random rand;

    public Solution(int[] nums) {
        this.nums = nums;
        rand = new Random();
    }

    public int[] reset() {
        return nums;
    }

    public int[] shuffle() {
        int[] arr = nums.clone();
        for (int i = nums.length - 1; i > 0; i--) {
            int x = rand.nextInt(i + 1);
            int temp = arr[x];
            arr[x] = arr[i];
            arr[i] = temp;
        }
        return arr;
    }
}
