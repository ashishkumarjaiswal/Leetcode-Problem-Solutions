class MedianFinder {
    PriorityQueue<Integer> min;
    PriorityQueue<Integer> max;

    public MedianFinder() {
        min = new PriorityQueue<>(Collections.reverseOrder());
        max = new PriorityQueue<>();
    }

    public void addNum(int num) {
        if (min.isEmpty() || max.isEmpty()) {
            min.add(num);
        } else if (max.peek() < num)
            max.add(num);
        else
            min.add(num);
        if (Math.abs(min.size() - max.size()) > 1) {
            if (min.size() > max.size()) {
                int x = min.poll();
                max.add(x);
            } else {
                int x = max.poll();
                min.add(x);
            }
        }

    }

    public double findMedian() {
        if (max.size() == min.size()) {
            return (max.peek() + min.peek()) / 2.0;
        } else if (max.size() > min.size())
            return max.peek();
        else
            return min.peek();
    }
}
