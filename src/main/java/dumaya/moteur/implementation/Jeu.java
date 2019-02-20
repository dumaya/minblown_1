package dumaya.moteur.implementation;

import dumaya.console.Console;
import dumaya.moteur.interf.IJeu;

import java.util.ArrayList;
import java.util.Random;

/**
 * Un jeu consiste en la définition du ou des secrets et en l'exécution des tours de jeu jusqu'à ce qu'il y ai un gagnant ou que le nb de tours soit dépassé.
 */
public abstract class  Jeu  implements IJeu {
    private boolean modeDev;
    protected String choixJeu;
    private String choixModeJeu;
    protected int nbdeCouleur;
    protected int nbessaiPossible;
    protected int longueurduSecret;
    public Jeu(boolean modeDev, String choixJeu, String choixModeJeu, int nbdeCouleur, int nbessaiPossible, int longueurduSecret) {
        this.modeDev=modeDev;
        this.choixJeu=choixJeu;
        this.choixModeJeu=choixModeJeu;
        this.nbdeCouleur=nbdeCouleur;
        this.nbessaiPossible=nbessaiPossible;
        this.longueurduSecret=longueurduSecret;
    }
    @Override
    public abstract boolean unJeu();

    /**
     * @param typeJoueur Si joueur, combi random, si ordi, le joueur choisi
     * @param longueurduSecret
     * @param nbdeCouleur
     * @return la combinaison archi secrete
     */
    //TODO  nb de characteres variable
    @Override
    public String definirCombinaisonSecrete(String typeJoueur, int longueurduSecret, int nbdeCouleur) {
        String combiSecrete ="";
        if (typeJoueur.equals("J")){
            Random r=new Random();
            int[] tabCombiSecrete = r.ints(longueurduSecret,0,nbdeCouleur).toArray();
            for (int i = 0; i < longueurduSecret; i++) {
                combiSecrete = combiSecrete + tabCombiSecrete[i];
            }
        } else {
            Console.afficheMessage("Choisissez le code secret que l'ordi va devoir trouver.");
            combiSecrete=Console.saisieCombinaison(longueurduSecret,nbdeCouleur);
        }
        return combiSecrete;
    }


    protected void afficherSecret(String secret, String typeJoueur) {
        if (modeDev) {
            if (typeJoueur=="O"){
                Console.afficheMessage("Mode dev : Le secret du Joueur est : " + secret);
            } else {
                Console.afficheMessage("Mode dev : Le secret de l'Ordi est : " + secret);
            }
        }
    }

    @Override
    public void findeJeu(String typeJoueur, boolean resultJeu) {
        if (resultJeu) {
            if (typeJoueur == "J") {
                Console.afficheMessage("\n" +
                        " _    __                                                                  ______    ___    ______    _   __    ______           __    __\n" +
                        "| |  / /  ____   __  __   _____         ____ _ _   __  ___  ____         / ____/   /   |  / ____/   / | / /   / ____/          / /   / /\n" +
                        "| | / /  / __ \\ / / / /  / ___/        / __ `/| | / / / _ \\/_  /        / / __    / /| | / / __    /  |/ /   / __/            / /   / / \n" +
                        "| |/ /  / /_/ // /_/ /  (__  )        / /_/ / | |/ / /  __/ / /_       / /_/ /   / ___ |/ /_/ /   / /|  /   / /___           /_/   /_/  \n" +
                        "|___/   \\____/ \\__,_/  /____/         \\__,_/  |___/  \\___/ /___/       \\____/   /_/  |_|\\____/   /_/ |_/   /_____/          (_)   (_)   \n" +
                        "                                                                                                                                        \n");
            } else {
                Console.afficheMessage("L'ordinateur a gagné");
                }
        } else {
            Console.afficheMessage("Vous avez perdu");
        }
    }

    /**
     * Déroulement d'un jeu en modes Challenger et Defenseur
     * @param secretJoueur Secret défini le joueur en mode Def et par l'ordi en mode Challenger
     * @param choixJeu Recherche ou Mastermind
     * @param longueurduSecret
     * @param nbdeCouleur nb de possibilité dans le choix des chiffres du mastermind
     * @param nbessaiPossible nb d'essau avant fin de jeu
     * @param typeJoueur permet de jouer en mode challenger et en mode defenseur
     * @param secretOrdi Secret défini par l'ordi, à faire deviner au joueur, uniquement en mode Duel => derouleJeu est alors surgargé
     * @return gagné ou perdu !
     */
    protected boolean derouleJeu(String secretJoueur, String choixJeu, int longueurduSecret, int nbdeCouleur, int nbessaiPossible, String typeJoueur, String secretOrdi) {
        boolean gagne=false;
        int nbtour=0;
        ArrayList essais = new ArrayList();
        ArrayList resultatsPrecedents = new ArrayList();

        String resultatComparaison="";
        do {
            if (choixJeu.equals("R")) {
                String combiGagnante=Console.definirCombiGagnante(longueurduSecret,"=");
                TourdeRecherchePlusMoins tourdeJeuR = new TourdeRecherchePlusMoins(longueurduSecret,10);
                ArrayList essaisPlusTentative = tourdeJeuR.saisirCombinaison(typeJoueur, essais, resultatsPrecedents);
                if (tourdeJeuR.comparaisonCombinaison(essaisPlusTentative.get(essaisPlusTentative.size()-1).toString(), secretJoueur).equals(combiGagnante)) {
                    gagne = true;
                } else {
                    resultatComparaison=tourdeJeuR.comparaisonCombinaison(essaisPlusTentative.get(essaisPlusTentative.size()-1).toString(), secretJoueur);
                    tourdeJeuR.afficherResultat(tourdeJeuR.preparationResultat(resultatComparaison), typeJoueur);
                    essais=essaisPlusTentative;
                    resultatsPrecedents.add(resultatComparaison);
                }

            } else {
                String combiGagnante=Console.definirCombiGagnante(longueurduSecret,"R");
                TourdeMastermind tourdeJeuM = new TourdeMastermind(longueurduSecret,nbdeCouleur);
                ArrayList essaisPlusTentative = tourdeJeuM.saisirCombinaison(typeJoueur, essais,resultatsPrecedents);
                if (tourdeJeuM.comparaisonCombinaison(essaisPlusTentative.get(essaisPlusTentative.size()-1).toString(), secretJoueur).equals(combiGagnante)) {
                    gagne = true;
                } else {
                    resultatComparaison=tourdeJeuM.comparaisonCombinaison(essaisPlusTentative.get(essaisPlusTentative.size()-1).toString(), secretJoueur);
                    tourdeJeuM.afficherResultat(tourdeJeuM.preparationResultat(resultatComparaison), typeJoueur);
                    essais=essaisPlusTentative;
                    resultatsPrecedents.add(resultatComparaison);
                }
            }
            nbtour++;
        } while ((nbtour <= nbessaiPossible) && !gagne);

        return gagne;
    }

}
