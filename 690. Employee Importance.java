class Solution {
    HashMap<Integer, Employee> map = new HashMap<>();
    HashSet<Integer> set = new HashSet<>();
    int ans = 0;

    public int getImportance(List<Employee> employees, int id) {

        for (Employee e : employees) {
            int ids = e.id;
            map.put(ids, e);
        }

        recursion(id);

        return ans;
    }

    void recursion(int id) {
        if (set.contains(id))
            return;

        set.add(id);
        ans = ans + map.get(id).importance;

        List<Integer> list = map.get(id).subordinates;

        for (Integer i : list) {
            recursion(i);
        }
    }
}
