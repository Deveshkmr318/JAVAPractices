import java.util.*;

public class App {
    public static void main(String[] args) throws Exception {

        TreeSet<Integer> ts = new TreeSet<>(); 
  
        // Elements are added using add() method 
        ts.add(2); 
        ts.add(0); 
        ts.add(1);
        ts.add(3);  
        // Print all elements inside object 
        System.out.println(ts.first()+ " " + ts.last());
        System.out.println("Hello, World!");
    }
}
