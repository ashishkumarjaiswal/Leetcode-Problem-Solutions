//Using Two Pointers
class Solution {
    public int removeDuplicates(int[] nums) {
        int start, count;
        count = start = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                if (count < 2)
                    count++;
                else
                    continue;
            } else {
                count = 1;
            }
            nums[start] = nums[i];
            start++;
        }
        return start;
    }
}


//Using TreeMap
class Solution {
    public int removeDuplicates(int[] nums) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        int index = 0;
        for (int i : map.keySet()) {
            int run = map.get(i);
            int count = 0;
            while (run > 0 && count != 2) {
                nums[index++] = i;
                count++;
                run--;
            }
        }
        return index;
    }
}
