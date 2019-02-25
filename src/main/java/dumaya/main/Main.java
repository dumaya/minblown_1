package dumaya.main;

import dumaya.console.Console;
import dumaya.service.implementation.Partie;

import static dumaya.console.Console.LOG;

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
        partie.chercherConfig();
        if (args.length != 0) {
            //todo bug sur le mode dev
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
