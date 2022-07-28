class Solution {
    public List<String> alertNames(String[] keyName, String[] keyTime) {
        List<String> ans = new ArrayList<>();
        HashMap<String, List<Integer>> map = new HashMap<>();
        int n = keyName.length;

        for (int i = 0; i < n; i++) {
            String name = keyName[i];
            int time = Integer.parseInt(keyTime[i].substring(0, 2)) * 60 + Integer.parseInt(keyTime[i].substring(3));

            if (!map.containsKey(name)) {
                map.put(name, new ArrayList<>());
            }

            map.get(name).add(time);
        }

        for (String name : map.keySet()) {
            List<Integer> list = map.get(name);

            if (list.size() > 2) {
                Collections.sort(list);

                for (int i = 2; i < list.size(); i++) {
                    if (list.get(i) - list.get(i - 2) <= 60) {
                        ans.add(name);
                        break;
                    }
                }
            }
        }

        Collections.sort(ans);

        return ans;
    }
}
