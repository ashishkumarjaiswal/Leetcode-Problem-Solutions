class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> ans = new ArrayList<>();
        int x = 0;
        for (int i = 1; i <= target[target.length - 1]; i++) {
            if (target[x] == i) {
                ans.add("Push");
                x++;
            } else {
                ans.add("Push");
                ans.add("Pop");
            }
        }
        return ans;
    }
}
