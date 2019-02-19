package dumaya.main;

import dumaya.menuprincipal.Partie;

/**
 * Bienvenue !
 *
 */
public class Main
{
    public static <partie> void main(String[] args )
    {
        System.out.println("Bienvenue dans Mindblown");
        Partie partie = new Partie();
        partie.initLog();
        partie.chercherConfig();
        if (args.length != 0) {
            if (args[0].equals("-dev")) {
                partie.setModeDev(true);
            }
        }
        partie.choixduJeu();
        partie.lancerJeu();
    }
}
