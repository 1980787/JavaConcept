import java.util.*;

public class CollectionsFramework {
    // Arrays class
    // array cannot change size
    // access time fast with index
    // long time to add/delete data in the middle because have to copy and move other data to make an empty space.
    int[] arr = { 0, 1, 2, 3, 4};
    int[] arr2 = Arrays.copyOf(arr, arr.length);
    int[] arr3 = Arrays.copyOf(arr, 3);
    int[] arr4 = Arrays.copyOf(arr, 7);
    int[] arr5 = Arrays.copyOfRange(arr, 2, 4);
    int[] arr6 = Arrays.copyOfRange(arr, 0, 7);

    // Collection
    //                Map
    // List  Set

    // List ordered data, Allow duplicates
    //      ArrayList is faster than LinkedList when adding/deleting data in reverse order from the last data and access time. Stack
    //      LinkedList is faster than ArrayList when adding/deleting data in an intermediate location. Queue
    // Set out of ordered data, not allow duplicates
    //      HashSet
    //      LinkedHashSet; insertion order
    //      TreeSet; sorted by binary search that left node < root < right node
    // Map key and value pair data, out of ordered keys do not allow duplicates, values allow duplicates
    //      HashMap
    //      LinkedHashMap; insertion order
    //      TreeMap; sorted key-value pair
    public static void main(String[] args) {
        // ArrayList and LinkedList
        System.out.println("ArrayList");
        ArrayList arrList = new ArrayList();
        arrList.add(5);
        arrList.add(4);
        arrList.add(2);
        arrList.add(0);
        arrList.add(1);
        arrList.add(3);
        System.out.println(arrList); // [5, 4, 2, 0, 1, 3]
        System.out.println(arrList.size()); // 6
        arrList.add(1, 8);
        System.out.println(arrList); // [5, 8, 4, 2, 0, 1, 3]
        arrList.remove(1);
        System.out.println(arrList); // [5, 4, 2, 0, 1, 3]
        System.out.println(arrList.get(2)); // 2
        Collections.sort(arrList);
        System.out.println(arrList); // [0, 1, 2, 3, 4, 5]

        System.out.println();
        System.out.println("LinkedList");
        LinkedList linkedList = new LinkedList();
        linkedList.add(5);
        linkedList.add(4);
        linkedList.add(2);
        linkedList.add(0);
        linkedList.add(1);
        linkedList.add(3);
        System.out.println(linkedList); // [5, 4, 2, 0, 1, 3]
        System.out.println(linkedList.size()); // 6
        linkedList.add(1, 8);
        System.out.println(linkedList); // [5, 8, 4, 2, 0, 1, 3]
        linkedList.remove(1);
        System.out.println(linkedList); // [5, 4, 2, 0, 1, 3]
        System.out.println(linkedList.get(2)); // 2
        Collections.sort(linkedList);
        System.out.println(linkedList); // [0, 1, 2, 3, 4, 5]
        System.out.println();
        // Iterator
        Iterator arr = arrList.iterator();
        Iterator linked = linkedList.iterator();
        System.out.print("ArrayList iterator: ");
        while(arr.hasNext()) {
            System.out.print(arr.next());
        } // ArrayList iterator: 01234
        System.out.println();
        System.out.print("LinkedList iterator: ");
        while(linked.hasNext()) {
            System.out.print(linked.next());
        } // LinkedList iterator: 012345
    }
}
