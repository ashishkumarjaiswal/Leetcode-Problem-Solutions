class SORTracker {
    TreeMap<Integer, List<String>> map;
    int count;

    public SORTracker() {
        map = new TreeMap<>((a, b) -> b - a);
        count = 0;
    }

    public void add(String name, int score) {
        map.putIfAbsent(score, new ArrayList<>());
        List<String> list = map.get(score);

        if (list.size() == 0) {
            list.add(name);
        } else {
            int x = fun(name, list);
            list.add(x, name);
        }

        map.put(score, list);
    }

    int fun(String name, List<String> list) {
        int lo = 0, hi = list.size() - 1;

        while (lo < hi) {
            int mid = (lo + hi) / 2;

            if (list.get(mid).compareTo(name) < 0) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }

        return list.get(lo).compareTo(name) >= 0 ? lo : lo + 1;
    }

    public String get() {
        int temp = count;
        String ans = "";

        for (int i : map.keySet()) {
            if (temp < map.get(i).size()) {
                ans = map.get(i).get(temp);
                break;
            } else {
                temp = temp - map.get(i).size();
            }
        }

        count++;
        return ans;
    }
}
