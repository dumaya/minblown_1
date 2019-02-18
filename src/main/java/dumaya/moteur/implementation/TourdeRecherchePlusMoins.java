package dumaya.moteur.implementation;

import java.util.ArrayList;
import java.util.Scanner;

public class TourdeRecherchePlusMoins extends TourdeJeu {

    public TourdeRecherchePlusMoins(int longueurduSecret, int nbdeCouleur) {
        super(longueurduSecret,nbdeCouleur);
    }

    /**
     * Comparaison des combinaisons
     */
    @Override
    public String comparaisonCombinaison(String tentative, String secret) {
        char[] tabTentative=tentative.toCharArray();
        char[] tabsecret=secret.toCharArray();
        char[] tabcompare= new char[tabsecret.length];
        for (int i=0;i<tabsecret.length;i++) {
            if (tabsecret[i]<tabTentative[i]) {
                tabcompare[i]='-';
            } else {
                if (tabsecret[i]>tabTentative[i]) {
                    tabcompare[i] = '+';
                } else {
                    tabcompare[i] = '=';
                }
            }
        }
        return String.valueOf(tabcompare);
    }

    @Override
    public String preparationResultat(String resultat) {
        String texte = (resultat + " <------ Ce n'est pas exact, try again");
        return texte;
    }
    @Override
    protected void saisirCombinaisonJoueur(ArrayList essais) {
        System.out.println("Saisie combinaison de " + longueurduSecret + " chiffres");
        Scanner sc = new Scanner(System.in);
        String nouvelEssai = sc.next();
        essais.add(nouvelEssai);
    }

}
