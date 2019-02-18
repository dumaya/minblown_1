package dumaya.moteur.implementation;

public class Resultat {
    String essai;
    String resultat;
    public Resultat(String essai,String resultat) {
        this.essai = essai;
        this.resultat=resultat;
    }

    public void setEssai(String essai) {
        this.essai = essai;
    }
    public void setResultat(String resultat) {
        this.resultat = resultat;
    }
    public String getEssai() {
        return essai;
    }
}
