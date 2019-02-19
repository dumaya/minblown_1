package dumaya.console;

//import org.apache.log4j.Logger;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Console {
    int longueurduSecret;
    int nbdeCouleur;
    String listeDeChoix;

    public Console(int longueurduSecret, int nbdeCouleur, String listeDeChoix){
        this.longueurduSecret=longueurduSecret;
        this.nbdeCouleur=nbdeCouleur;
        this.listeDeChoix=listeDeChoix;
    }

    public String saisieCombinaison(){

        Scanner sc = new Scanner(System.in);
        String saisie ="";
        do {
            System.out.println("Veuillez saisir "+ longueurduSecret + " chiffres allant de 0 à "+(nbdeCouleur-1));
            saisie = sc.next();
        }while (!saisie.matches("[0-" + (nbdeCouleur-1) + "]{" + longueurduSecret + "}"));
        return saisie;
    }
    public String saisieListeDeChoix(){
        Scanner sc = new Scanner(System.in);
        String saisie ="";
        do {
            System.out.println("Veuillez saisir un des choix de la liste :"+ listeDeChoix);
            saisie = sc.next();
        }while (!saisie.matches(listeDeChoix));
        return saisie;
    }
    public String definirCombiGagnante(){
        String combiSecrete="";
        for (int i = 0; i < longueurduSecret; i++) {
            combiSecrete = combiSecrete + listeDeChoix;
        }
        return combiSecrete;
    }
    //private static final Logger logger = Logger.getLogger(Communication.class);
}
