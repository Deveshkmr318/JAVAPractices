public class Recursion {

    static int steps = 0;
    static void towerOfHanoi(int n, char from_rod, char to_rod, char aux_rod, int[] cnt)
    {
        if (n == 0) {
            return;
        }
        towerOfHanoi(n - 1, from_rod, aux_rod, to_rod, cnt);
        System.out.println("Move disk " + n + " from rod "
        + from_rod + " to rod "
        + to_rod);
        cnt[0]++;
        steps++;
        towerOfHanoi(n - 1, aux_rod, to_rod, from_rod, cnt);
    }

    // Driver code
    public static void main(String args[])
    {
        int N = 4;
        int[] cnt = new int[1];

        // A, B and C are names of rods
        towerOfHanoi(N, 'A', 'C', 'B', cnt);
        
        System.out.println(cnt[0]);
        System.out.println(steps);
    }
}
