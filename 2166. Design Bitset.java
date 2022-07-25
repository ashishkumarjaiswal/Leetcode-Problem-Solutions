class Bitset {
    int[] arr;
    HashSet<Integer> set;
    int count = 0;

    public Bitset(int size) {
        arr = new int[size];
        set = new HashSet<>();
    }

    public void fix(int idx) {
        if (count % 2 == 0) {
            arr[idx] = 1;
            set.add(idx);
        } else {
            arr[idx] = 0;
            set.remove(idx);
        }
    }

    public void unfix(int idx) {
        if (count % 2 == 0) {
            arr[idx] = 0;
            set.remove(idx);
        } else {
            arr[idx] = 1;
            set.add(idx);
        }
    }

    public void flip() {
        count++;
    }

    public boolean all() {
        if (count % 2 == 0)
            return set.size() == arr.length;

        return set.size() == 0;
    }

    public boolean one() {
        if (count % 2 == 0)
            return set.size() > 0;

        return set.size() != arr.length;
    }

    public int count() {
        if (count % 2 == 0)
            return set.size();

        return arr.length - set.size();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();

        if (count % 2 == 0) {
            for (int i = 0; i < arr.length; i++) {
                sb.append(arr[i]);
            }
        } else {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == 0)
                    sb.append('1');
                else {
                    sb.append('0');
                }
            }
        }

        return sb.toString();
    }
}
