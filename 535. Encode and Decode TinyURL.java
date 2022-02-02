public class Codec {

    int num = 0;
    HashMap<String, String> map = new HashMap<>();

    public String encode(String longUrl) {
        num++;
        String s = num + "";
        map.put(s, longUrl);
        return s;
    }

    public String decode(String shortUrl) {
        return map.get(shortUrl);
    }
}
