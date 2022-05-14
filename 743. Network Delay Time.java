import java.util.*;

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int[] arr = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            arr[i] = Integer.MAX_VALUE;
        }

        Map<Integer, List<int[]>> map = new HashMap<>();

        for (int[] is : times) {
            if (!map.containsKey(is[0]))
                map.put(is[0], new LinkedList<>());

            map.get(is[0]).add(new int[] { is[1], is[2] });
        }

        Queue<int[]> q = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        arr[k] = 0;
        q.add(new int[] { k, 0 });

        while (!q.isEmpty()) {
            int[] temp = q.poll();
            int key = temp[0];
            int weight = temp[1];

            if (map.containsKey(key)) {
                List<int[]> l = map.get(key);
                map.remove(key);

                for (int i = 0; i < l.size(); i++) {
                    int x[] = l.get(i);
                    int index = x[0];
                    int w = x[1];
                    int nw = weight + w;

                    if (nw < arr[index]) {
                        int[] a = { index, nw };
                        arr[index] = nw;
                        q.add(a);
                    }
                }
            }
        }

        int max = 0;

        for (int i = 1; i <= n; i++) {
            max = Math.max(max, arr[i]);
            System.out.print(arr[i] + " ");
        }

        return max == Integer.MAX_VALUE ? -1 : max;
    }
}
