package dumaya.service.implementation;

import dumaya.console.Console;

import static dumaya.outils.Utils.LOG;
import static dumaya.console.Console.afficheMessage;

/**
 * Une session de jeu, avec enchainements de plusieurs jeux.
 * @author Alexis Dumay
 */
public class Partie {

    private String choixModeJeu;
    private boolean modeDev;
    private int nbdeCouleur;
    private int nbessaiPossible;
    private int longueurduSecret;
    private String choixJeu;

    public void setChoixJeu(String choixJeu) {
        this.choixJeu = choixJeu;
    }
    public String getChoixJeu() {
        return choixJeu;
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
    public void setChoixModeJeu(String choixModeJeu) {
        this.choixModeJeu = choixModeJeu;
    }
    public void setNbdeCouleur ( int nbdeCouleur){
        this.nbdeCouleur = nbdeCouleur;
    }
    public void setLongueurduSecret ( int longueurduSecret){
        this.longueurduSecret = longueurduSecret;
    }
    public void setNbessaiPossible(int nbessaiPossible){
        this.nbessaiPossible = nbessaiPossible;
    }
    public void setModeDev ( boolean modeDev){
        this.modeDev = modeDev;
    }

    /**
     * Question du choix du jeu
     */
    public void choixduJeu() {
        afficheMessage("*- Choisissez le jeu auquel vous voulez jouer : \n- R pour Recherche +/-\n- M pour Mastermind");
        choixJeu = Console.saisieListeDeChoix("R|M");
        afficheMessage("*- Choisissez le mode de jeu auquel vous voulez jouer :\n- C pour Challenger,\n- U pour Duel\n- D pour Defense");
        choixModeJeu = Console.saisieListeDeChoix("C|U|D");
    }

    /**
     * Lancement du jeu et mode de jeu choisi
     */
    public void lancerJeu () {
        switch (choixModeJeu) {
            case "C":
                Jeu jeuJoueC = new JeuChallenger(modeDev, choixJeu, nbdeCouleur, nbessaiPossible, longueurduSecret);
                jeuJoueC.unJeu();
                break;
            case "U":
                Jeu jeuJoueU = new JeuDuel(modeDev, choixJeu, nbdeCouleur, nbessaiPossible, longueurduSecret);
                jeuJoueU.unJeu();
                break;
            case "D":
                Jeu jeuJoueD = new JeuDefenseur(modeDev, choixJeu, nbdeCouleur, nbessaiPossible, longueurduSecret);
                jeuJoueD.unJeu();
                break;
            default:
                LOG.error("Cas du choix du mode de jeu non géré");
                break;
        }
    }

}