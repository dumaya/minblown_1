package dumaya.outils;

import dumaya.service.implementation.Partie;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Random;

/**
 * Classe utilitaire, définition du logger, chargement du fichier de config...
 * @author Alexis Dumay
 */
public class Utils {

    public static final Logger LOG = LogManager.getLogger("Console");

    /**
     * Aller chercher les parametres du fichier de config
     * @param partie
     */
    public static void chercherConfig(Partie partie) {
        Properties prop = new Properties();
        ClassLoader classLoader = partie.getClass().getClassLoader();
        InputStream input = null;

        try {

            input = classLoader.getResourceAsStream("config.properties");

            // load a properties file
            prop.load(input);

            // get the property value and print it out
            partie.setNbdeCouleur(Integer.valueOf(prop.getProperty("nbdeCouleur")));
            partie.setLongueurduSecret(Integer.valueOf(prop.getProperty("longueurduSecret")));
            partie.setNbessaiPossible(Integer.valueOf(prop.getProperty("nbessaiPossible")));
            if (Integer.valueOf(prop.getProperty("modeDev")) == 1) {
                partie.setModeDev(true);
            } else {
                partie.setModeDev(false);
            }

        } catch (IOException ex) {
            LOG.fatal("Problème de chargement du fichier config.properties",ex);
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    LOG.fatal("Problème lors de la fermetude du fichier config.properties",e);
                }
            }
        }
    }

    /**
     * Genere une combinaison aléatoire en fct des param ci-dessous :
     * @param longueurduSecret
     * @param nbdeCouleur
     * @return
     */
    public static String genereCombiSecreteAleatoire(int longueurduSecret, int nbdeCouleur) {
        String combiSecrete = "";
        Random r=new Random();
        int[] tabCombiSecrete = r.ints(longueurduSecret,0,nbdeCouleur).toArray();
        for (int i = 0; i < longueurduSecret; i++) {
            combiSecrete = combiSecrete + tabCombiSecrete[i];
        }
        return combiSecrete;
    }
}
