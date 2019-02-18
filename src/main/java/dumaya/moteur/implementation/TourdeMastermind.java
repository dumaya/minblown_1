package dumaya.moteur.implementation;

import java.util.ArrayList;
import java.util.Scanner;

public class TourdeMastermind extends TourdeJeu {

    public TourdeMastermind(int longueurduSecret, int nbdeCouleur) {
        super(longueurduSecret,nbdeCouleur);
    }

    @Override
    protected void saisirCombinaisonJoueur(ArrayList essais) {
        System.out.println("Saisie combinaison de " + longueurduSecret + " chiffres allant de 0 à " + (nbdeCouleur -1));
        Scanner sc = new Scanner(System.in);
        String nouvelEssai = sc.next();
        essais.add(nouvelEssai);
    }
    /**
     * Comparaison des combinaisons, à chaque caractére de la tentative, on compare avec le secret. Si c'est =, on alimente le tableau de retour avec R (rouge)
     * Ensuite on vérifie pour chaque caractére de la tentative si cela correspond à 1 des autres caractéres du secret, dans ce cas on alimente le tableau avec B (blanc) pour mal placé
     */
    @Override
    public String comparaisonCombinaison(String tentative, String secret) {
        char[] tabTentative=tentative.toCharArray();
        char[] tabsecret=secret.toCharArray();
        char[] tabcompare= new char[tabsecret.length];
        for (int i=0;i<tabsecret.length;i++) {
            if (tabsecret[i]==tabTentative[i]) {
                tabcompare[i] = 'R';
            } else {
                for (int j=0;j<tabsecret.length;j++) {
                    if (tabsecret[j]==tabTentative[i]) {
                        tabcompare[i] = 'B';
                    }
                }
            }
        }
        return String.valueOf(tabcompare);
    }
    @Override
    public String preparationResultat(String resultat) {
        int B=0;
        int R=0;
        int Wrong=0;
        char[] tabResultat=resultat.toCharArray();
        for (int i=0;i<tabResultat.length;i++) {
            if (tabResultat[i]=='B') {
                B=B+1;
            } else {
                if (tabResultat[i]=='R'){
                    R=R+1;
                } else {
                    Wrong=Wrong+1;
                }
            }
        }
        String texte=("Vous avez " + R + " pions bien placés et " + B + " pions mal placés mais de la bonne couleur et donc " + Wrong + " pions complétement faux.");
        return texte;
    }
}