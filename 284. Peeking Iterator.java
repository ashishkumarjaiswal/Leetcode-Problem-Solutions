class PeekingIterator implements Iterator<Integer> {
    Integer next = null;
    Iterator<Integer> itr;

    public PeekingIterator(Iterator<Integer> iterator) {
        itr = iterator;
        if (itr.hasNext()) {
            next = itr.next();
        }
    }

    public Integer peek() {
        return next;
    }

    @Override
    public Integer next() {
        Integer res = next;
        next = itr.hasNext() ? itr.next() : null;
        return res;
    }

    @Override
    public boolean hasNext() {
        return next != null;
    }
}
