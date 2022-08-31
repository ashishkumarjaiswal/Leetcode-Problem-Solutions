class CustomStack {
    int[] arr;
    int count = -1;

    public CustomStack(int maxSize) {
        arr = new int[maxSize];
    }

    public void push(int x) {
        if (count + 1 >= arr.length) {
            return;
        }

        count++;

        if (count < arr.length) {
            arr[count] = x;
        }
    }

    public int pop() {
        if (count < 0)
            return -1;

        int x = arr[count];
        count--;
        return x;
    }

    public void increment(int k, int val) {
        for (int i = 0; i < k && i < arr.length; i++) {
            arr[i] += val;
        }
    }
}
