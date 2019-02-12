package dumaya.moteur.implementation;

public class JeuDefenseur extends Jeu {
    public JeuDefenseur(boolean modeDev, String choixJeu, String choixModeJeu, int nbdeCouleur, int nbessaiPossible, int longueurduSecret) {
        super(modeDev, choixJeu, choixModeJeu, nbdeCouleur, nbessaiPossible, longueurduSecret);
    }
    @Override
    public boolean unJeu() {
        boolean resultJeu = false;
        String secret = definirCombinaisonSecrete("O", longueurduSecret);
        afficherSecret(secret);
        resultJeu = derouleJeu(secret, choixJeu, longueurduSecret, nbdeCouleur, nbessaiPossible,"O");
        findeJeu("O", resultJeu);
        return resultJeu;
    }
}
