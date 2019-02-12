package dumaya.moteur.implementation;

public class JeuChallenger extends Jeu {
    public JeuChallenger(boolean modeDev, String choixJeu, String choixModeJeu, int nbdeCouleur, int nbessaiPossible, int longueurduSecret) {
        super(modeDev, choixJeu, choixModeJeu, nbdeCouleur, nbessaiPossible, longueurduSecret);
    }
    @Override
    public boolean unJeu() {
        boolean resultJeu = false;
        String secret = definirCombinaisonSecrete("J", longueurduSecret);
        afficherSecret(secret);
        resultJeu = derouleJeu(secret, choixJeu, longueurduSecret, nbdeCouleur, nbessaiPossible,"J");
        findeJeu("J", resultJeu);
        return resultJeu;
    }
}
