import java.util.HashMap;

public class Client extends Personne{
    static int compteur = 0;
    private int idCLient;

    public void setIdCLient(int idCLient) {
        this.idCLient = idCLient;
    }

    public int getIdCLient() {
        return idCLient;
    }

    HashMap<String, Compte> comptes;
    Client(int idClient, String nom, String prenom, String mdp) {
        super(nom, prenom, mdp);
        compteur++;
        idClient = compteur;
    }

    public void addAccount(Compte c){

    }
}
