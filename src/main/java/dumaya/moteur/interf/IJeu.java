package dumaya.moteur.interf;


public interface IJeu {
    boolean unJeu();

    String definirCombinaisonSecrete(String typeJoueur, int longueurduSecret);

    void findeJeu(String typeJoueur, boolean resultJeu);
}
