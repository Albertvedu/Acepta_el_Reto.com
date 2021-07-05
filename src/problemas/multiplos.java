package problemas;

public class multiplos {
    public static void main(String[] args) {
        int n = 3;
        for (int i = 0; i < 120000; i++) {
            n = i*3;
            if ( n == 11 || n == 111 || n == 1111 ) System.out.println(n);
        }
    }
}
