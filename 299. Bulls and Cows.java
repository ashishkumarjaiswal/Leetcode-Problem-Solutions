class Solution {
    public String getHint(String secret, String guess) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int cow = 0, bull = 0;
        StringBuilder s=new StringBuilder();

        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                bull++;
                continue;
            }
            s=s.append(guess.charAt(i));
            int x = secret.charAt(i) - '0';
            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        for (int i = 0; i < s.length(); i++) {
            int x = s.charAt(i) - '0';

            if (map.containsKey(x)) {
                cow++;
                if (map.get(x) == 1)
                    map.remove(x);
                else
                    map.put(x, map.get(x) - 1);
            }

        }
        return bull + "A" + cow + "B";
    }
}
