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

    // la somme des soldes de tous les comptes
    public float consulterSolde() {
        float total = 0;
        for (Compte c : comptes.values()) {
            total += c.getSolde();
        }
        return total;
    }

    public void afficherMesComptes() {
        System.out.println("--- MES COMPTES ---");
        for (Compte compte : comptes.values()) {
            System.out.println("Compte " + compte.getNumeroCompte() +
                    " - Solde: " + compte.getSolde() + " DH");
        }
    }

    public Compte getCompte(int numeroCompte) {
        return comptes.get(numeroCompte);
    }

    public HashMap<Integer, Compte> getComptes() {
        return comptes;
    }

    public void addAccount(Compte c){
        comptes.put(c.getNumeroCompte(), c);
        System.out.println("compte crée avec succes!");
    }

    public void virement(float montant, Compte destination, Compte source){
        if(montant >= 0 || !comptes.containsValue(destination) ||!comptes.containsValue(source)){
            Transaction t = new Transaction(TypeTransaction.virement, montant, destination, source);
            destination.deposer(montant);
            source.retirer(montant);
            // ecrire la transaction dans le fichier
            Compte.writeInFile(t);
            System.out.println("Virement réussi !");
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
