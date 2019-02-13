package dumaya.moteur.implementation;

public class TourdeMastermind extends TourdeJeu {

    public TourdeMastermind(int longueurduSecret, int nbdeCouleur) {
        super(longueurduSecret,nbdeCouleur);
    }
    //TODO à coder
    @Override
    public String preparationResultat(String resultat) {
        String texte = (resultat + "<------ Ce n'est pas exact, try again" );
        return texte;
    }
}