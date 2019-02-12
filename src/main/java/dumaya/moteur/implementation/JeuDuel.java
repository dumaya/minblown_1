package dumaya.moteur.implementation;

import java.util.ArrayList;

public class JeuDuel extends Jeu {
    public JeuDuel(boolean modeDev, String choixJeu, String choixModeJeu, int nbdeCouleur, int nbessaiPossible, int longueurduSecret) {
        super(modeDev, choixJeu, choixModeJeu, nbdeCouleur, nbessaiPossible, longueurduSecret);
    }

    @Override
    public boolean unJeu() {
        boolean resultJeu = false;
        String secretJoueur = definirCombinaisonSecrete("J", longueurduSecret);
        resultJeu = derouleJeu(secretJoueur, choixJeu, longueurduSecret, nbdeCouleur, nbessaiPossible,"J");
        findeJeu("J", resultJeu);
        return resultJeu;
    }

    @Override
    protected boolean derouleJeu(String secretJoueur, String choixJeu, int longueurduSecret, int nbdeCouleur, int nbessaiPossible, String j) {
        System.out.println("Lancement du jeu en mode Duel");
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
                    tourdeJeuROrdi.afficherResultat(tourdeJeuROrdi.preparationResultat(resultatComparaisonOrdi));
                    essaisOrdi=essaisPlusTentativeOrdi;
                }
                if (tourdeJeuRJoueur.comparaisonCombinaison(essaisPlusTentativeJoueur.get(essaisPlusTentativeJoueur.size()-1).toString(), secretOrdi).equals("====")) {
                    gagneJoueur = true;
                } else {
                    resultatComparaisonJoueur=tourdeJeuRJoueur.comparaisonCombinaison(essaisPlusTentativeJoueur.get(essaisPlusTentativeJoueur.size()-1).toString(),secretOrdi);
                    tourdeJeuRJoueur.afficherResultat(tourdeJeuRJoueur.preparationResultat(resultatComparaisonJoueur));
                    essaisJoueur=essaisPlusTentativeJoueur;
                }

            } else {
                TourdeMastermind tourdeJeuM = new TourdeMastermind(longueurduSecret,nbdeCouleur);
                //tourdeJeuM.saisirCombinaison();
            }
            nbtour++;
        } while ((nbtour <= nbessaiPossible) && !gagne);

        return gagne;
    }
}
