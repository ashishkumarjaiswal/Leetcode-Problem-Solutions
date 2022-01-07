class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        List<Integer> ans = new ArrayList<>(map.values());
        Collections.sort(ans);
        for (int i = 1; i < ans.size(); i++) {
            if (ans.get(i - 1) == ans.get(i))
                return false;
        }
        return true;
    }
}
