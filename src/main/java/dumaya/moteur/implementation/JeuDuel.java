package dumaya.moteur.implementation;

import java.util.ArrayList;

public class JeuDuel extends Jeu {
    public JeuDuel(boolean modeDev, String choixJeu, String choixModeJeu, int nbdeCouleur, int nbessaiPossible, int longueurduSecret) {
        super(modeDev, choixJeu, choixModeJeu, nbdeCouleur, nbessaiPossible, longueurduSecret);
    }

    /**
     * Définir les deux codes secrets et les afficher en mode dev et lancer le déroulement des tours de jeu
     * @return gagné ou perdu
     */
    @Override
    public boolean unJeu() {
        System.out.println("Lancement du jeu en mode Duel");
        boolean resultJeu = false;

        String secretOrdi=definirCombinaisonSecrete("J",longueurduSecret);
        afficherSecret(secretOrdi,"J");

        String secretJoueur = definirCombinaisonSecrete("O", longueurduSecret);
        afficherSecret(secretJoueur,"O");

        resultJeu = derouleJeu(secretJoueur, choixJeu, longueurduSecret, nbdeCouleur, nbessaiPossible,"J",secretOrdi);

        return resultJeu;
    }

    /**
     * Déroulement d'un jeu en mode duel, à chaque tour Ordi puis Joueur choisissent une combinaison, elle est évaluée puis le résultat est affiché pour les deux.
     * La fin du jeu est différente suivant qui gagne
     * @param secretJoueur Secret défini par le joueur, à faire deviner à l'ordi pour les mod
     * @param choixJeu Recherche ou Mastermind
     * @param longueurduSecret
     * @param nbdeCouleur nb de possibilité dans le choix des chiffres du mastermind
     * @param nbessaiPossible
     * @param typeJoueur en mode duel, il n'est pas utilisé
     * @param secretOrdi Secret défini par l'ordi, à faire deviner au joueur, uniquement en mode Duel
     * @return
     */
    @Override
    protected boolean derouleJeu(String secretJoueur, String choixJeu, int longueurduSecret, int nbdeCouleur, int nbessaiPossible, String typeJoueur, String secretOrdi) {

        boolean gagneOrdi=false;
        boolean gagneJoueur=false;
        int nbtour=0;
        ArrayList essaisOrdi = new ArrayList();
        ArrayList essaisJoueur = new ArrayList();
        String resultatComparaisonOrdi="";
        String resultatComparaisonJoueur="";

        do {
            if (choixJeu.equals("R")) {

                TourdeRecherchePlusMoins tourdeJeuROrdi = new TourdeRecherchePlusMoins(longueurduSecret,nbdeCouleur);
                TourdeRecherchePlusMoins tourdeJeuRJoueur = new TourdeRecherchePlusMoins(longueurduSecret,nbdeCouleur);

                ArrayList essaisPlusTentativeOrdi = tourdeJeuROrdi.saisirCombinaison("O", resultatComparaisonOrdi, essaisOrdi);
                ArrayList essaisPlusTentativeJoueur = tourdeJeuRJoueur.saisirCombinaison("J", resultatComparaisonJoueur, essaisJoueur);

                if (tourdeJeuROrdi.comparaisonCombinaison(essaisPlusTentativeOrdi.get(essaisPlusTentativeOrdi.size()-1).toString(), secretJoueur).equals("====")) {
                    gagneOrdi = true;
                } else {
                    resultatComparaisonOrdi=tourdeJeuROrdi.comparaisonCombinaison(essaisPlusTentativeOrdi.get(essaisPlusTentativeOrdi.size()-1).toString(),secretJoueur);
                    tourdeJeuROrdi.afficherResultat(tourdeJeuROrdi.preparationResultat(resultatComparaisonOrdi),"O");
                    essaisOrdi=essaisPlusTentativeOrdi;
                }
                if (tourdeJeuRJoueur.comparaisonCombinaison(essaisPlusTentativeJoueur.get(essaisPlusTentativeJoueur.size()-1).toString(), secretOrdi).equals("====")) {
                    gagneJoueur = true;
                } else {
                    resultatComparaisonJoueur=tourdeJeuRJoueur.comparaisonCombinaison(essaisPlusTentativeJoueur.get(essaisPlusTentativeJoueur.size()-1).toString(),secretOrdi);
                    tourdeJeuRJoueur.afficherResultat(tourdeJeuRJoueur.preparationResultat(resultatComparaisonJoueur),"J");
                    essaisJoueur=essaisPlusTentativeJoueur;
                }

            } else {
                TourdeMastermind tourdeJeuM = new TourdeMastermind(longueurduSecret,nbdeCouleur);
                //tourdeJeuM.saisirCombinaison();
            }
            nbtour++;
        } while ((nbtour <= nbessaiPossible) && !(gagneOrdi || gagneJoueur));

        if (gagneJoueur){
            findeJeu("J", gagneJoueur);
        }
        if (gagneOrdi) {
            findeJeu("O", gagneOrdi);
        }
        return (gagneOrdi || gagneJoueur);
    }
}
