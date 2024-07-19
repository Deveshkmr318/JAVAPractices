class X
{   
    {
    System.err.println("X");
    }
    // public X(int i)
    // {
    //     System.out.println(1);
    // }
}
 
class Y extends X
{
    public Y()
    {      
        // super(10);
        System.out.println(2);
    }
}

public class MainClass extends Y{

    public static void main(String[] args) {
        X x = new MainClass();
    }

}