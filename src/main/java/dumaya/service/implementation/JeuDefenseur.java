package dumaya.service.implementation;

import static dumaya.console.Console.LOG;

public class JeuDefenseur extends Jeu {
    public JeuDefenseur(boolean modeDev, String choixJeu, int nbdeCouleur, int nbessaiPossible, int longueurduSecret) {
        super(modeDev, choixJeu, nbdeCouleur, nbessaiPossible, longueurduSecret);
    }

    /**
     * Définir le code secret (saisie par le joureur) et l'afficher en mode dev et lancer le déroulement des tours de jeu
     * @return gagné ou perdu
     */
    @Override
    public boolean unJeu() {
        boolean resultJeu = false;
        String secret = "";
        if (choixJeu.equals("R")){
            LOG.info("Début d'un jeu Recherche +- mode Defenseur");
            secret=definirCombinaisonSecrete("O", longueurduSecret, 10);
            afficherSecret(secret, "O");
            resultJeu = derouleJeu(secret, choixJeu, longueurduSecret, 10, nbessaiPossible,"O", "");
        } else {
            LOG.info("Début d'un jeu Mastermind mode Defenseur");
            secret=definirCombinaisonSecrete("O", longueurduSecret, nbdeCouleur);
            afficherSecret(secret, "O");
            resultJeu = derouleJeu(secret, choixJeu, longueurduSecret, nbdeCouleur, nbessaiPossible,"O", "");
        }

        findeJeu("O", resultJeu,secret);
        return resultJeu;
    }
}
