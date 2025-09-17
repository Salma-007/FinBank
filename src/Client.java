import java.util.HashMap;

public class Client extends Personne{
    static int compteur = 0;
    private int idCLient;
    private HashMap<Integer, Compte> comptes;

    public int getIdCLient() {
        return idCLient;
    }

    Client(int idClient, String nom, String prenom, String mdp) {
        super(nom, prenom, mdp);
        compteur++;
        idClient = compteur;
    }

    public void addAccount(Compte c){
        comptes.put(c.getNumeroCompte(), c);
    }
}
