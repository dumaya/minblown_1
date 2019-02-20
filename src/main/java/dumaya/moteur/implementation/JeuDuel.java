package dumaya.moteur.implementation;

import dumaya.console.Console;

import java.util.ArrayList;

public class JeuDuel extends Jeu {
    public JeuDuel(boolean modeDev, String choixJeu, int nbdeCouleur, int nbessaiPossible, int longueurduSecret) {
        super(modeDev, choixJeu, nbdeCouleur, nbessaiPossible, longueurduSecret);
    }

    /**
     * Définir les deux codes secrets et les afficher en mode dev et lancer le déroulement des tours de jeu
     * @return gagné ou perdu
     */
    @Override
    public boolean unJeu() {
        Console.afficheMessage("Lancement du jeu en mode Duel");
        boolean resultJeu = false;

        String secretOrdi="";
        String secretJoueur="";
        if (choixJeu.equals("R")){
            secretOrdi=definirCombinaisonSecrete("J",longueurduSecret, 10);
            afficherSecret(secretOrdi,"J");
            secretJoueur=definirCombinaisonSecrete("O", longueurduSecret, 10);
            afficherSecret(secretJoueur,"O");
        } else {
            secretOrdi=definirCombinaisonSecrete("J",longueurduSecret, nbdeCouleur);
            afficherSecret(secretOrdi,"J");
            secretJoueur=definirCombinaisonSecrete("O", longueurduSecret, nbdeCouleur);
            afficherSecret(secretJoueur,"O");
        }
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

        ArrayList resultatComparaisonOrdi=new ArrayList();
        ArrayList resultatComparaisonJoueur=new ArrayList();

        do {
            if (choixJeu.equals("R")) {
                String combiGagnante=Console.definirCombiGagnante(longueurduSecret,"=");
                TourdeRecherchePlusMoins tourdeJeuROrdi = new TourdeRecherchePlusMoins(longueurduSecret,10);
                TourdeRecherchePlusMoins tourdeJeuRJoueur = new TourdeRecherchePlusMoins(longueurduSecret,10);
                Console.afficheMessage("**- Choix d'une tentative de combinaison ");
                ArrayList essaisPlusTentativeOrdi = tourdeJeuROrdi.saisirCombinaison("O", essaisOrdi, resultatComparaisonOrdi);
                ArrayList essaisPlusTentativeJoueur = tourdeJeuRJoueur.saisirCombinaison("J", essaisJoueur, resultatComparaisonJoueur);

                if (tourdeJeuROrdi.comparaisonCombinaison(essaisPlusTentativeOrdi.get(essaisPlusTentativeOrdi.size()-1).toString(), secretJoueur).equals(combiGagnante)) {
                    gagneOrdi = true;
                } else {
                    resultatComparaisonOrdi.add(tourdeJeuROrdi.comparaisonCombinaison(essaisPlusTentativeOrdi.get(essaisPlusTentativeOrdi.size()-1).toString(),secretJoueur));
                    tourdeJeuROrdi.afficherResultat(tourdeJeuROrdi.preparationResultat(resultatComparaisonOrdi.get(resultatComparaisonOrdi.size()-1).toString()),"O");
                    essaisOrdi=essaisPlusTentativeOrdi;
                }
                if (tourdeJeuRJoueur.comparaisonCombinaison(essaisPlusTentativeJoueur.get(essaisPlusTentativeJoueur.size()-1).toString(), secretOrdi).equals(combiGagnante)) {
                    gagneJoueur = true;
                } else {
                    resultatComparaisonJoueur.add(tourdeJeuRJoueur.comparaisonCombinaison(essaisPlusTentativeJoueur.get(essaisPlusTentativeJoueur.size()-1).toString(),secretOrdi));
                    tourdeJeuRJoueur.afficherResultat(tourdeJeuRJoueur.preparationResultat(resultatComparaisonJoueur.get(resultatComparaisonJoueur.size()-1).toString()),"J");
                    essaisJoueur=essaisPlusTentativeJoueur;
                }

            } else {
                String combiGagnante=Console.definirCombiGagnante(longueurduSecret,"R");
                TourdeMastermind tourdeJeuMOrdi = new TourdeMastermind(longueurduSecret,nbdeCouleur);
                TourdeMastermind tourdeJeuMJoueur = new TourdeMastermind(longueurduSecret,nbdeCouleur);

                ArrayList essaisPlusTentativeOrdi = tourdeJeuMOrdi.saisirCombinaison("O", essaisOrdi, resultatComparaisonOrdi);
                ArrayList essaisPlusTentativeJoueur = tourdeJeuMJoueur.saisirCombinaison("J", essaisJoueur, resultatComparaisonJoueur);

                if (tourdeJeuMOrdi.comparaisonCombinaison(essaisPlusTentativeOrdi.get(essaisPlusTentativeOrdi.size()-1).toString(), secretJoueur).equals(combiGagnante)) {
                    gagneOrdi = true;
                } else {
                    resultatComparaisonOrdi.add(tourdeJeuMOrdi.comparaisonCombinaison(essaisPlusTentativeOrdi.get(essaisPlusTentativeOrdi.size()-1).toString(),secretJoueur));
                    tourdeJeuMOrdi.afficherResultat(tourdeJeuMOrdi.preparationResultat(resultatComparaisonOrdi.get(resultatComparaisonOrdi.size()-1).toString()),"O");
                    essaisOrdi=essaisPlusTentativeOrdi;
                }
                if (tourdeJeuMJoueur.comparaisonCombinaison(essaisPlusTentativeJoueur.get(essaisPlusTentativeJoueur.size()-1).toString(), secretOrdi).equals(combiGagnante)) {
                    gagneJoueur = true;
                } else {
                    resultatComparaisonJoueur.add(tourdeJeuMJoueur.comparaisonCombinaison(essaisPlusTentativeJoueur.get(essaisPlusTentativeJoueur.size()-1).toString(),secretOrdi));
                    tourdeJeuMJoueur.afficherResultat(tourdeJeuMJoueur.preparationResultat(resultatComparaisonJoueur.get(resultatComparaisonJoueur.size()-1).toString()),"J");
                    essaisJoueur=essaisPlusTentativeJoueur;
                }

            }
            nbtour++;
        } while ((nbtour <= nbessaiPossible) && !(gagneOrdi || gagneJoueur));

        if (gagneJoueur){
            findeJeu("J", gagneJoueur,secretOrdi);
        }
        if (gagneOrdi) {
            findeJeu("O", gagneOrdi,secretJoueur);
        }
        return (gagneOrdi || gagneJoueur);
    }
}
