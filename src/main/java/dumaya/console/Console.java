package dumaya.console;

//import org.apache.log4j.Logger;

import java.util.Scanner;

public class Console {

    public Console(){
    }

    public static String saisieCombinaison(int longueurduSecret, int nbdeCouleur){

        Scanner sc = new Scanner(System.in);
        String saisie ="";
        do {
            System.out.println("Veuillez saisir "+ longueurduSecret + " chiffres allant de 0 à "+(nbdeCouleur -1));
            saisie = sc.next();
        }while (!saisie.matches("[0-" + (nbdeCouleur -1) + "]{" + longueurduSecret + "}"));
        return saisie;
    }
    public static String saisieListeDeChoix(String listeDeChoix){
        Scanner sc = new Scanner(System.in);
        String saisie ="";
        do {
            System.out.println("Veuillez saisir un des choix de la liste :"+ listeDeChoix);
            saisie = sc.next();
        }while (!saisie.matches(listeDeChoix));
        return saisie;
    }

    public static String definirCombiGagnante(int longueurduSecret, String charGagnant){
        String combiGagnante="";
        for (int i = 0; i < longueurduSecret; i++) {
            combiGagnante = combiGagnante + charGagnant;
        }
        return combiGagnante;
    }

    public static void afficheMessage(String texte) {
        System.out.println(texte);
    }
    //private static final Logger logger = Logger.getLogger(Communication.class);
}
