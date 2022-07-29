class Pair {
    int time;
    int price;

    Pair(int time, int price) {
        this.time = time;
        this.price = price;
    }
}

class StockPrice {
    PriorityQueue<Pair> max;
    PriorityQueue<Pair> min;
    HashMap<Integer, Integer> map;
    Pair curr;

    public StockPrice() {
        max = new PriorityQueue<>((a, b) -> b.price - a.price);
        min = new PriorityQueue<>((a, b) -> a.price - b.price);
        map = new HashMap<>();
        curr = new Pair(0, 0);
    }

    public void update(int timestamp, int price) {
        if (timestamp >= curr.time) {
            curr.time = timestamp;
            curr.price = price;
        }

        Pair temp = new Pair(timestamp, price);

        max.add(temp);
        min.add(temp);
        map.put(timestamp, price);
    }

    public int current() {
        return curr.price;
    }

    public int maximum() {
        while (true) {
            if (max.peek().price != map.get(max.peek().time)) {
                max.poll();
            } else {
                break;
            }
        }

        return max.peek().price;
    }

    public int minimum() {

        while (true) {
            if (min.peek().price != map.get(min.peek().time)) {
                min.poll();
            } else {
                break;
            }
        }

        return min.peek().price;
    }
}
