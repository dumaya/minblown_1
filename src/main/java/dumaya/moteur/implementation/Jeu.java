package dumaya.moteur.implementation;

import dumaya.moteur.interf.IJeu;

import java.util.ArrayList;

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

    @Override
    public String definirCombinaisonSecrete(String typeJoueur, int longueurduSecret) {
        String combiSecrete ="0000";
        if (typeJoueur.equals("J")){
            combiSecrete = "1111";
        } else {
            combiSecrete = "5622";
        }
        return combiSecrete;
    }


    protected void afficherSecret(String secret) {
        if (modeDev) {
            System.out.println("Le secret est :"+secret);
        }

    }

    @Override
    public void findeJeu(String typeJoueur, boolean resultJeu) {
        if (resultJeu) {
            if (typeJoueur == "J") {
                System.out.println("\n" +
                        " _    __                                                                  ______    ___    ______    _   __    ______           __    __\n" +
                        "| |  / /  ____   __  __   _____         ____ _ _   __  ___  ____         / ____/   /   |  / ____/   / | / /   / ____/          / /   / /\n" +
                        "| | / /  / __ \\ / / / /  / ___/        / __ `/| | / / / _ \\/_  /        / / __    / /| | / / __    /  |/ /   / __/            / /   / / \n" +
                        "| |/ /  / /_/ // /_/ /  (__  )        / /_/ / | |/ / /  __/ / /_       / /_/ /   / ___ |/ /_/ /   / /|  /   / /___           /_/   /_/  \n" +
                        "|___/   \\____/ \\__,_/  /____/         \\__,_/  |___/  \\___/ /___/       \\____/   /_/  |_|\\____/   /_/ |_/   /_____/          (_)   (_)   \n" +
                        "                                                                                                                                        \n");
            } else {
                    System.out.println("L'ordinateur a gagné");
                }
            } else {
            System.out.println("Vous avez perdu");
        }
    }

    protected boolean derouleJeu(String secret, String choixJeu, int longueurduSecret, int nbdeCouleur, int nbessaiPossible, String typeJoueur) {
        System.out.println("Lancement du jeu en mode "+typeJoueur);
        boolean gagne=false;
        int nbtour=0;
        ArrayList essais = new ArrayList();
        String resultatComparaison="";
        do {
            if (choixJeu.equals("R")) {

                TourdeRecherchePlusMoins tourdeJeuR = new TourdeRecherchePlusMoins(longueurduSecret,nbdeCouleur);
                ArrayList essaisPlusTentative = tourdeJeuR.saisirCombinaison(typeJoueur, resultatComparaison, essais);
                if (tourdeJeuR.comparaisonCombinaison(essaisPlusTentative.get(essaisPlusTentative.size()-1).toString(), secret).equals("====")) {
                    gagne = true;

                } else {
                    resultatComparaison=tourdeJeuR.comparaisonCombinaison(essaisPlusTentative.get(essaisPlusTentative.size()-1).toString(),secret);
                    tourdeJeuR.afficherResultat(tourdeJeuR.preparationResultat(resultatComparaison));
                    essais=essaisPlusTentative;
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
