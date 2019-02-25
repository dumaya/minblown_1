package dumaya.service.implementation;

import static dumaya.console.Console.LOG;

public class JeuChallenger extends Jeu {
    public JeuChallenger(boolean modeDev, String choixJeu, int nbdeCouleur, int nbessaiPossible, int longueurduSecret) {
        super(modeDev, choixJeu, nbdeCouleur, nbessaiPossible, longueurduSecret);
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
            LOG.info("Début d'un jeu Recherche+- mode Challenger");
            secret=definirCombinaisonSecrete("J", longueurduSecret, 10);
            afficherSecret(secret, "J");
            resultJeu = derouleJeu(secret, choixJeu, longueurduSecret, 10, nbessaiPossible, "J", "");
        } else {
            LOG.info("Début d'un jeu Mastermind mode Challenger");
            secret=definirCombinaisonSecrete("J", longueurduSecret, nbdeCouleur);
            afficherSecret(secret, "J");
            resultJeu = derouleJeu(secret, choixJeu, longueurduSecret, nbdeCouleur, nbessaiPossible, "J", "");
        }
        findeJeu("J", resultJeu,secret);
        return resultJeu;
    }
}
