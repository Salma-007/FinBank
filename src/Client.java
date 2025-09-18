import java.util.HashMap;

public class Client extends Personne{
    static int compteur = 0;
    private int idCLient;
    private HashMap<Integer, Compte> comptes;

    public int getIdCLient() {
        return idCLient;
    }

    Client(String nom, String prenom, String email ,String mdp) {
        super(nom, prenom, email ,mdp);
        compteur++;
        this.idCLient = compteur;
        comptes = new HashMap<>();
    }

    public void addAccount(Compte c){
        comptes.put(c.getNumeroCompte(), c);
    }

    public void virement(float montant, Compte destination, Compte source){
        if(montant > 0){
            Transaction t = new Transaction(TypeTransaction.virement, montant, destination, source);
            destination.deposer(montant);
            source.retirer(montant);
            // ecrire la transaction dans le fichier
            Compte.writeInFile(t);
        }else{
            System.out.println("operation invalide!");
        }
    }

    public void cloturer(int compteId){
        if(this.comptes.containsKey(compteId)){
            this.comptes.remove(compteId);
            System.out.println("le compte avec id: "+compteId+" est supprimé!");
        }
        else{
            System.out.println("compte avec id: "+compteId+" est introuvable!");
        }
    }
}
