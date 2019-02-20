package dumaya.main;

import dumaya.console.Console;
import dumaya.menuprincipal.Partie;

/**
 * Bienvenue !
 *
 */
public class Main
{
    public static <partie> void main(String[] args )
    {
        Console.afficheMessage("Bienvenue dans Mindblown");
        Partie partie = new Partie();
        partie.initLog();
        partie.chercherConfig();
        if (args.length != 0) {
            if (args[0].equals("-dev")) {
                partie.setModeDev(true);
            }
        }
        String choixRejeu="";
        do {
            partie.choixduJeu();
            do {
                partie.lancerJeu();
                Console.afficheMessage("*-Voulez-vous :\nChoix A : refaire le même Jeu\nChoix B : choisir un autre jeu\nChoix C : quitter");
                choixRejeu = Console.saisieListeDeChoix("A|B|C");
            } while (choixRejeu.equals("A"));
        } while (choixRejeu.equals("B"));
    }
}
