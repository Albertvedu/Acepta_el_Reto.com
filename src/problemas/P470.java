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
            isValid = isValidIntro(isValid, cadena);
            int counter = 0;
            if ( counterLigth + cadena.length() > 500000) isValid = false;
            if ( isValid )   counterLigth += cadena.length();
            counter = getSearchLigth(isValid, cadena, counter);

            if ( isValid ) System.out.println(counter);
        }
    }
    private static int getSearchLigth(boolean isValid, String cadena, int counter) {
        while ( isValid && cadena.length() > 2 ) {
            int pos = cadena.indexOf("RAV");
            if (pos != -1) {
                String sSubCadena = cadena.substring(0, pos);
                String a = cadena.substring(pos + 3);
                counter++;
                cadena = sSubCadena + a;
            } else break;
        }
        return counter;
    }
    private static boolean isValidIntro(boolean isValid, String cadena) {
        for (int i = 0; i < cadena.length(); i++) {
            if ((cadena.charAt(i) != 'R') && (cadena.charAt(i) != 'A') && (cadena.charAt(i) != 'V')) isValid = false;
        }
        return isValid;
    }
}
