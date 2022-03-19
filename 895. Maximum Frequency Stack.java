class FreqStack {
    HashMap<Integer, Stack<Integer>> map;
    HashMap<Integer, Integer> freq;
    int maxFreq;

    public FreqStack() {
        map = new HashMap<>();
        freq = new HashMap<>();
        maxFreq = 0;
    }

    public void push(int val) {
        int currFreq = freq.getOrDefault(val, 0);
        currFreq++;

        if (!map.containsKey(currFreq)) {
            map.put(currFreq, new Stack<>());
        }

        map.get(currFreq).push(val);
        freq.put(val, currFreq);
        maxFreq = Math.max(maxFreq, currFreq);
    }

    public int pop() {
        int ans = map.get(maxFreq).pop();
        int remain = freq.get(ans);

        freq.put(ans, remain - 1);

        if (map.get(maxFreq).isEmpty()) {
            maxFreq--;
        }

        return ans;
    }
}
