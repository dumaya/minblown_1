package dumaya.moteur.implementation;

public class JeuChallenger extends Jeu {
    public JeuChallenger(boolean modeDev, String choixJeu, String choixModeJeu, int nbdeCouleur, int nbessaiPossible, int longueurduSecret) {
        super(modeDev, choixJeu, choixModeJeu, nbdeCouleur, nbessaiPossible, longueurduSecret);
    }
    /**
     * Définir le code secret (choix par l'ordi) et l'afficher en mode dev et lancer le déroulement des tours de jeu
     * @return gagné ou perdu
     */
    @Override
    public boolean unJeu() {
        boolean resultJeu = false;
        String secret = "";
        if (choixJeu.equals("R")) {
            secret=definirCombinaisonSecrete("J", longueurduSecret, 10);
            resultJeu = derouleJeu(secret, choixJeu, longueurduSecret, 10, nbessaiPossible, "J", "");
        } else {
            secret=definirCombinaisonSecrete("J", longueurduSecret, nbdeCouleur);
            resultJeu = derouleJeu(secret, choixJeu, longueurduSecret, nbdeCouleur, nbessaiPossible, "J", "");
        }
        afficherSecret(secret, "J");
        findeJeu("J", resultJeu);
        return resultJeu;
    }
}
