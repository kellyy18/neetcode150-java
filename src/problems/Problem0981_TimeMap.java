package problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem0981_TimeMap {
    private final Map<String, List<Pair<Integer, String>>> keyStore;

    public Problem0981_TimeMap() {
        this.keyStore = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if (!keyStore.containsKey(key)) {
            keyStore.put(key, new ArrayList<>());
        }
        keyStore.get(key).add(new Pair(timestamp, value));
    }

    public String get(String key, int timestamp) {
        if (!keyStore.containsKey(key)) {
            return "";
        }

        List<Pair<Integer, String>> timestamps = keyStore.get(key);
        String res = "";

        int l = 0, r = timestamps.size() - 1;
        while (l <= r) {
            int m = (l + r) / 2;
            if (timestamps.get(m).getKey() <= timestamp) {
                res = timestamps.get(m).getValue();
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return res;
    }

    private static class Pair<K, V> {
        private final K key;
        private final V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }

    public static void main(String[] args) {
        Problem0981_TimeMap timeMap = new Problem0981_TimeMap();
        timeMap.set("foo", "bar", 1);
        System.out.println(timeMap.get("foo", 1)); // returns "bar"
        System.out.println(timeMap.get("foo", 3)); // returns "bar"
        timeMap.set("foo", "bar2", 4);
        System.out.println(timeMap.get("foo", 4)); // returns "bar2"
        System.out.println(timeMap.get("foo", 5)); // returns "bar2"
        timeMap.set("foo", "bar3", 6);
        System.out.println(timeMap.get("foo", 6)); // returns "bar3"
        System.out.println(timeMap.get("foo", 7)); // returns "bar3"
        System.out.println(timeMap.get("nonexistent", 1)); // returns ""
    }
}
