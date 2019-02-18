package dumaya.moteur.implementation;

import dumaya.moteur.interf.ITourdeJeu;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Une série de x chiffres/couleurs

 */
public abstract class TourdeJeu implements ITourdeJeu {


    protected int longueurduSecret;
    protected int nbdeCouleur;

    public TourdeJeu(int longueurduSecret, int nbdeCouleur){
        this.longueurduSecret=longueurduSecret;
        this.nbdeCouleur=nbdeCouleur;
    }
    /**
     * Saisir une combinaison de n chiffres
     */
    @Override
    public ArrayList saisirCombinaison(String typeJoueur, String resultPrecedent, ArrayList essais) {
        if (typeJoueur=="J") {
            saisirCombinaisonJoueur(essais);
            return (essais);
        } else {
            saisirCombinaisonOrdi(resultPrecedent, essais);
            return (essais);
        }
    }

    private void saisirCombinaisonOrdi(String resultPrecedent, ArrayList essais) {
        if (essais.size()==0){
            essais.add("5555");
        } else {
            char[] tabResultPrecedent = resultPrecedent.toCharArray();
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
        System.out.println("L'ordi a choisi " + essais.get(essais.size() - 1).toString());
    }



    /**
     * Afficher le résultat
     */
    @Override
    public String afficherResultat(String texte, String typeJoueur) {
        if (typeJoueur=="O") {
            System.out.println(texte +" Ordinateur");
        } else {
            System.out.println(texte +" Joueur");
        }
        return texte;
    }

    protected abstract void saisirCombinaisonJoueur(ArrayList essais);
}


