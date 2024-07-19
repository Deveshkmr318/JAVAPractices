import java.io.*;
import java.util.*;

public class A_Alice_and_Books{  

    // TUPLE <-- used for when we need a mapping
    static class Tuple{
        int x;
        int y;
        int z;
        Tuple(int x, int y, int z){
            this.x = x;
            this.y = y;
            this.z = z;
        }
    
        @Override
        public String toString(){
            return "["+x+","+y+","+z+"]";
        }
    }

    // MOD INV <-- need to check ???
    private static long modInv(long x, long mod) {
        return fastPowMod(x, mod - 2, mod);
    }
    
    // FAST POWER METHOD <-- quickly calculates fast power with x^n%mod
	private static long fastPowMod(long x, long n, long mod) {
        if (n == 0) return 1;
        long half = fastPowMod(x, n / 2, mod);
        if (n % 2 == 0) return half * half % mod;
        return half * half % mod * x % mod;
    }

    // FAST POWER METHOD <-- quickly calculates fast power with x^n%mod (ITERATIVELY)
    private static long modPow(long a, long b, long m) {
        long result = 1;
        a %= m;
        while (b > 0) {
            if ((b & 1) == 1) // If b is odd
                result = (result * a) % m;
            a = (a * a) % m;
            b >>= 1; // Divide b by 2
        }
        return result;
    }    

    // LPS <-- used mostly to find pattern
    private static int[] computeLPS(String str) {
        int l = str.length();
        int[] LPS = new int[l];
        for(int i = 1 ; i < l ; i++){
            int x = LPS[i-1];
            while(str.charAt(x) != str.charAt(i)){
                if(x == 0){
                    x = -1;
                    break;
                }
                x = LPS[x-1];
            }
            LPS[i] = x+1;
        }
        return LPS;
    }
	
    // GCD <-- used mostly to find gcd of two numbers
	private static int gcd(int a, int b){
        if (b == 0)
            return a;
        return gcd(b, a % b); 
    }

    // GCD <-- used mostly to find gcd of two numbers (ITERATIVELY)
    private static int gcd_iterative(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // Method to check if a number is a palindrome
    private static boolean isPalindrome(int num) {
        // Negative numbers are not palindromes
        if (num < 0) {
            return false;
        }

        // Store the original number
        int original = num;
        int reversed = 0;

        // Reverse the number
        while (num != 0) {
            int digit = num % 10;
            reversed = reversed * 10 + digit;
            num /= 10;
        }

        // Check if the original number is equal to the reversed number
        return original == reversed;
    }

    // Method to check if a string is a palindrome
    private static boolean isPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    // Method to check if an array is a palindrome
    private static boolean isPalindrome(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            if (arr[left] != arr[right]) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
    
    // PRIMEFACTORS <-- List of prime factors of a number
    private static List<Long> primeFactors(long n) {
        List<Long> factors = new ArrayList<>();
        for (int i = 2; i * i <= n; i++) {
            while (n % i == 0) {
                factors.add(i*1l);
                n /= i;
            }
        }
        if (n > 1) factors.add(n);
        return factors;
    }

    // Method to find prime factors and their powers
    private static Map<Integer, Integer> primeFactors(int num) {
        Map<Integer, Integer> factors = new HashMap<>();

        // Check for number of 2s in num
        while (num % 2 == 0) {
            factors.put(2, factors.getOrDefault(2, 0) + 1);
            num /= 2;
        }

        // Check for odd factors from 3 onwards
        for (int i = 3; i <= Math.sqrt(num); i += 2) {
            while (num % i == 0) {
                factors.put(i, factors.getOrDefault(i, 0) + 1);
                num /= i;
            }
        }

        // This condition is to check if num is a prime number greater than 2
        if (num > 2) {
            factors.put(num, factors.getOrDefault(num, 0) + 1);
        }

        return factors;
    }

    // PRIMES <-- List of primes upto a number
    private static List<Integer> sieveOfEratosthenes(int n) {
        boolean[] prime = new boolean[n + 1];
        Arrays.fill(prime, true);
        List<Integer> primes = new ArrayList<>();
        for (int p = 2; p * p <= n; p++) {
            if (prime[p]) {
                for (int i = p * p; i <= n; i += p)
                    prime[i] = false;
            }
        }
        for (int p = 2; p <= n; p++)
            if (prime[p])
                primes.add(p);
        return primes;
    }    

    // BINARYSEARCH <-- used to find element in a sorted array
    private static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) return mid;
            else if (arr[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return -1; // Element not found
    }    

    // Method to sort a 2D array in asceding order based on a specific index
    private static void sort2DArrayAscOrder(int[][] array, int index) {
        Arrays.sort(array, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return Integer.compare(a[index], b[index]);
            }
        });
    }

    // Method to sort a 2D array in descending order based on a specific index
    private static void sort2DArrayDescOrder(int[][] array, int index) {
        Arrays.sort(array, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return Integer.compare(b[index], a[index]);
            }
        });
    }

    // Method to print a 2D array
    private static void print2DArray(int[][] array) {
        for (int[] row : array) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
    
    public static void main(String[] args) {
        // Fast IO for better performance
        FastReader reader = new FastReader();
        PrintWriter out = new PrintWriter(System.out);

        // Read input
        int t = reader.nextInt();

        // int[] arr = new int[N];
        for (int i = 0; i < t; i++) {
            int n = reader.nextInt();
            
            int[] a = new int[n-1];

            for(int j = 0 ; j < n-1 ; j++){
                a[j] = reader.nextInt();
            }
            int ele = reader.nextInt();

            Arrays.sort(a);

            out.println(a[n-2] + ele);

        }

        // Flush and close the output stream
        out.flush();
        out.close();
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

}