package dumaya.service.implementation;

import dumaya.console.Console;

import static dumaya.outils.Utils.LOG;
import static dumaya.console.Console.afficheMessage;

/**
 * Une session de jeu, avec enchainements de plusieurs jeux.
 */
public class Partie {
    private String choixModeJeu;

    public void setChoixJeu(String choixJeu) {
        this.choixJeu = choixJeu;
    }

    private boolean modeDev;
    private int nbdeCouleur;
    private int nbessaiPossible;
    private int longueurduSecret;
    //TODO nettoyer + javadoc
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
        afficheMessage("*- Choisissez le jeu auquel vous voulez jouer : \n- R pour Recherche +/-\n- M pour Mastermind");
        choixJeu = Console.saisieListeDeChoix("R|M");
        afficheMessage("*- Choisissez le mode de jeu auquel vous voulez jouer :\n- C pour Challenger,\n- U pour Duel\n- D pour Defense");
        choixModeJeu = Console.saisieListeDeChoix("C|U|D");
    }

    /**
     * Choix du jeu en fonction du mode de jeu choisi
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
}