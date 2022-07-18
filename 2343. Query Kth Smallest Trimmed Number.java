class Solution {
    class Pair {
        String s;
        int index;

        Pair(String s, int index) {
            this.s = s;
            this.index = index;
        }
    }

    public int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {
        HashMap<Integer, List<Pair>> map = new HashMap<>();

        for (int i = 0; i < queries.length; i++) {
            int last = nums[0].length() - queries[i][1];
            int index = queries[i][1];

            if (map.containsKey(index)) {
                continue;
            } else {
                map.put(index, new LinkedList<>());
            }

            for (int j = 0; j < nums.length; j++) {
                map.get(index).add(new Pair(nums[j].substring(last), j));
            }
        }

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int index = queries[i][0];
            int key = queries[i][1];

            List<Pair> list = map.get(key);

            Collections.sort(list, (a, b) -> a.s.equals(b.s) ? a.index - b.index : a.s.compareTo(b.s));

            ans[i] = list.get(index-1).index;
        }

        return ans;
    }
}
