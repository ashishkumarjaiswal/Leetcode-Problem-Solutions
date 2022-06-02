class Solution {
    int count = 0;
    boolean[] visited;

    public int countArrangement(int n) {
        visited = new boolean[n+1];
        fun(1, n);
        return count;
    }

    void fun(int index, int n) {
        if (index > n) {
            count++;
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (!visited[i] && (index % i == 0 || i % index == 0)) {
                visited[i] = true;
                fun(index + 1, n);
                visited[i] = false;
            }
        }
    }
}
