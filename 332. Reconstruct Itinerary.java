class Solution {
    HashMap<String, PriorityQueue<String>> map;
    LinkedList<String> ans;

    public List<String> findItinerary(List<List<String>> tickets) {
        map = new HashMap<>();
        ans = new LinkedList<>();

        for (List<String> list : tickets) {
            String a = list.get(0);
            String b = list.get(1);

            if (!map.containsKey(a)) {
                map.put(a, new PriorityQueue<>());
            }

            map.get(a).add(b);
        }

        fun("JFK");

        return ans;
    }

    void fun(String start) {
        PriorityQueue<String> temp = map.get(start);

        while (temp != null && !temp.isEmpty()) {
            fun(temp.poll());
        }

        ans.addFirst(start);
    }
}
