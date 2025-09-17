
public class Gestionnaire extends Personne{
    static int compteur = 0;
    private int idGestionnaire;

    Gestionnaire(int idGestionnaire, String nom, String prenom, String mdp){
        super(nom, prenom, mdp);
        compteur++;
        idGestionnaire = compteur;
    }

    public void setIdGestionnaire(int idGestionnaire) {
        this.idGestionnaire = idGestionnaire;
    }

    public int getIdGestionnaire() {
        return idGestionnaire;
    }
}
