package dumaya.moteur.implementation;

import dumaya.console.Console;

import java.util.ArrayList;

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
    protected void saisirCombinaisonOrdi(ArrayList essais, ArrayList resultatPrecedents){
        if (essais.size()==0){
            essais.add("5555");
        } else {
            String precedentResultat = resultatPrecedents.get(resultatPrecedents.size()-1).toString();
            char[] tabResultPrecedent = precedentResultat.toCharArray();
            String precedenteTentative = essais.get(essais.size() - 1).toString();
            char[] tabPrecedenteTentative = precedenteTentative.toCharArray();
            char[] tabProchaineTentative = new char[tabResultPrecedent.length];

            for (int i = 0; i < tabResultPrecedent.length; i++) {
                if (tabResultPrecedent[i] == '+') {
                    int a = Character.getNumericValue(tabPrecedenteTentative[i]);
                    int b = a+1;
                    tabProchaineTentative[i] = (char) (b+'0');
                }
                if (tabResultPrecedent[i] == '-') {
                    int a = Character.getNumericValue(tabPrecedenteTentative[i]);
                    int b = a-1;
                    tabProchaineTentative[i] = (char) (b+'0');
                }
                if (tabResultPrecedent[i] == '=') {
                    tabProchaineTentative[i] = tabPrecedenteTentative[i];
                }
            }
            essais.add(new String(tabProchaineTentative));
        }
        Console.afficheMessage("L'ordi a choisi " + essais.get(essais.size() - 1).toString());
    }

}
