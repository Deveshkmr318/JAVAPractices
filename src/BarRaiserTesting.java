
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/*You have an E-com site and there are product getting sold and whenever a product get sold an event get generated it looks like this:
Sold Product Events {eventId: "abcd36239389", productId: 123, timeStamp: "20211208 00:00:00"}
You need to find At any point in time, give me the top "N"  sold products.
Like for example :
Events:
T1 -> 123
T2 -> 456
T3 -> 456
T4 -> 786
T5 -> 123
T6 -> 456
Output
topN(1) -> 456
topN(2) -> 456, 123
*/
class Tuple implements Comparable<Tuple>{

    int productId;
    int count;
    
    public Tuple(int productID, int count){
        this.productId = productID;
        this.count = count;
    }

    @Override    
    public String toString() {
        return "["+this.productId+","+this.count+"]";
    }

    @Override

    public int compareTo(Tuple o) {
        return o.count - this.count;
    }
}

public class BarRaiserTesting{

    public static void main(String[] args) {

        List<Integer> productIds = Arrays.asList(123, 456, 456, 456, 456, 456, 456, 786, 123, 456, 120, 120, 120, 120, 120);
        
        // int[] x = new int[2];
        // List<Integer> lss = Stream.map(x -> {
        //     int y = (int) (Arrays.stream(productIds).max().getAsInt());
        //     int z = (Arrays.stream(productIds).min().getAsInt());
        //     new int[]{y,z};
        // }).boxed().collect(Collectors.toList());
        
        // System.out.println(Arrays.stream(productIds).max().getAsInt());

        List<Tuple> ls = new ArrayList<>();

        Scanner sc = new Scanner(System.in);

        System.out.println(" Enter n :");

        int n = sc.nextInt();

        HashMap<Integer, Integer> hm = new HashMap<>();

        for(int productId : productIds){  // o(n)
            hm.put(productId, hm.getOrDefault(productId, 0) + 1);
        }

        System.out.println(hm);

        for(int key : hm.keySet()){    // o(n)
            Tuple t = new Tuple(key, hm.get(key));
            ls.add(t);
        }

        Collections.sort(ls);

        System.out.println(ls);

        List<Integer> topN = new ArrayList<>();

        int index = 0;

        int size = ls.size();

        while(index < n && size > 0){
            int element = ls.get(size-1).productId;
            topN.add(element);
            index++;
            size--;
        }

        System.out.println(topN);
        
    }
}