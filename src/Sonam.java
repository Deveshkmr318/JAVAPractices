
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Sonam {

    public static void main(String[] args) {
        
        int[] arr = {1,1,2,2,3,3,3,4,5,6,7,7};  //int   ->  Integer

        // d e v v e d  -->  3
        // d e v d e v

    }    
    
    public static void solve(String[] args) {
        String s = "ssssss"; // ssseeesss

        char[] ch = s.toLowerCase().toCharArray();

        HashMap<Character, Integer> hm = new HashMap<>();

        for(char x : ch){
            hm.put(x, hm.getOrDefault(x, 0)+1);
        }

        System.out.println(hm);

        if(checkPalindrome(hm)){
            System.out.println("Yes");
        }else{
            System.out.println("No");
        }
    }

    private static boolean checkPalindrome(HashMap<Character, Integer> hm) {
        // TODO Auto-generated method stub
        // System.out.println(hm.values());
        int odd = 0;
        for(int x : hm.values()){
            if(x%2 == 0){   //even
                continue;
            }else{          // odd
                if(odd == 0){
                    odd = 1;
                }else{
                    return false;
                }
            }
        }

        return true;
    }
}
