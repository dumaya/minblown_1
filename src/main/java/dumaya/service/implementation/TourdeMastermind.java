package dumaya.service.implementation;

import dumaya.console.Console;

import java.util.ArrayList;

import static dumaya.outils.Utils.LOG;

public class TourdeMastermind extends TourdeJeu {

    public TourdeMastermind(int longueurduSecret, int nbdeCouleur) {
        super(longueurduSecret,nbdeCouleur);
    }


    /**
     * Comparaison des combinaisons, à chaque caractére de la tentative, on compare avec le secret. Si c'est =, on alimente le tableau de retour avec R (rouge)
     * Ensuite on vérifie pour chaque caractére de la tentative si cela correspond à 1 des autres caractéres du secret, dans ce cas on alimente le tableau avec B (blanc) pour mal placé
     * si le secret est "0123" et la tentative "3100" le résultat est "BRB "
     */
    @Override
    public String comparaisonCombinaison(String tentative, String secret) {
        char[] tabTentative=tentative.toCharArray();
        char[] tabsecret=secret.toCharArray();
        char[] tabcompare= new char[tabsecret.length];
        //determination des R
        for (int i=0;i<tabsecret.length;i++) {
            if (tabsecret[i] == tabTentative[i]) {
                tabcompare[i] = 'R';
            }
        }
        //determination des B, on passe en revue les char de tentative (qui ne sont pas déjà trouvés R) et on met à blanc dés qu'on trouve une correspondance
        for (int i=0;i<tabsecret.length;i++) {
            if (tabcompare[i]!='R') {
                for (int j=0;j<tabsecret.length;j++){
                    if (i!=j && tabsecret[j]==tabTentative[i]&&tabcompare[j]!='R')
                        tabcompare[i] = 'B';
                }
            }
        }
        return String.valueOf(tabcompare);
    }

    /**
     * @param resultat , si le secret est "0123" et la tentative "3100" le résultat est "BRB "
     * @return texte : description du résultat du mastermind à afficher
     */
    @Override
    public String preparationResultat(String resultat) {
        int B=0;
        int R=0;
        int Wrong=0;
        char[] tabResultat=resultat.toCharArray();
        for (int i=0;i<tabResultat.length;i++) {
            if (tabResultat[i]=='B') {
                B=B+1;
            } else {
                if (tabResultat[i]=='R'){
                    R=R+1;
                } else {
                    Wrong=Wrong+1;
                }
            }
        }
        return ("Vous avez " + R + " R pions bien placés et " + B + " B pions mal placés mais de la bonne couleur et donc " + Wrong + " pions complétement faux : \"" + resultat+"\"");
    }

    /**
     * ALgo de détermination de la prochaine tentative
     * @param essais liste des essais précédents
     * @param resultatsPrecedents liste des resultats précédents
     */
    @Override
    protected void saisirCombinaisonOrdi(ArrayList essais, ArrayList resultatsPrecedents){
        LOG.debug("Début de l'algo de determination d'une tentative par l'ordi pour le mastermind");
        if (essais.size()==0) {
            // 1er essai à 0000
            essais.add(Console.definirCombiGagnante(longueurduSecret,"0"));
        } else {
            // Compter le nb de Rouges présents dans les prédédentes tentatives
            int nbR = getNbR(resultatsPrecedents);
            //tant que nbR n'est pas égal à la longueur du secret, on teste 0000 puis 1111 ...
            char[] tentative = new char[longueurduSecret];
            String essaiPrecedent = essais.get(essais.size() - 1).toString();
            char[] tabEssaiPrecedent = essaiPrecedent.toCharArray();
            int n = tabEssaiPrecedent[1];
            if (nbR < longueurduSecret) {
                for (int j = 0; j < longueurduSecret; j++) {
                    tentative[j] = (char) (n + 1);
                }
            } else {
                // ensuite, on peut trouver le bon code
                //todo corriger car là l'ordi "triche"
                for (int i = 0; i < essais.size(); i++) {
                    String unEssai = essais.get(i).toString();
                    char[] tabEssai= unEssai.toCharArray();
                    String unResultat = resultatsPrecedents.get(i).toString();
                    char[] tabResultat= unResultat.toCharArray();

                    for (int j = 0; j < longueurduSecret; j++) {
                        if (tabResultat[j] == 'R')
                            tentative[j] = tabEssai[0];
                    }
                }
            }
            essais.add(new String(tentative));
        }
        Console.afficheMessage("L'ordi a choisi " + essais.get(essais.size() - 1).toString());
    }

    /**
     * @param resultatsPrecedents
     * @return nbR le nombre de rouges dans tous les résultats précédents
     */
    private int getNbR(ArrayList resultatsPrecedents) {
        int nbR = 0;
        for (int i = 0; i < resultatsPrecedents.size(); i++) {
            String precedentResultat = resultatsPrecedents.get(i).toString();
            char[] tabPrecedentResultat = precedentResultat.toCharArray();

            for (int j = 0; j < longueurduSecret; j++) {
                if (tabPrecedentResultat[j] == 'R')
                    nbR++;
            }
        }
        return nbR;
    }
}