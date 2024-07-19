
import java.util.*;
import java.util.stream.*;

public class StringTest {

    public static void main(String[] args) {
        
        String s = "I am Java Developer . We have some .java classes in which we write code for executing _java code";

        s = s.toLowerCase();

        String[] arr = s.split(" ");

        Map<String, Long> x = Arrays
                            .stream(arr)
                            .filter(e -> e.contains("java"))
                            .map(e -> e = "java")
                            .collect(Collectors.groupingBy(e-> e, Collectors.counting()));
        
        System.out.println(x);

        Map<Character, Long> c = s
                                .chars()
                                .mapToObj(e -> (char) e)
                                .collect(Collectors.groupingBy(e-> e, Collectors.counting()));
        
        System.out.println(c);

        HashMap<String, Integer> hm = new HashMap<>();

        hm.put("alice",30);
        hm.put("bob",15);
        hm.put("aron",25);

        Map.Entry<String, Integer> e = hm.entrySet().stream().max(Map.Entry.comparingByValue()).get();

        System.out.println(e.getKey() +" = " + e.getValue());

        // Sorting the HashMap by values
        LinkedHashMap<String, Integer> sortedMap = hm.entrySet()
            .stream()
            .sorted(Map.Entry.comparingByValue())
            .collect(Collectors.toMap(
                Map.Entry::getKey,
                Map.Entry::getValue,
                (e1, e2) -> e1, // if there's a key collision, keep the existing entry
                LinkedHashMap::new // keep entries sorted by insertion order
            ));

           System.out.println(sortedMap); 

        // Displaying the sorted map
        sortedMap.forEach((key, value) -> System.out.println(key + " : " + value));

        List<String> ans = hm
                            .keySet()
                            .stream()
                            .filter(e2 -> e2.startsWith("a"))
                            .collect(Collectors.toList());

        System.out.println(ans);

        int y = hm.values().stream().max(Comparator.naturalOrder()).get();

        System.out.println(y);

        HashMap<String, Integer> hm2 = new HashMap<>(hm);

        for(Map.Entry<String, Integer> e1: hm2.entrySet()){
            hm.remove(e.getKey());
        }

        hm2 = hm;

        // EMPLOYEE -->  EMPiD , NAME

        // FOREIGN --> EMPID , CITY

        // SELECT E.EMPiD , E.NAME, F.CITY FROM EMP E JOIN FOR F ON E.EMPiD = F.EMPID WHERE F.CITY = "";

//    file <--
//         git revert
//         git pull
//         git commit -m 
//         git push

//         MICROSERVICES MAVEN --> IBM UDEPLOY <--  KUBERNETES  (JENKINSFILE)  -> MAVEN -->  --> VA SCAN --> BLACKDUCK  -->  IMAGE --> DEPLOYED

//         RED HAT OPENSHIFT --> LOGS  -->  GERFANA  --> 

//         UI  --> BUG --> 2  -->  ANGULAR 47  --> REACT

//         MONOTHIC (ANT) <-- ECS <--  RUN THE BUILD  --> ENV  -->

//         MICROUI  --> ECS  <--- ANGULAR BUILD --> ENV 

    }
    
}
