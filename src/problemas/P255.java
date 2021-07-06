package problemas;

/**
 * Ada, Alan y compañía
 *
 * Tiempo máximo: 2,000 s  Memoria máxima: 8192 KiB
 * Ada Byron mirándose en un espejo
 * Cuando iba a las fiestas de la alta sociedad, a Ada le gustaba impresionar a los maridos de sus amigas hablándoles de las palabras palíndromas. "Los palíndromos —les decía— son palabras o frases que se leen igual de izquierda a derecha que de derecha a izquierda". Les ponía ejemplos como "seres", "somos" de 5 letras, o, más largas, "acurruca" de 8 y "reconocer" de 9. Y siempre acababa su disertación presumiendo de que su propio nombre, Ada, era también palíndromo.
 *
 * Alan solía acompañarla en esas situaciones e, intentando quedar por encima para impresionar aún más, siempre afirmaba que su nombre era todavía mejor. Desde niño había sido aficionado a los códigos y las frases ocultas, y estaba orgulloso de que su nombre no fuera palíndromo pero ocultara uno en su interior, "ala".
 *
 * Pero los dos se cuidaban mucho de presumir cuando su amigo Charles estaba cerca. La primera vez que intentaron impresionarle, al fin y al cabo Charles sólo esconde palíndromos triviales de longitud 1, salieron los dos escaldados. "Queridos —les replicó— mi nombre será vulgar pero mi apellido, Babbage, es mejor que vuestros nombres. No oculta uno, sino tres palíndromos no triviales, y además uno es de mayor longitud que los vuestros". Y no le faltaba razón. Si se buscan, se pueden encontrar "bb", "bab" y "abba", el más largo de todos.
 *
 * John, amigo de los tres, siempre esquivaba las discusiones sobre palíndromos. Odiaba los juegos en los que siempre perdía.
 *
 * Entrada
 * El programa deberá procesar múltiples casos de prueba, cada uno en una línea. Cada caso de prueba contendrá una sucesión de un mínimo de 1 y un máximo de 2.000 letras minúsculas del alfabeto inglés, sin símbolos especiales ni espacios.
 *
 * Salida
 * El programa debe indicar, en líneas independientes, la longitud del palíndromo más largo que contiene la sucesión de letras de cada caso de prueba.
 *
 * Entrada de ejemplo
 * ada
 * alan
 * babbage
 * john
 *
 * Salida de ejemplo
 *
 * 3
 * 3
 * 4
 * 1
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Scanner;

public class P255 {
    public static void main(String[] args){
        //Scanner sc = new Scanner(new File("/home/albert/IdeaProjects/Acepta_el_Reto/src/p255"));
        Scanner sc = new Scanner(System.in);
        String palabra = " ";
        while ( palabra.length() != 0 ){ // termina con \n
            palabra = sc.nextLine();  // no exije ni recomienda filtros.
            String sortida;
            int pos = 0;
            int bestLong = 1;
            boolean coincidencia = false;

            for (int i = 0; i < palabra.length() - 1 ; i++) {
                sortida = searchWord(palabra, pos, coincidencia);
                if ( bestLong < sortida.length()) bestLong = sortida.length();
                pos ++;
            }
            if ( palabra.length() != 0 ) System.out.println(bestLong);
        }
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
