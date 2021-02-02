package demo.temp;

/**
 * @author imnot
 */
public class Demo {

    public static void main(String[] args) {

        String s1 = "Hello";
        String s2 = "H";
        String s3 = "ello";
        String s4 = s2+s3;
        System.out.println(s1 == s2+s3);
        System.out.println(s1 == s4);
        String s5 =s4.intern();
        System.out.println(s1 == s5);
        
        String a1 = new String("a")+new String("b");
        String a2 = a1.intern();
        System.out.println(a1 == a2);
        System.out.println(a2 == "ab");
        
        System.out.println("====================");
        
        String b1 = "c";
        String b2 = "d";
        String b3 = "c"+"d";
        String b4 = b1+b2;
        String b5 = "cd";
        String b6 = b4.intern();
        System.out.println(b3 == b4);
        System.out.println(b3 == b5);
        System.out.println(b3 == b6);
        
    }

}
