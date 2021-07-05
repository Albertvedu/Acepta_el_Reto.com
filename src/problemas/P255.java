package problemas;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P255 {
    public static void main(String[] args) {
        String palabra = inputWord();
        String sortida;
        int pos = 0;
        int bestLong = 1;
        boolean coincidencia = false;
        for (int i = 0; i < palabra.length() - 1 ; i++) {
            sortida = searchWord(palabra, pos, coincidencia);

            if ( bestLong < sortida.length()) bestLong = sortida.length();
            pos ++;
        }
        System.out.println(bestLong);
    }
    private static String inputWord(){
        Scanner sc = new Scanner(System.in);
        String word = "";
        boolean isValid = false;
        do {
            word = sc.nextLine();
            Pattern pat = Pattern.compile("[a-z]{1,2000}");
            Matcher mat = pat.matcher(word);
            if (mat.matches()) {
                isValid = true;
            }
        } while( !isValid );
        return word;
    }
    private static String searchWord(String palabra, int pos, boolean coincidencia) {
        int posicio = pos;
        int posFinalChar = 0;
        int posInitialChar = Integer.MAX_VALUE;

        for (int i = palabra.length()-1; i > posicio ; i--) {

            if ( palabra.charAt(i) == palabra.charAt(posicio)){
                coincidencia = true;
                if ( posFinalChar < i ) posFinalChar = i;
                if ( posInitialChar > posicio) posInitialChar = posicio;
                posicio ++;
            }else {
                posicio = pos;
                posInitialChar = Integer.MAX_VALUE;
                posFinalChar = 0;
                if (coincidencia) {
                    i ++;
                    coincidencia = false;
                }
            }
        }
        if ( coincidencia ) return palabra.substring(posInitialChar, posFinalChar +1);
        else return "";
    }
}
