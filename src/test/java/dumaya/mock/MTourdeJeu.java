package dumaya.mock;

import dumaya.moteur.interf.ITourdeJeu;

import java.util.ArrayList;

public class MTourdeJeu implements ITourdeJeu {

    @Override
    public String comparaisonCombinaison(String tentative, String secret){
        return "====";
    }

    @Override
    public ArrayList saisirCombinaison(String typeJoueur, ArrayList essais, ArrayList resultatsPrecedents) {
        return null;
    }

    @Override
    public String afficherResultat(String texte, String typeJoueur) {

        return texte;
    }

    @Override
    public String preparationResultat(String resultat) {
        return null;
    }


}
