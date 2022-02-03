import java.util.*;

class UndergroundSystem {

    HashMap<Integer, String> map;
    HashMap<String, List<Integer>> avarage;

    public UndergroundSystem() {
        avarage = new HashMap<>();
        map = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        map.put(id, stationName + " " + t);
    }

    public void checkOut(int id, String stationName, int t) {
        String s = map.get(id);
        String[] arr = s.split(" ");
        String inStation = arr[0];
        int inTime = Integer.parseInt(arr[1]);
        String key = inStation + " " + stationName;

        if (!avarage.containsKey(key)) {
            avarage.put(key, new ArrayList<>());
        }
        int time = t - inTime;
        avarage.get(key).add(time);
    }

    public double getAverageTime(String startStation, String endStation) {
        String key = startStation + " " + endStation;
        List<Integer> list = new ArrayList<>(avarage.get(key));
        double aver = 0;
        for (int i = 0; i < list.size(); i++) {
            aver += list.get(i);
        }
        return aver / list.size();
    }
}
