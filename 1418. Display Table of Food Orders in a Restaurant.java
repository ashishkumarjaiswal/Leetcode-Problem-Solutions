import java.util.*;

class Solution {
    public List<List<String>> displayTable(List<List<String>> orders) {
        List<List<String>> ans = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();

        for (List<String> list : orders) {
            map.put(list.get(2), 1);
        }

        List<String> list = new ArrayList<>(map.keySet());
        Collections.sort(list);
        map = new HashMap<>();
        List<String> toAdd = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            map.put(list.get(i), i);
            toAdd.add("0");
        }

        list.add(0, "Table");

        HashMap<Integer, List<String>> table = new HashMap<>();

        for (List<String> l : orders) {
            int tableNumber = Integer.parseInt(l.get(1));

            if (!table.containsKey(tableNumber)) {
                table.put(tableNumber, new ArrayList<>(toAdd));
            }

            String item = l.get(2);
            int itemIndex = map.get(item);
            int prev = Integer.parseInt(table.get(tableNumber).get(itemIndex)) + 1;
            table.get(tableNumber).set(itemIndex, prev + "");

        }

        ans.add(list);
        List<Integer> t = new ArrayList<>(table.keySet());
        Collections.sort(t);

        for (int i : t) {
            List<String> temp = new ArrayList<>();
            temp.add(i + "");
            temp.addAll(table.get(i));
            ans.add(temp);
        }

        return ans;
    }
}
