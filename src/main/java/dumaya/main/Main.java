package dumaya.main;

import dumaya.console.Console;
import dumaya.outils.Utils;
import dumaya.service.implementation.Partie;

import static dumaya.outils.Utils.LOG;

/**
 * Bienvenue !
 *
 */
public class Main
{
    public static <partie> void main(String[] args )
    {
        LOG.info("Début d'une partie");
        Console.afficheMessage("Bienvenue dans Mindblown");
        Partie partie = new Partie();
        Utils.chercherConfig(partie);
        if (args.length != 0) {
            if (args[0].equals("-dev")) {
                partie.setModeDev(true);
            } else {
                LOG.error("Argument passé non reconnu");
            }
        }
        String choixRejeu="";
        do {
            partie.choixduJeu();
            do {
                partie.lancerJeu();
                Console.afficheMessage("*-Voulez-vous :\nChoix J : refaire le même Jeu\nChoix A : choisir un autre jeu\nChoix Q : quitter");
                choixRejeu = Console.saisieListeDeChoix("J|A|Q");
            } while (choixRejeu.equals("J"));
        } while (choixRejeu.equals("A"));
    }
}
