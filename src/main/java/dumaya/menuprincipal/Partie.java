package dumaya.menuprincipal;

import dumaya.moteur.implementation.Jeu;
import dumaya.moteur.implementation.JeuChallenger;
import dumaya.moteur.implementation.JeuDefenseur;
import dumaya.moteur.implementation.JeuDuel;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Scanner;

/**
 * Une session de jeu, avec enchainements de plusieurs jeux.
 */
public class Partie {
    private String choixModeJeu;
    private boolean modeDev;
    private int nbdeCouleur;
    private int nbessaiPossible;
    private int longueurduSecret;
    //TODO plein de get et de set ?! j'en fait quoi
    public String getChoixJeu() {
        return choixJeu;
    }

    public String getChoixModeJeu() {
        return choixModeJeu;
    }

    public boolean isModeDev() {
        return modeDev;
    }

    public int getNbdeCouleur() {
        return nbdeCouleur;
    }

    public int getNbessaiPossible() {
        return nbessaiPossible;
    }

    public int getLongueurduSecret() {
        return longueurduSecret;
    }

    private String choixJeu;

    public void setChoixModeJeu(String choixModeJeu) {
        this.choixModeJeu = choixModeJeu;
    }

    public void choixduJeu() {
        System.out.println("Choisissez le jeu auquel vous voulez jouer : \n-R pour Rechercher +/-\n- M pour Mastermind");
        Scanner sc = new Scanner(System.in);
        choixJeu = sc.next();
        System.out.println("Choisissez le mode de jeu auquel vous voulez jouer :\n -C pour Challenger,\n- U pour Duel\n-D pour Defense");
        choixModeJeu = sc.next();
        System.out.println("C'est parti pour : Jeu : " + choixJeu + " Mode : " + choixModeJeu);
    }
    //TODO utiliser une log
    public void initLog() {


    }

    public void chercherConfig() {
        Properties prop = new Properties();
        ClassLoader classLoader = getClass().getClassLoader();
        InputStream input = null;

        try {

            input = classLoader.getResourceAsStream("config.properties");

            // load a properties file
            prop.load(input);

            // get the property value and print it out
            setNbdeCouleur(Integer.valueOf(prop.getProperty("nbdeCouleur")));
            setLongueurduSecret(Integer.valueOf(prop.getProperty("longueurduSecret")));
            setNbessaiPossible(Integer.valueOf(prop.getProperty("nbessaiPossible")));
            if (Integer.valueOf(prop.getProperty("modeDev")) == 1) {
                setModeDev(true);
            } else {
                setModeDev(false);
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void lancerJeu () {
        switch (choixModeJeu) {
            case "C":
                Jeu jeuJoueC = new JeuChallenger(modeDev, choixJeu, choixModeJeu, nbdeCouleur, nbessaiPossible, longueurduSecret);
                jeuJoueC.unJeu();
                break;
            case "U":
                Jeu jeuJoueU = new JeuDuel(modeDev, choixJeu, choixModeJeu, nbdeCouleur, nbessaiPossible, longueurduSecret);
                jeuJoueU.unJeu();
                break;
            case "D":
                Jeu jeuJoueD = new JeuDefenseur(modeDev, choixJeu, choixModeJeu, nbdeCouleur, nbessaiPossible, longueurduSecret);
                jeuJoueD.unJeu();
                break;
            default:
                break;
        }
    }

    public void setNbdeCouleur ( int nbdeCouleur){
        this.nbdeCouleur = nbdeCouleur;
    }

    public void setLongueurduSecret ( int longueurduSecret){
        this.longueurduSecret = longueurduSecret;
    }

    public void setNbessaiPossible ( int nbessaiPossible){
        this.nbessaiPossible = nbessaiPossible;
    }

    public void setModeDev ( boolean modeDev){
        this.modeDev = modeDev;
    }
}