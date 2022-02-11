class Solution {
    public int[] arrayRankTransform(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] temp = arr.clone();
        Arrays.sort(temp);
        int count = 1;

        for (int i = 0; i < temp.length; i++) {
            if (!map.containsKey(temp[i])) {
                map.put(temp[i], count++);
            }
        }

        int[] ans = new int[arr.length];

        for (int i = 0; i < ans.length; i++) {
            ans[i] = map.get(arr[i]);
        }

        return ans;
    }
}
