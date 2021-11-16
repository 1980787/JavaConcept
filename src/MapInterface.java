import java.util.*;

public class MapInterface {

    public static void main(String args[]) {
        // HashMap internally work
        // Initial Capacity size of bucket array.
        // The default initial capacity of HashMap is 16 (i.e. the number of buckets).
        // It is always expressed in the power of 2 (2, 4, 8, 16, etc) reaching maximum of 1 << 30 (2^30).
        Map<String,String> map1 = new HashMap<>(10);// set initial capacity

        // Load Factor determine when the size of Bucket array requires to be increased. By default, it is 0.75.
        // When the number of nodes in the HashMap is more than 75% of total capacity, HashMap grows its bucket array size.
        // The capacity of HashMap always doubled each time when HashMap needs to be increased its bucket array size.
        Map<String,String> map2 = new HashMap<>(10, 0.7f);// set capacity, load factor

        // Rehashing
        // Threshold = LoadFactor * Available Capacity = 0.75 * 16 = 12
        // When 13th key-value pair is inserted into the HashMap,
        // HashMap grows its bucket array size to 16 * 2 = 32
        // next Threshold = LoadFactor * Available Capacity = 0.75 * 32 = 24
        // and so on

        // Index = key.hashCode() & (capacity -1);

        // 1. HashMap
        // quick insertion, search and deletion
        Map<String, Integer> hashMap = new HashMap<>();
        hashMap.put("small", 10);
        hashMap.put("longest", 30);
        hashMap.put("middle", 20);
        System.out.println("Print examples of hashMap:");
        printMap(hashMap);
        System.out.println("small".hashCode() & (16 -1));
        System.out.println("longest".hashCode() & (16 -1));
        System.out.println("middle".hashCode() & (16 -1));

        // 2. LinkedHashMap
        // insertion order
        Map<String, Integer> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("small", 10);
        linkedHashMap.put("longest", 30);
        linkedHashMap.put("middle", 20);
        System.out.println("Print examples of LinkedHashMap:");
        printMap(linkedHashMap);

        // 3. TreeMap
        // storing the key-value pairs
        Map<String, Integer> treeMap = new TreeMap<>();
        treeMap.put("small", 10);
        treeMap.put("longest", 30);
        treeMap.put("middle", 20);
        System.out.println("Print examples of TreeMap:");
        printMap(treeMap);

        System.out.println();
        System.out.println("Print by Iterator");
        // Iterator with keySet() only key set
        //               entrySet() key-value pair set
        Iterator hashMapIterator = hashMap.keySet().iterator();
        Iterator hashMapIterator2 = hashMap.entrySet().iterator();
        printByIterator(hashMapIterator); // small longest middle - only key
        printByIterator(hashMapIterator2); // small=10 longest=30 middle=20 - key-value pair
        Iterator linkedHashMapIterator = linkedHashMap.keySet().iterator();
        Iterator linkedHashMapIterator2 = linkedHashMap.entrySet().iterator();
        printByIterator(linkedHashMapIterator); // small longest middle
        printByIterator(linkedHashMapIterator2); // small=10 longest=30 middle=20
        Iterator treeMapIterator = treeMap.keySet().iterator();
        Iterator treeMapIterator2 = treeMap.entrySet().iterator();
        printByIterator(treeMapIterator); // longest middle small
        printByIterator(treeMapIterator2); // longest=30 middle=20 small=10
    }

    // Helper method that prints the map that pair of key and value
    public static void printMap(Map<String, Integer> map) {
//        for (Map.Entry<String, Integer> e : map.entrySet()) {
//            System.out.println(e.getKey() + " " + e.getValue());
//        }
//        System.out.println();
        map.forEach((key, value) -> {
           System.out.print(key + " " + value);
           System.out.println();
        });
    }

    public static void printByIterator (Iterator it) {
        while(it.hasNext()) {
            System.out.print(it.next() + " ");
        }
        System.out.println();
    }
}
