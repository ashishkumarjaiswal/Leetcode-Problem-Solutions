class Solution {
    HashSet<String> set = new HashSet<>();
    String ans = "";

    public String findDifferentBinaryString(String[] nums) {
        int n = nums[0].length();

        for (String s : nums) {
            set.add(s);
        }

        fun(n, "");

        return ans;
    }

    void fun(int n, String curr) {
        if (curr.length() == n) {
            if (!set.contains(curr))
                ans = curr;

            return;
        }

        if (ans.length() > 0)
            return;

        fun(n, curr + "0");

        if (ans.length() > 0)
            return;

        fun(n, curr + "1");
    }
}
