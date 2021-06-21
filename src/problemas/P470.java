package problemas;


import java.util.Scanner;

public class P470 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int counterLigth = 0;
        boolean isValid ;

        while(counterLigth < 500000) {
            isValid = true;
            String cadena = sc.nextLine();
            counterLigth += cadena.length();

            for (int i = 0; i < cadena.length(); i++) {
                if ((cadena.charAt(i) != 'R') && (cadena.charAt(i) != 'A') && (cadena.charAt(i) != 'V')) isValid = false;
            }
            int counter = 0;

            while ( isValid && cadena.length() > 2 ) {
                int pos = cadena.indexOf("RAV");
                if (pos != -1) {
                    String sSubCadena = cadena.substring(0, pos);
                    String a = cadena.substring(pos + 3);
                    counter++;
                    cadena = sSubCadena + a;
                } else break;
            }
            if ( isValid ) System.out.println(counter);
        }
    }
}
