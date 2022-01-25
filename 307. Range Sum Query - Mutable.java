class NumArray {

    int[] tree;
    int arr[];

    public NumArray(int[] nums) {
        arr = nums;
        tree = new int[nums.length * 4];
        build(1, 0, arr.length - 1);
    }

    void build(int node, int start, int end) {
        if (start == end) {
            tree[node] = arr[start];
        } else {
            int mid = (start + end) / 2;
            build(node * 2, start, mid);
            build(node * 2 + 1, mid + 1, end);
            tree[node] = tree[node * 2] + tree[node * 2 + 1];
        }
    }

    public void update(int index, int val) {
        update(index, val, 1, 0, arr.length - 1);
    }

    void update(int index, int val, int node, int start, int end) {
        if (start == end) {
            tree[node] = val;
            arr[start] = val;
        } else {
            int mid = (start + end) / 2;
            if (index <= mid && index >= start) {
                update(index, val, node * 2, start, mid);
            } else {
                update(index, val, node * 2 + 1, mid + 1, end);
            }
            tree[node] = tree[node * 2] + tree[node * 2 + 1];
        }
    }

    public int sumRange(int left, int right) {
        return sumRange(left, right, 0, arr.length - 1, 1);
    }

    int sumRange(int left, int right, int start, int end, int node) {
        if (start > right || end < left)
            return 0;
        if (start == end) {
            return tree[node];
        } else if (start >= left && end <= right) {
            return tree[node];
        } else {
            int mid = (start + end) / 2;
            int a = sumRange(left, right, start, mid, node * 2);
            int b = sumRange(left, right, mid + 1, end, node * 2 + 1);
            return a + b;
        }
    }
}
