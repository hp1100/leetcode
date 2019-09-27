public class Codec {
    Map<Integer, String> map = new HashMap<>();
    Random r = new Random();
    int key = r.nextInt(10000);
    
    public String encode(String longUrl) {
        while(map.containsKey(key))
            key = r.nextInt(10000);
        map.put(key,longUrl);
        return "http://tinyurl.com/" + key;
    }
    public String decode(String shortUrl) {
        return map.get(Integer.parseInt(shortUrl.replace("http://tinyurl.com/", "")));
    }
}
