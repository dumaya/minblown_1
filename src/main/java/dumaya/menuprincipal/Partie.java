package dumaya.menuprincipal;

import com.sun.xml.internal.bind.v2.TODO;
import dumaya.moteur.implementation.Jeu;
import dumaya.moteur.implementation.JeuChallenger;
import dumaya.moteur.implementation.JeuDefenseur;
import dumaya.moteur.implementation.JeuDuel;

import java.util.Scanner;

/**
 * Une partie de jeu, avec enchainements de plusieurs jeux.
 */
public class Partie {
    private String choixModeJeu;
    private boolean modeDev;
    private int nbdeCouleur;
    private int nbessaiPossible;
    private int longueurduSecret;
    //TODO plein de get et de set ?! j'en fait quoi
    public String getChoixJeu() {
        return choixJeu;
    }

    public String getChoixModeJeu() {
        return choixModeJeu;
    }

    public boolean isModeDev() {
        return modeDev;
    }

    public int getNbdeCouleur() {
        return nbdeCouleur;
    }

    public int getNbessaiPossible() {
        return nbessaiPossible;
    }

    public int getLongueurduSecret() {
        return longueurduSecret;
    }

    private String choixJeu;

    public void setChoixModeJeu(String choixModeJeu) {
        this.choixModeJeu = choixModeJeu;
    }

    public void choixduJeu() {
        System.out.println("Choisissez le jeu auquel vous voulez jouer : R pour Rechercher +/- ou M pour Mastermind");
        Scanner sc = new Scanner(System.in);
        choixJeu = sc.next();
        System.out.println("Choisissez le mode de jeu auquel vous voulez jouer : C pour Challenger, U pour Duel ou D pour Defense");
        choixModeJeu = sc.next();
        System.out.println("C'est parti pour : Jeu : " + choixJeu + " Mode : " + choixModeJeu);
    }
    //TODO utiliser une log
    public void initLog() {
        modeDev = true;
    }

//TODO ajouter exploitation du fichier de config
    public void chercherConfig() {

        nbdeCouleur=4;
        nbessaiPossible=20;
        longueurduSecret=4;
    }

    public void lancerJeu() {
        switch (choixModeJeu) {
            case "C":
                Jeu jeuJoueC = new JeuChallenger(modeDev,choixJeu,choixModeJeu,nbdeCouleur,nbessaiPossible,longueurduSecret);
                jeuJoueC.unJeu();
                break;
            case "U":
                Jeu jeuJoueU = new JeuDuel(modeDev,choixJeu,choixModeJeu,nbdeCouleur,nbessaiPossible,longueurduSecret);
                jeuJoueU.unJeu();
                break;
            case "D":
                Jeu jeuJoueD = new JeuDefenseur(modeDev,choixJeu,choixModeJeu,nbdeCouleur,nbessaiPossible,longueurduSecret);
                jeuJoueD.unJeu();
                break;
            default:
                break;
        }
    }
}
