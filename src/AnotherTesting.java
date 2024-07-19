import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class AnotherTesting { 
    /** 
     * int[] arr1 =[1,2,5,6,8,9,21,23,35] * 
     * int[] arr2=[3,8,9,10,22,101] * 
     * output = [1,2,3,5,6,8,8,9,9,21,22,23,35,101] 
     * [1, 2, 3, 5, 6, 8, 8, 9, 9, 10, 21, 22, 23, 35, 101]
     * */ 
    public static void main(String[] args) { 

        List<Integer> ls = new ArrayList<>();

        int i = 0;
        int j = 0;

        int[] arr1 = {1,2,5,6,8,9,21,23,35};
        int[] arr2= {3,8,9,10,22,101};

        Stream<Integer> stream1 = Arrays
                                .stream(arr1)
                                .boxed();

        IntStream stream2 = Arrays.stream(arr2);

        int sum1 = stream1
                    .mapToInt(e -> e)
                    .sum();
        
        System.out.println(sum1);

        int sum2 = stream2
                    .sum();

        System.out.println(sum2);

        int len1 = arr1.length;
        int len2 = arr2.length;

        List<Integer> ans1 = Stream
                    .concat(Arrays.stream(arr1).boxed() , Arrays.stream(arr2).boxed())
                    .sorted()
                    .collect(Collectors.toList());

        System.out.println(ans1);

        Long summed = ans1
                    .stream()
                    .mapToLong(e -> e*1L)
                    .sum();

        System.out.println(summed);

        CompletableFuture x = new CompletableFuture<>();

        x.complete(arr2);

        // api --> deployment --> ibm udeploy --> kubernets --> red hat openshift  --> gibana
        // angular -->
        // @ControllerAdvice
        // completable
        // 

        // while(i < len1 && j < len2){  // o(min(len1,len2))

        //     if(arr1[i] <= arr2[j]){
        //         ls.add(arr1[i]);
        //         i++;
        //     }else if(arr1[i] > arr2[j]){
        //         ls.add(arr2[j]);
        //         j++;
        //     }

        // }

        // while(i < len1){
        //     ls.add(arr1[i]);
        //     i++;
        // }

        // while(j < len2){
        //     ls.add(arr2[j]);
        //     j++;
        // }

        System.out.println(ls);


    } 
}