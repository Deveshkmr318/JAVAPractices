
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.function.IntConsumer;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Test234 {
    
    public static void main(String[] args) {
        
        // Here's a comprehensive worksheet with 50 questions 
        // to help you practice and master the Java Stream API.

        // ### Java Stream API Worksheet
        // ### Sample Data
        // To help you with the exercises, here are some sample data sets:

        // #### List of Integers
        // java
        List<Integer> integers = Arrays.asList(
            1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 15, 20, 25, 30, 35);

        // #### List of Strings
        // java
        List<String> strings = Arrays.asList(
            "apple", 
            "banana", 
            "cherry", 
            "date", 
            "elderberry", 
            "fig", 
            "grape");

        // #### List of Words
        // java
        List<String> words = Arrays.asList(
            "leveled", 
            "radar", 
            "world", 
            "hello", 
            "civic", 
            "rotor", 
            "deified");

        // #### List of People
        // java
        class Person {
            String name;
            int age;
            Person(String name, int age) {
                this.name = name;
                this.age = age;
            }

            @Override
            public String toString(){
                return  "["+name+","+age+"]";
            }
        }

        List<Person> people = Arrays.asList(
            new Person("John", 25),
            new Person("Jane", 30),
            new Person("Jack", 25),
            new Person("Jill", 20),
            new Person("Joe", 30)
        );


        // #### List of Lists of Integers
        // java
        List<List<Integer>> listOfLists = Arrays.asList(
            Arrays.asList(1, 2, 3),
            Arrays.asList(4, 5, 6),
            Arrays.asList(7, 8, 9)
        );


        Collector<Object, ?, List<Object>> collectToList = Collectors.toList();

        Comparator reversed = Comparator.reverseOrder();

        IntConsumer intConsumed = (e) -> { System.out.print(e + " ");};

        Predicate isPalindrome = (e) -> true;
        
                // Work through these questions to get a deep understanding
                // of the Stream API.
                // Feel free to ask if you need clarification on any 
                // of the questions!
                // #### Basic Stream Operations
                // 1. Create a stream from a list of integers and 
                // print each element.
        
        /*Soln 1 : integers
                .stream()
                .forEach(e -> System.out.print(e + " ")); */
        
                // 1 2 3 4 5 6 7 8 9 10 15 20 25 30 35
        
                // 2. Create a stream from an array of strings and 
                // convert each string to uppercase.
        
        /*Soln 2 :  System.out.println(strings
                .stream()
                .map(e -> e.toUpperCase())
                .collect(Collectors.toList())); */
        
                // [APPLE, BANANA, CHERRY, DATE, ELDERBERRY, FIG, GRAPE]
        
                // 3. Create a stream from a list of numbers and 
                // filter out all numbers greater than 10.
        
        /* Soln 3 :   System.out.println(integers
                .stream()
                .filter(e -> e > 10)
                .collect(Collectors.toList())); */
        
                // [15, 20, 25, 30, 35]
        
                // 4. Create a stream from a list of strings and 
                // find the first string that starts with "A".
        
        /* Soln 4 :    System.out.println(strings
                        .stream()
                        .filter(e -> e.startsWith("A") || e.startsWith("a"))
                        .collect(Collectors.toList())); */
        
                    // [apple]
        
                // 5. Create a stream from a range of numbers (1 to 100) and 
                // filter out even numbers.
        
        /*  Soln 5 :         
                IntStream
                .rangeClosed(1, 100)
                .filter(e -> e%2 == 0)
                .forEach(intConsumed); */
                
                /* 2 4 6 8 10 12 14 16 18 20 22 24 26 28 30 32 34 36 38 40
                42 44 46 48 50 52 54 56 58 60 62 64 66 68 70 72 74 76
                78 80 82 84 86 88 90 92 94 96 98 100 */
        
                // #### Intermediate Operations
                // 6. Filter a list of integers to only include even 
                // numbers and then sort them in descending order.
        
        /*  Soln 6 :    System.out.println(integers
                                    .stream()
                                    .filter(e ->  e%2 == 0)
                                    .sorted(reversed)
                                    .collect(collectToList)); */
        
                    // [30, 20, 10, 8, 6, 4, 2]
        
                // 7. Create a stream from a list of strings and 
                // filter out strings with length less than 4.
        
        /*  Soln 7 :
              strings
                .stream()
                .filter(e -> e.length() <= 4)
                .forEach(e -> System.out.print(e + " ")); */
        
                // date fig
        
                // 8. Map a list of strings to their lengths.
        
        /*  Soln 8 :
               strings
                .stream()
                .collect(Collectors.toMap(e->e, e->e.length()))
                .entrySet()
                .forEach(e -> System.out.println(e.getKey() +" : " + e.getValue()));
         */
                /* banana : 6
                date : 4
                apple : 5
                cherry : 6
                fig : 3
                grape : 5
                elderberry : 10 */
        
                // 9. Create a stream from a list of words and 
                // filter out words that are not palindromes.
        
        /*  Soln 9 :
                words
                .stream()
                .filter(e -> isPalindrome(e))
                .forEach(e -> System.out.print(e + " ")); */
        
                // level radar civic rotor deified 
        
                // 10. Create a stream from a list of integers and 
                // square each integer.
        
        /*  Soln 10 : 
                integers
                .stream()
                .collect(Collectors.toMap(e -> e, e -> e*e))
                .entrySet()
                .forEach(e -> System.out.println(e.getKey() + " : " + e.getValue()));
         */
        /*      1 : 1
                2 : 4
                3 : 9
                35 : 1225
                4 : 16
                5 : 25
                6 : 36
                7 : 49
                8 : 64
                9 : 81
                10 : 100
                15 : 225
                20 : 400
                25 : 625
                30 : 900   */
        
                // #### Terminal Operations
                // 11. Collect a list of integers into a set.
        
        /*  Soln 11 : 
                integers
                .stream()
                .collect(Collectors.toSet())
                .forEach(e -> System.out.print(e + " ")); */
        
                // 1 2 3 35 4 5 6 7 8 9 10 15 20 25 30
        
                // 12. Find the maximum value in a list of integers.
        
        /*  Soln 12 : 
               int ans = integers
                        .stream()
                        .max(Comparator.naturalOrder())
                        .get(); 
        
                // System.out.println(ans);   // 35
        
                int ans2 = integers
                        .stream()
                        .max(Comparator.reverseOrder())
                        .get(); 
        
                System.out.println(ans2);   // 1
            
                */
        
                // 13. Count the number of elements in a list of strings 
                // that contain the letter "e".
        
        /*  Soln 13.  
              long ans = strings.stream().filter(e -> e.contains("e")).count();
             
                strings
                .stream()
                .filter(e -> e.contains("e"))
                .forEach(e -> System.out.print(e + " "));
        */
        
                // System.out.println(ans);   
                // 5 -- apple cherry date elderberry grape
        
                // 14. Join a list of strings into a single string 
                // separated by hyphens.
        
        /*  Soln 14 : 
                String str = strings
                            .stream()
                            .collect(Collectors.joining("-")); */
        
                // System.out.println(str);
                //  apple-banana-cherry-date-elderberry-fig-grape
        
                // 15. Calculate the average of a list of integers.
        
        /*  Soln 15 :  
               Double ans = integers
                        .stream()
                        .collect(Collectors.averagingInt(e -> e)); 
        
                int sum = integers
                        .stream()
                        .collect(Collectors.summingInt(e -> e));
                
                long cnt = integers
                        .stream()
                        .count();
        
                    System.out.println(ans);    // 12.0
                    System.out.println(sum);    // 180
                    System.out.println(cnt);    // 15
        */
                // #### Reductions
                // 16. Sum all elements of a list of integers.
        
        /*  Soln 16:
               int sum = integers
                .stream()
                .reduce(0, (x,y) -> x+y);
        
                System.out.println(sum); //180
        
                int sum2 = integers
                .stream()
                .collect(Collectors.summingInt(e -> e));
        
                System.out.println(sum2);  //180
                */
        
                // 17. Find the product of all elements in a list of integers.
        
        /*  Soln 17:  
              Long prod = integers
                .stream()
                .mapToLong(e -> e)
                .reduce(1L, (x,y) ->{ 
                    System.out.println(x + ":" + y);
                    return x*y;
                });
        
                integers
                .stream()
                .forEach(e -> System.out.print(e + " "));
        
                System.out.println(prod);  // 28576800000000
                */
        
                // 18. Find the minimum value in a list of integers.
        
        /*  Soln 18 :
               int min = integers
                .stream()
                .min(Comparator.naturalOrder())
                .get();
        
                System.out.println(min);  // 1
        
                int min2 = integers
                .stream()
                .min(Comparator.reverseOrder())
                .get();
        
                System.out.println(min2); // 35 
                */
        
                // 19. Concatenate all strings in a list.
        
        /*  Soln 19 :  
                String ans = strings
                            .stream()
                            .reduce((x,y) -> ""+x+y)
                            .get();
        
                System.out.println(ans); //applebananacherrydateelderberryfiggrape
        
                String ans2 = strings
                            .stream()
                            .reduce("",(x,y) -> ""+x+y);
        
                System.out.println(ans2);  // applebananacherrydateelderberryfiggrape
                 
                String ans3 = strings
                            .stream()
                            .collect(Collectors.joining(""));
        
                System.out.println(ans3);  // applebananacherrydateelderberryfiggrape
                */
        
                // 20. Calculate the factorial of a number using streams.
        
        /*  Soln 20 : 
                int num = new Scanner(System.in).nextInt();  // 9
        
                Long ans = LongStream
                .rangeClosed(1, num)
                .reduce(1L, (x,y) -> x*y);
        
                System.out.println(ans); // 362880
        
                */
        
                // #### Grouping and Partitioning
                // 21. Group a list of strings by their length.
        
        /*  Soln 21 :        strings
                            .stream()
                            .collect(Collectors.groupingBy(e -> e.length(), Collectors.mapping(e -> e, Collectors.toList())))
                            .entrySet()
                            .forEach(e -> System.out.println(e.getKey() +" : " + e.getValue()));
        */
        /*      3 : [fig]
                4 : [date]
                5 : [apple, grape]
                6 : [banana, cherry]
               10 : [elderberry] 
        */
        
                // 22. Partition a list of integers into even and odd numbers.
        
        /*     Soln 22 :        System.out.println(integers
                .stream()
                .collect(Collectors.partitioningBy(e -> e%2 == 0)));
         */
                // {false=[1, 3, 5, 7, 9, 15, 25, 35], 
                //  true=[2, 4, 6, 8, 10, 20, 30]}
        
                // 23. Group a list of words by their first character.
        
        /*     Soln 23 :
                        words
                        .stream()
                        .collect(Collectors.groupingBy(e -> e.charAt(0)))
                        .entrySet()
                        .forEach(e -> System.out.println(e.getKey() + " : " + e.getValue()));
         */
        /*              r : [radar, rotor]
                        c : [civic]
                        d : [deified]
                        w : [world]
                        h : [hello]
                        l : [level] 
                        
                        */
        
                // 24. Count the number of occurrences of each word
                //  in a list of strings.
        
        /*      Soln 24 :           
                        strings
                        .stream()
                        .collect(Collectors.groupingBy(e -> e , Collectors.counting()))
                        .entrySet()
                        .forEach(e -> System.out.println(e.getKey() + " : " + e.getValue()));
         */
        /*              date : 1
                        banana : 1
                        cherry : 1
                        apple : 1
                        fig : 1
                        grape : 1
                        elderberry : 1 
                        */
        
         /*                words
                        .stream()
                        .collect(Collectors.groupingBy(e -> e, Collectors.counting()))
                        .entrySet()
                        .forEach(e -> System.out.println(e.getKey() + " : " + e.getValue()));
                         */
        /*                 rotor : 1
                        radar : 1
                        world : 1
                        level : 1
                        deified : 1
                        hello : 1
                        civic : 1 
                        */
        
                // 25. Group a list of people objects by their age.
        
        /*      Soln 25 :
                        people
                        .stream()
                        .collect(Collectors.groupingBy(e -> e.age))
                        .entrySet()
                        .forEach(e -> System.out.println(e.getKey() + " : " + e.getValue()));;
         */
        /*              20 : [[Jill,20]]
                        25 : [[John,25], [Jack,25]]
                        30 : [[Jane,30], [Joe,30]]
         */
                // #### Advanced Operations
                // 26. Create a stream from a list of integers and 
                // find the second highest number.
        
                        // System.out.println(integers);
        
                        // [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 15, 20, 25, 30, 35]
        
        /*      Soln 26 :
                
                int ans = integers
                        .stream()
                        .sorted(Comparator.reverseOrder())
                        .limit(2)
                        .sorted()
                        .findFirst()
                        .get();
        
                        System.out.println(ans); // 30
        
                int ans2 = integers
                        .stream()
                        .sorted(Comparator.reverseOrder())
                        .skip(1)
                        .findFirst()
                        .get();
        
                        System.out.println(ans2);  // 30
         */
        
                // 27. Create a stream from a list of numbers and 
                // skip the first 5 elements.
        
        /*      Soln 27 :  
        
        System.out.println(integers
                        .stream()
                        .skip(5)
                        .collect(Collectors.toList()));
         */
                //      [6, 7, 8, 9, 10, 15, 20, 25, 30, 35]
        
                // 28. Create a stream from a list of strings and 
                // limit the results to the first 3 elements.
        
                        // System.out.println(strings);
        
                        // [apple, banana, cherry, date, elderberry, fig, grape]
        
        /*      Soln 28 :
        
                        strings
                        .stream()
                        .limit(3)
                        .forEach(e -> System.out.println(e));
        
                        apple
                        banana
                        cherry 
                        
                        */
        
                // 29. Flatten a list of lists of integers into a single list.
        
                // System.out.println(listOfLists);
        
                // [[1, 2, 3], [4, 5, 6], [7, 8, 9]]
        
        /*      Soln 29 :
        
                List<Integer> ls = listOfLists
                                .stream()
                                .flatMap(e -> e.stream())
                                .collect(Collectors.toList());
        
                                System.out.println(ls);
        
                //              [1, 2, 3, 4, 5, 6, 7, 8, 9]
         */
                // 30. Create a stream of the first 100 prime numbers.
        
        /*      Soln 30 :
        
                        List<Integer> ls = IntStream
                                .iterate(2, e -> e+1)
                                .filter(e -> isPrime(e))
                                .limit(100)
                                .boxed()
                                .collect(Collectors.toList());
        
                                for(int i = 1 ; i <= 100 ; i++)
                                        System.out.println(i + " : " + ls.get(i-1));
         */
        
        /*                              1 : 2
                                        2 : 3
                                        3 : 5
                                        4 : 7
                                        5 : 11
                                        6 : 13
                                        7 : 17
                                        8 : 19
                                        9 : 23
                                        10 : 29
                                        11 : 31
                                        12 : 37
                                        13 : 41
                                        14 : 43
                                        15 : 47
                                        16 : 53
                                        17 : 59
                                        18 : 61
                                        19 : 67
                                        20 : 71
                                        21 : 73
                                        22 : 79
                                        23 : 83
                                        24 : 89
                                        25 : 97
                                        26 : 101
                                        27 : 103
                                        28 : 107
                                        29 : 109
                                        30 : 113
                                        31 : 127
                                        32 : 131
                                        33 : 137
                                        34 : 139
                                        35 : 149
                                        36 : 151
                                        37 : 157
                                        38 : 163
                                        39 : 167
                                        40 : 173
                                        41 : 179
                                        42 : 181
                                        43 : 191
                                        44 : 193
                                        45 : 197
                                        46 : 199
                                        47 : 211
                                        48 : 223
                                        49 : 227
                                        50 : 229
                                        51 : 233
                                        52 : 239
                                        53 : 241
                                        54 : 251
                                        55 : 257
                                        56 : 263
                                        57 : 269
                                        58 : 271
                                        59 : 277
                                        60 : 281
                                        61 : 283
                                        62 : 293
                                        63 : 307
                                        64 : 311
                                        65 : 313
                                        66 : 317
                                        67 : 331
                                        68 : 337
                                        69 : 347
                                        70 : 349
                                        71 : 353
                                        72 : 359
                                        73 : 367
                                        74 : 373
                                        75 : 379
                                        76 : 383
                                        77 : 389
                                        78 : 397
                                        79 : 401
                                        80 : 409
                                        81 : 419
                                        82 : 421
                                        83 : 431
                                        84 : 433
                                        85 : 439
                                        86 : 443
                                        87 : 449
                                        88 : 457
                                        89 : 461
                                        90 : 463
                                        91 : 467
                                        92 : 479
                                        93 : 487
                                        94 : 491
                                        95 : 499
                                        96 : 503
                                        97 : 509
                                        98 : 521
                                        99 : 523
                                        100 : 541
         */
        
                // #### Custom Operations
                // 31. Create a custom collector to find the sum of 
                // the squares of a list of integers.
        
        /*      Soln 31 :
        
                        integers
                        .stream()
                        .collect(Collectors.toMap(e -> e, e -> e*e))
                        .entrySet()
                        .forEach(e -> System.out.println(e.getKey() + " : " + e.getValue()));
                
                        Long ans = integers
                                .stream()
                                .map(e -> e*e)
                                .mapToLong(e -> 1L*e)
                                .sum();
        
                        System.out.println(ans);  // 3760
         */     
        
                        // int i = 2689345;
        
                        // // Find the sum of all digits
                        // int sum = String.valueOf(i).chars()
                        //                         .map(e -> e - '0')
                        //                         .sum();
        
                        // System.out.println(sum);  // Output: 37
        
        
/*                         System.out.println(Optional.ofNullable(null));
        
                        Optional
                        .ofNullable(integers)
                        .ifPresent(e -> System.out.println(e + " "));  */

                        // ArrayList<Integer> dfg = null;

                        //         int ans = dfg
                        //         .stream()
                        //         .mapToInt(e -> e)
                        //         .max()
                        //         .getAsInt();

                        //         System.out.println(ans);


        // 32. Create a custom collector to concatenate strings 
        // in a list with a prefix and suffix.



        // 33. Create a stream from a list of numbers and 
        // find the median value.
        // 34. Create a stream from a list of words and 
        // find the longest word.

/*  Soln 34 :

        String word = words
                                .stream()
                                .sorted(Comparator.comparing(e -> e.length(), Comparator.reverseOrder()))
                                .findFirst()
                                .get();

        System.out.println(word);

*/
        // 35. Create a stream from a list of integers and 
        // find the most frequently occurring number.

        // #### Parallel Streams
        // 36. Convert a stream to a parallel stream and 
        // calculate the sum of a list of integers.
        // 37. Use parallel stream to filter out prime numbers 
        // from a list of integers.
        // 38. Use parallel stream to sort a list of strings.
        // 39. Use parallel stream to find the maximum value 
        // in a list of floating-point numbers.
        // 40. Use parallel stream to group a list of numbers 
        // by their remainder when divided by 5.

        // #### Miscellaneous
        // 41. Create a stream from a list of integers and remove duplicates.
        // 42. Create a stream from a list of strings and sort them by their length.
        // 43. Create a stream from a list of integers and collect the result into a LinkedList.
        // 44. Use the Stream.generate() method to create an 
        // infinite stream of random numbers and 
        // print the first 10.

        IntStream
        .generate(() -> new Random().nextInt())
        .limit(10)
        .forEach(e -> System.out.println(e + " "));

        // 45. Use the Stream.iterate() method to 
        // create a stream of Fibonacci numbers and 
        // collect the first 20.

        Stream
        .iterate(new int[]{0,1}, e -> new int[]{e[1], e[0]+e[1]})
        .map(e -> e[0])
        .limit(20)
        .forEach(e -> System.out.println(e + " "));

        // 46. Create a stream from a list of integers and 
        // use peek() to debug the intermediate values.
        // 47. Create a stream from a list of words and 
        // filter out words containing a specific substring, then collect them to a list.
        // 48. Create a stream from a range of numbers (1 to 1000) 
        // and find all numbers that are both prime and palindromes.
        // 49. Use the Stream.concat() method to 
        // concatenate two streams of strings.

/*      Soln 49 :       List<String> ls = Stream
                                .concat(strings.stream(), strings.stream())
                                .sorted()
                                .collect(Collectors.toList());

                        System.out.println(ls); */

                // [apple, apple, banana, banana, cherry, cherry, date, date, elderberry, elderberry, fig, fig, grape, grape]

        // 50. Create a stream from a map's entry set and find the entry with the highest value.

        Map.Entry<String, Integer> one = words
                                        .stream()
                                        .collect(Collectors.toMap(e -> e, e -> e.length()))
                                        .entrySet()
                                        .stream()
                                        .sorted((e1, e2) -> {
                                                return e2.getValue()- e1.getValue();
                                        }).findFirst()
                                        .get();
                                        
                System.out.println(one.getKey() + " -> " + one.getValue());

        LinkedHashMap<String, Integer> example = words
                                        .stream()
                                        .collect(Collectors.toMap(e -> e, e -> e.length()))
                                        .entrySet()
                                        .stream()
                                        .sorted((e1, e2) -> {
                                                if(e2.getValue() == e1.getValue()){
                                                        return e2.getKey().compareTo(e1.getKey());
                                                }
                                                return e2.getValue()- e1.getValue();
                                        }).collect(Collectors.toMap(e -> e.getKey() ,  e-> e.getValue() , (oldvalue, newvalue) -> oldvalue, LinkedHashMap::new));

                System.out.println(example);
    }

    private static boolean isPalindrome(String s) {
        
        return s.equals(new StringBuilder(s).reverse().toString());
    }

    private static boolean isPrime(int n) {
        
        for(int i = 2 ; i * i <= n ; i++){
              if(n%i == 0){
                return false;
              }
        }

        return true;
    }
}
