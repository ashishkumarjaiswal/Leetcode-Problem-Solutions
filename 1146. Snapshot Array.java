class SnapshotArray {
    TreeMap<Integer, Integer>[] map;
    int id = 0;

    public SnapshotArray(int length) {
        map = new TreeMap[length];

        for (int i = 0; i < length; i++) {
            map[i] = new TreeMap<>();
            map[i].put(0, 0);
        }
    }

    public void set(int index, int val) {
        map[index].put(id, val);
    }

    public int snap() {
        return id++;
    }

    public int get(int index, int snap_id) {
        return map[index].floorEntry(snap_id).getValue();
    }
}
