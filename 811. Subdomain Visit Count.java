class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        List<String> ans = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < cpdomains.length; i++) {
            String s = cpdomains[i];
            String[] arr = s.split(" ");
            String[] subArr = arr[1].split("\\.");

            String put = "";
            for (int j = subArr.length - 1; j >= 0; j--) {
                put = subArr[j] + put;
                map.put(put, map.getOrDefault(put, 0) + Integer.parseInt(arr[0]));
                put = "." + put;
            }
        }

        for (String s : map.keySet()) {
            String ashish = "";
            ashish = ashish + map.get(s) + " " + s;
            ans.add(ashish);
        }
        return ans;
    }
}
