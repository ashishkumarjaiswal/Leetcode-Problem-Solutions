class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < groupSizes.length; i++) {
            if (map.containsKey(groupSizes[i])) {
                map.get(groupSizes[i]).add(i);
            } else {
                map.put(groupSizes[i], new ArrayList<>());
                map.get(groupSizes[i]).add(i);
            }
        }
        System.out.println(map);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>(map.keySet());
        for (int i = 0; i < temp.size(); i++) {
        List<Integer> a = map.get(temp.get(i));
        int x = 0;
        while (x < a.size()) {
        List<Integer> add = new ArrayList<>();
        int y = 0;
        while (y < temp.get(i)) {
        add.add(a.get(x));
        x++;
        y++;
        }
        ans.add(add);
        }
        }
        return ans;
    }
}
