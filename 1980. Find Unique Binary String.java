//Using DFS

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

//Using BFS

class Solution {

    public String findDifferentBinaryString(String[] nums) {
        HashSet<String> set = new HashSet<>();
        int n = nums[0].length();

        for (String s : nums) {
            set.add(s);
        }

        Queue<String> q = new LinkedList<>();
        q.add("");

        while (!q.isEmpty()) {
            String s = q.poll();

            if (s.length() == n) {
                if (!set.contains(s)) {
                    return s;
                }

                continue;
            }

            q.add(s + "0");
            q.add(s + "1");
        }

        return "ashish";
    }
}
