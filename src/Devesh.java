public class Devesh {
    

    public static void main(String[] args) {
        
        String s = "Sonam";

        StringBuilder sb = new StringBuilder(s);

        if(s.equals(sb.reverse().toString())){
            System.out.println("TRUE");
        }else{
            System.out.println("FALSE");
        }

    }
}
