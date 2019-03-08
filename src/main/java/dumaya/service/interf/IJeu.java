package dumaya.service.interf;

/**
 * Interface d'un jeu, n'a pas été utilisée.
 */
public interface IJeu {
    boolean unJeu();

    String definirCombinaisonSecrete(String typeJoueur, int longueurduSecret, int nbdeCouleur);

    void findeJeu(String typeJoueur, boolean resultJeu, String secret);
}
