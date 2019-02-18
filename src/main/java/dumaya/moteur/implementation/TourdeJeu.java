package dumaya.moteur.implementation;

import dumaya.moteur.interf.ITourdeJeu;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Une série de x chiffres/couleurs
 */
//todo affichage du nb de tours
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
    public ArrayList saisirCombinaison(String typeJoueur, ArrayList essais, ArrayList resultatsPrecedents) {
        if (typeJoueur=="J") {
            saisirCombinaisonJoueur(essais);
            return (essais);
        } else {
            saisirCombinaisonOrdi(essais, resultatsPrecedents);
            return (essais);
        }
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

    protected abstract void saisirCombinaisonOrdi(ArrayList essais, ArrayList resultatPrecedents);

    protected abstract void saisirCombinaisonJoueur(ArrayList essais);
}


