package problemas;


import java.util.Scanner;

/**
 * Entrada
 * La entrada consiste en múltiples líneas, cada una de ellas con la secuencia de colores de las bombillas tal y como
 * las ha colocado Confun Dio en un día de trabajo. Siempre se especifican como una cadena con las letras R, A o V,
 * para cada uno de los colores rojo, amarillo y verde. El número máximo de bombillas por día que es capaz de poner
 * es 500.000.
 *
 * Salida
 * Por cada caso de prueba el programa escribirá una única línea con el número máximo de semáforos completos y
 * correctos que pueden construirse con los operarios actuales.
 *
 * Entrada de ejemplo
 * RARAVV
 * VAR
 * RAVV
 *
 * Salida de ejemplo
 *
 * 2
 * 0
 * 1
 */
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
