package dumaya.moteur.implementation;

import java.util.Scanner;

public class TourdeRecherchePlusMoins extends TourdeJeu {

    public TourdeRecherchePlusMoins(int longueurduSecret, int nbdeCouleur) {
        super(longueurduSecret,nbdeCouleur);
    }


    @Override
    public String preparationResultat(String resultat) {
        String texte = (resultat + " <------ Ce n'est pas exact, try again");
        return texte;
    }
}
