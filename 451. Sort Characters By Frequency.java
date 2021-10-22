//Optimize Way
class Solution {
    public String frequencySort(String s) {
        int freq[][] = new int[123][2];
        for (int i = 0; i < 123; i++)
            freq[i][0] = i;

        for (int i = 0; i < s.length(); i++) {
            freq[(s.charAt(i))][1]++;
        }

        Arrays.sort(freq, (a, b) -> b[1] - a[1]);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < freq.length; i++) {
            if (freq[i][1] == 0)
                break;
            for (int j = 0; j < freq[i][1]; j++)
                sb.append((char) freq[i][0]);

        }
        return sb.toString();
    }
}




//By HashMap
class Solution {
    public String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        List<Character> list = new ArrayList<>(map.keySet());
        Collections.sort(list, (a, b) -> map.get(b) - map.get(a));
        String ans = "";
        for (char c : list) {
            for (int i = 0; i < map.get(c); i++) {
                ans = ans + c;
            }
        }
        return ans;
    }
}
