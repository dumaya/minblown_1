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
    @Override
    protected void saisirCombinaisonOrdi(ArrayList essais, ArrayList resultatsPrecedents){
        if (essais.size()==0) {
            char[] tentative = new char[longueurduSecret];
            for (int j = 0; j < longueurduSecret; j++) {
                tentative[j] = (char) (0+'0');
            }
            essais.add(new String(tentative));
        } else {
            // Compter le nb de R
            int nbR = 0;
            for (int i = 0; i < resultatsPrecedents.size(); i++) {
                String precedentResultat = resultatsPrecedents.get(i).toString();
                char[] tabPrecedentResultat = precedentResultat.toCharArray();

                for (int j = 0; j < longueurduSecret; j++) {
                    if (tabPrecedentResultat[j] == 'R')
                        nbR++;
                }

            }
            //tant que nbR n'est pas égal à la longueur du secret, on teste 0000 puis 1111 ...
            char[] tentative = new char[longueurduSecret];
            String essaiPrecedent = essais.get(essais.size() - 1).toString();
            char[] tabEssaiPrecedent = essaiPrecedent.toCharArray();
            int n = tabEssaiPrecedent[1];
            if (nbR != longueurduSecret) {
                for (int j = 0; j < longueurduSecret; j++) {
                    tentative[j] = (char) (n + 1);
                }
            } else {
                // ensuite, on peut trouver le bon code
                for (int i = 0; i < essais.size(); i++) {
                    String unEssai = essais.get(i).toString();
                    char[] tabEssai= unEssai.toCharArray();
                    String unResultat = resultatsPrecedents.get(i).toString();
                    char[] tabResultat= unResultat.toCharArray();

                    for (int j = 0; j < longueurduSecret; j++) {
                        if (tabResultat[j] == 'R')
                            tentative[j] = tabEssai[i];
                    }

                }
            }
            essais.add(new String(tentative));
        }
        System.out.println("L'ordi a choisi " + essais.get(essais.size() - 1).toString());
    }
}