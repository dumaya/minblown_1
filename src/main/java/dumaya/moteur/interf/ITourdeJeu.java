package dumaya.moteur.interf;

import java.util.ArrayList;

public interface ITourdeJeu {

    ArrayList saisirCombinaison(String typeJoueur, String resultPrecedent, ArrayList essais);

    String comparaisonCombinaison(String tentative, String secret);

    String afficherResultat(String texte, String typeJoueur);

    String preparationResultat(String resultat);
}
