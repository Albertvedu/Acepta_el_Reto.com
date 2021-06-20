package problemas.p463;


import java.util.Scanner;

import static problemas.p463.Main.drawScreen;

public class Main {

    public static void main(String[] args) {
        String a =introData();
        Main.drawScreen(a);
        System.out.println(" resultat: " + a);
    }

    public static void drawScreen(String a){

        int altura = 0;
        int[] pos = new int[100];

        for (int i = 0; i < a.length(); i++) {

            if (a.charAt(i) == 'S') if ( a.charAt(i-1) != 'B' ) altura ++;
            if (a.charAt(i) == 'B') if ( a.charAt(i-1) != 'S' ) altura --;
            if ( i > 0){
                if (a.charAt(i) == 'I') if ( a.charAt(i-1) == 'S' ) altura ++;
                if (a.charAt(i) == 'I') if ( a.charAt(i-1) == 'B' ) altura --;
            }

            pos[i] = altura; //todo FER LIST ADD
            System.out.println(" y: " + ((a.length()-1)-i));
            System.out.println("posicio: " + pos[i]);
        }
        for (int x = 0; x < a.length(); x++) {
            pos[x] = 0;
        }
//        System.out.println("jkl: " + altura);

//        System.out.format("%"+altura*2+"s%10d", altura, a.length());
        for (int e = a.length()-1; e > 0; e--) {
            System.out.format("%"+e+"S%n","X");
        }
    }
    public static String introData() {
        Scanner sc = new Scanner(System.in);
        int counterChar = 0;

        boolean correct = true;
        String intro = ""; String chainString = "";

        while ( true ){
            correct = true;
            System.out.println("intro: ");
            intro = sc.nextLine();
            counterChar++;
            if (intro.length()  > 0 & intro.length() <= 100) {

                for (int i = 0; i < intro.length(); i++) {

                    if ( (intro.charAt(i)!= 'I') & (intro.charAt(i)!= 'S') & (intro.charAt(i)!= 'B')){
                        System.out.println("Only intro (I) (S) (B)");
                        correct = false;
                        break;
                    }
                }
            }else correct = false;

            if ( correct ) break;
        }
        return intro;
    }
}
