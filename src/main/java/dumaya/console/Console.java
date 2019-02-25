package dumaya.console;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.Scanner;


public class Console {

    public Console() {
    }

    public static final Logger LOG = LogManager.getLogger("Console");

    public static String saisieCombinaison(int longueurduSecret, int nbdeCouleur) {

        Scanner sc = new Scanner(System.in);
        String saisie = "";
        System.out.println("Veuillez saisir " + longueurduSecret + " chiffres allant de 0 à " + (nbdeCouleur - 1));
        saisie = sc.next();
        while (!saisie.matches("[0-" + (nbdeCouleur - 1) + "]{" + longueurduSecret + "}")) {
            LOG.warn("Erreur de saisie d'une combinaison: {} alors qu'il faut {} chiffres allant de 0 à {}", saisie, longueurduSecret, nbdeCouleur - 1);
            System.out.println("Erreur de saisie, veuillez svp saisir " + longueurduSecret + " chiffres allant de 0 à " + (nbdeCouleur - 1));
            saisie = sc.next();
        }
        return saisie;
    }

    public static String saisieListeDeChoix(String listeDeChoix) {
        Scanner sc = new Scanner(System.in);
        String saisie = "";
        System.out.println("Veuillez saisir un des choix de la liste :" + listeDeChoix);
        saisie = sc.next();
        while (!saisie.matches(listeDeChoix)) {
            LOG.warn("Erreur de saisie : {} alors qu'il faut choisir entre ces choix : {}", saisie, listeDeChoix);
            System.out.println("Erreur de saisie, veuillez svp saisir un des choix de la liste :" + listeDeChoix);
            saisie = sc.next();
        }
        return saisie;
    }

    public static String definirCombiGagnante(int longueurduSecret, String charGagnant) {
        String combiGagnante = "";
        for (int i = 0; i < longueurduSecret; i++) {
            combiGagnante = combiGagnante + charGagnant;
        }
        return combiGagnante;
    }

    public static void afficheMessage(String texte) {
        System.out.println(texte);
    }
}
