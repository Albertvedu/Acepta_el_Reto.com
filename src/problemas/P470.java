package problemas;


import java.util.Scanner;

public class P470 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int counter = 0;
        boolean isValid = true;
        String cadena = sc.nextLine();
        isValid = isValidIntro(isValid, cadena);

        if ( isValid ){
            counter = getSearchLigth(isValid, cadena, counter);
            System.out.println(counter);
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
        if ( cadena.length() > 500000) isValid = false;
        return isValid;
    }
}
