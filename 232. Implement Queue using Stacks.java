class MyQueue {
    Stack<Integer> main;
    Stack<Integer> temp;

    public MyQueue() {
        main = new Stack<>();
        temp = new Stack<>();
    }

    public void push(int x) {
        while (!temp.isEmpty()) {
            main.push(temp.pop());
        }
        main.push(x);
        while (!main.isEmpty()) {
            temp.push(main.pop());
        }
    }

    public int pop() {
        return temp.pop();
    }

    public int peek() {
        return temp.peek();
    }

    public boolean empty() {
        return temp.size() == 0;
    }
}
