import java.util.*;

public class Test {
    public static int solve(int A, int B) {
        if(B>(A*9))
            return 0;
    
        long[][] dp=new long[A+1][B+1];
    
        dp[0][0]=1;
        for(int i=1;i<=A;i++)
            dp[i][0]=0;
        for(int j=1;j<=B;j++)
            dp[0][j]=0;
    
        for(int i=1;i<=A;i++){
            for(int j=1;j<=B;j++){
                for(int k=Math.min(9,j);k>=0;k--){
                    System.out.println("i="+i+"|j="+j+"|k="+k);
                    if(i==1 && k==0){
                        continue;
                    }
                    System.out.println("dp[i][j]::dp["+i+"]["+j+"]="+dp[i][j]);
                    System.out.println("dp[i-1][j-k]::dp["+(i-1)+"]["+(j-k)+"]="+dp[i-1][j-k]);
                    dp[i][j]+=dp[i-1][j-k];
                    System.out.println("dp[i][j]::dp["+i+"]["+j+"]="+dp[i][j]);
                }
                dp[i][j]%=1000000007;
            }
        }

        System.out.println(Arrays.deepToString(dp));
    
        return (int)dp[A][B];
    }

    public static void main(String[] args) {
        solve(2, 4);
    }
}
