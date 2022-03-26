class MyCircularQueue {
    int start, end, size;
    int[] list;

    public MyCircularQueue(int k) {
        list = new int[k];
        start = -1;
        end = -1;
        size = k;
    }

    public boolean enQueue(int value) {
        if (isFull())
            return false;
        if (isEmpty())
            start = end = 0;
        else
            end = (end + 1) % size;
        list[end] = value;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty())
            return false;
        if (start == end) {
            start = end = -1;
        } else
            start = (start + 1) % size;

        return true;
    }

    public int Front() {
        if (isEmpty())
            return -1;
        return list[start];
    }

    public int Rear() {
        if (isEmpty())
            return -1;
        return list[end];
    }

    public boolean isEmpty() {
        if (start == -1 && end == -1)
            return true;
        return false;
    }

    public boolean isFull() {
        return start == ((end + 1) % size);
    }
}
