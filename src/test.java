import java.text.SimpleDateFormat;
import java.util.*;
/**
 * Created by xingyun on 15/8/18.
 */

class test {

    class subclass {
        int x;
        int y;
    }

    public boolean equals(Object o) {
        return false;
    }

    public int hashCode() {
        return 1;

    }

    public static void testBinarySearch() {
        int[] a = new int[]{3,2,4,6,1,5};
        Arrays.sort(a);
        System.out.println(Arrays.binarySearch(a, 3));

        List<Integer> l = new ArrayList<>();
        for(int num:a) {
            l.add(num);
        }

        System.out.println(Collections.binarySearch(l, 3));
    }

    public int reverseBits(int n) {
        int res = 0;
        for (int i=0; i<32; ++i) {
            if ((n&(1<<i)) != 0) {
                res = res|(1<<(31-i));
            }
        }
        return res;
    }

    public int reverseBits2(int n) {
        int answer = 0; // initializing answer
        for (int i = 0; i < 32; i++) { // 32 bit integers
            answer <<= 1; // shifts answer over 1 to open a space
            answer |= ((n >> i) & 1); // inserts bits from n
        }
        return answer;
    }

    public static void main(String[] args) throws Exception {
        test inst = new test();
        inst.reverseBits2(11);
//        subclass inst2 = inst.new subclass();
//
//
//        String str = new String();
//        str.isEmpty();
//
        Map<String, Integer> map1 = new HashMap<>();
        System.out.println(map1.getOrDefault("a", 0));
//
//        Map<String, String> map2 = new HashMap<>();
//        System.out.println(map2.getOrDefault("a", "0"));
//
//        TreeMap<Integer, String> treeMap = new TreeMap<>();
//        treeMap.put(3, "v3");
//        treeMap.put(1, "v1");
//        treeMap.put(2, "v2");
//        System.out.println(treeMap.keySet());
//        System.out.println(treeMap.tailMap(2).keySet());
////        treeMap.pollFirstEntry();
////        treeMap.pollLastEntry();
//
//        String dateTime = "yyyy:MM:dd:HH:mm:ss";
//        SimpleDateFormat df = new SimpleDateFormat(dateTime);
//        System.out.println(df.parse("2017:09:18:15:30:00").getTime());
//
//        Set<String> set1 = new HashSet<>();
//        set1.removeIf(s -> s.equals("a"));
//
//        List<Integer> l = new ArrayList<Integer>();
//        l.isEmpty();
//        l.add(1);
//
//        Stack<Integer> s = new Stack<Integer>();
//        s.isEmpty();
//        s.push(1);
//        s.peek();
//        if(!s.isEmpty()) {
//            s.pop();
//        }
//
//        Queue<Integer> q = new LinkedList<Integer>();
//        q.isEmpty();
//        q.offer(1);
//        q.peek();
//        q.poll();
//
//        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> (o2 - o1));
//        pq.isEmpty();
//        pq.poll();
//        pq.offer(1);
//        pq.peek();
//
//        testBinarySearch();


    }
}
