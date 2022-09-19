class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        List<List<String>> ans = new ArrayList<>();
        HashMap<String, List<String>> map = new HashMap<>();

        for (String path : paths) {
            String[] arr = path.split(" ");
            String root = arr[0];

            for (int i = 1; i < arr.length; i++) {
                String s = arr[i];
                String fileContent = s.substring(s.indexOf('(') + 1, s.indexOf(')'));

                if (!map.containsKey(fileContent)) {
                    map.put(fileContent, new ArrayList<>());
                }

                map.get(fileContent).add(root + "/" + s.substring(0, s.indexOf("(")));
            }
        }

        for (String key : map.keySet()) {
            if (map.get(key).size() > 1) {
                ans.add(map.get(key));
            }
        }

        return ans;
    }
}
