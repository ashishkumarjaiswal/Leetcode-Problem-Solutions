class Solution {
    HashMap<String, Long> map = new HashMap<>();
    int mod = 1000000007;

    public int countVowelPermutation(int n) {
        long ans = 0;

        ans = fun(n - 1, 'a') % mod;
        ans = (ans + fun(n - 1, 'e')) % mod;
        ans = (ans + fun(n - 1, 'i')) % mod;
        ans = (ans + fun(n - 1, 'o')) % mod;
        ans = (ans + fun(n - 1, 'u')) % mod;

        return (int) ans;
    }

    long fun(int size, char c) {
        if (size == 0)
            return 1;

        String key = size + " " + c;

        if (map.containsKey(key))
            return map.get(key);

        long total = 0;

        if (c == 'a') {
            total = fun(size - 1, 'e') % mod;
        } else if (c == 'e') {
            total = (fun(size - 1, 'i') + fun(size - 1, 'a')) % mod;
        } else if (c == 'i') {
            total = (fun(size - 1, 'a') + fun(size - 1, 'e') + fun(size - 1, 'o') + fun(size - 1, 'u')) % mod;
        } else if (c == 'o') {
            total = (fun(size - 1, 'i') + fun(size - 1, 'u')) % mod;
        } else {
            total = fun(size - 1, 'a') % mod;
        }

        map.put(key, total);
        return total;
    }
}
