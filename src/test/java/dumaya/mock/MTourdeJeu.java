package dumaya.mock;

import dumaya.moteur.interf.ITourdeJeu;

import java.util.ArrayList;

public class MTourdeJeu implements ITourdeJeu {
    @Override
    public ArrayList saisirCombinaison(String typeJoueur, String resultPrecedent, ArrayList essais) {
        return null;
    }

    @Override
    public String comparaisonCombinaison(String tentative, String secret){
        return "====";
    }

    @Override
    public String afficherResultat(String texte) {

        return texte;
    }

    @Override
    public String preparationResultat(String resultat) {
        return null;
    }


}
