import java.util.HashSet;

public class RecursionString {
    
    static HashSet<String> hs = new HashSet<>();

    public static void main(String[] args) {
        
        String s = "ab";

        // String s2 = String.valueOf(s.charAt(0));

        subsets( "", s, 0);

    }

    private static void subsets(String sout, String sin, int index) {
        
        if(sin.length() == index ){
            if(!hs.contains(sout)){
                System.out.println(sout);
                hs.add(sout);
            }
            return;
        }

        // System.out.println("sout : " + sout.toString());

        StringBuilder sout1 = new StringBuilder(sout.toString());
        StringBuilder sout2 = new StringBuilder(sout.toString());

        sout1.append(sin.charAt(index));
        sout2.append((char)(sin.charAt(index)-('a'-'A')));
        index++;
        
        subsets(sout1.toString(), sin, index);

        subsets(sout2.toString(), sin, index);
    }
}
