package dumaya.main;

import dumaya.menuprincipal.Partie;

/**
 * Bienvenue !
 *
 */
public class Main
{
    //TODO ajout d'un paramétre d'appel
    public static <partie> void main(String[] args )
    {
        System.out.println("Bienvenue dans Mindblown");
        Partie partie = new Partie();
        partie.initLog();
        partie.chercherConfig();
        if (args[1]=="-dev"){
            partie.setModeDev(true);
        }
        partie.choixduJeu();
        partie.lancerJeu();
    }
}
