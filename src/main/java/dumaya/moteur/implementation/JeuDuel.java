package dumaya.moteur.implementation;

public class JeuDuel extends Jeu {
    public JeuDuel(boolean modeDev, String choixJeu, String choixModeJeu, int nbdeCouleur, int nbessaiPossible, int longueurduSecret) {
        super(modeDev, choixJeu, choixModeJeu, nbdeCouleur, nbessaiPossible, longueurduSecret);
    }

    @Override
    public boolean unJeu() {
        return false;
    }

    @Override
    protected boolean derouleJeu(String secret, String choixJeu, int longueurduSecret, int nbdeCouleur, int nbessaiPossible, String j) {
        return false;
    }
}
