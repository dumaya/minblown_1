package dumaya.service.implementation;

import dumaya.console.Console;
import dumaya.service.interf.ITourdeJeu;
import java.util.ArrayList;

/**
 * Un tour de jeu consiste en la définition (saisie ou logique ordi) d'une tentative, la comparaison avec le secret puis l'affichage du résultat
 * @author Alexis Dumaay
 */
public abstract class TourdeJeu implements ITourdeJeu {

    protected int longueurduSecret;
    protected int nbdeCouleur;

    public TourdeJeu(int longueurduSecret, int nbdeCouleur){
        this.longueurduSecret=longueurduSecret;
        this.nbdeCouleur=nbdeCouleur;
    }

    /**
     * Saisir une combinaison de n chiffres pour le joueur, lancer l'algo de defense pour l'ordi
     * @param essais liste des essais à alimenter
     * @param resultatsPrecedents resultats précédents, utile pour l'algo de defense
     * @param typeJoueur type de joueur
     * @return liste des essais alimentée avec la nouvelle tentative
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
     * Faire saisir une combinaison au joueur
     * @param essais liste des essais à alimenter
     */
    @Override
    public void saisirCombinaisonJoueur(ArrayList essais) {
        Console.afficheMessage("*- A vous de choisir :");
        essais.add(Console.saisieCombinaison(longueurduSecret, nbdeCouleur));
    }

    /**
     * Afficher le résultat
     * @param typeJoueur
     * @param texte texte du resultat à afficher
     * @return le texte du resultat mis en forme
     */
    @Override
    public String afficherResultat(String texte, String typeJoueur) {
        if (typeJoueur=="O") {
            Console.afficheMessage("Resultat Ordi  :" + texte);
        } else {
            Console.afficheMessage("Resultat Joueur:" + texte);
        }
        return texte;
    }

    protected abstract void saisirCombinaisonOrdi(ArrayList essais, ArrayList resultatPrecedents);

}


