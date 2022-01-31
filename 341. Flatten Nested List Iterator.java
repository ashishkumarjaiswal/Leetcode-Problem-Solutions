public class NestedIterator implements Iterator<Integer> {
    int index = 0;
    List<Integer> ans = new ArrayList<>();

    void fun(List<NestedInteger> nestedList) {

        for (NestedInteger n : nestedList) {
            if (n.isInteger()) {
                ans.add(n.getInteger());
            } else {
                fun(n.getList());
            }
        }
    }

    public NestedIterator(List<NestedInteger> nestedList) {
        for (NestedInteger n : nestedList) {
            if (n.isInteger()) {
                ans.add(n.getInteger());
            } else
                fun(n.getList());
        }
    }

    @Override
    public Integer next() {
        int a = -1;
        if (index < ans.size()) {
            a = ans.get(index);
            index++;
        }
        return a;
    }

    @Override
    public boolean hasNext() {
        if (index < ans.size())
            return true;
        return false;
    }
}
