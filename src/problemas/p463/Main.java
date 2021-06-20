package problemas.p463;


import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        String a = introData();
        int altura = 0; int alturaMaxima = 0;
        char[][] pos = new char[a.length()][a.length()];
        alturaMaxima = calcularGrafico(a, altura, alturaMaxima, pos);
        drawScreen(a, alturaMaxima, pos);
    }


    private static void drawScreen(String a, int alturaMaxima, char[][] pos) {
        for (int i = 0; i < a.length()+2; i++) {
            System.out.print("#");
        }
        System.out.println();
        for (int i = alturaMaxima; i > -1; i--) {
            System.out.print("#");
            for (int j = 0; j < a.length(); j++) {
                if (pos[i][j] =='\u0000') {  //  \u0000'
                    System.out.print(' ');
                } else
                    System.out.print(pos[i][j]);
            }
            System.out.println("#");
        }
        for (int i = 0; i < a.length()+2; i++) {
            System.out.print("#");
        }
    }

    private static int calcularGrafico(String a, int altura, int alturaMaxima, char[][] pos) {
        for (int i = 0; i < a.length(); i++) {

            if ( i < a.length() -1) {
                if ( a.charAt(i) == 'S' ) {
                    pos[altura][i] = asignarSigno(a.charAt(i));
                    if ( a.charAt(i + 1) == 'S') altura++;
                    if ( a.charAt(i + 1) == 'I') altura++;
                }
                if ( a.charAt(i) == 'B' ) {
                    pos[altura][i] = asignarSigno(a.charAt(i));

                    if ( a.charAt(i + 1) == 'B')  altura--;
                }
                if ( a.charAt(i) == 'I' ) {
                    pos[altura][i] = asignarSigno(a.charAt(i));
                    if ( a.charAt(i + 1) == 'B')  altura--;
                }
            }else{ // ultimo numero
                pos[altura][i] = asignarSigno(a.charAt(i));
            }

            if ( altura > alturaMaxima) alturaMaxima = altura;
            if (altura < 0) System.exit(0);

        }
        return alturaMaxima;
    }

    public static String introData() {
        Scanner sc = new Scanner(System.in);
        boolean correct = true;
        String intro = ""; String chainString = "";
        //System.out.println("intro: ");
        intro = sc.nextLine();

        if (intro.length()  > 0 & intro.length() <= 100) {

            for (int i = 0; i < intro.length(); i++) {

                if ( (intro.charAt(i)!= 'I') && (intro.charAt(i)!= 'S') && (intro.charAt(i)!= 'B')){
                    System.exit(0);
                }
            }
        }else  System.exit(0);
        return intro;
    }
    static char asignarSigno(char signo){
        if( signo == 'S') return '/';
        if( signo == 'B') return '\\';
        if( signo == 'I') return '_';
        return 'x';
    }
}
