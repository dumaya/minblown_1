package dumaya.service.interf;

import java.util.ArrayList;

public interface ITourdeJeu {

    String comparaisonCombinaison(String tentative, String secret);

    ArrayList saisirCombinaison(String typeJoueur, ArrayList essais, ArrayList resultatsPrecedents);

    void saisirCombinaisonJoueur(ArrayList essais);

    String afficherResultat(String texte, String typeJoueur);

    String preparationResultat(String resultat);
}
