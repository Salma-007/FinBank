import java.util.HashSet;

public class Compte {

    static int compteur = 0;
    private int numeroCompte;
    private float solde;
    private TypeCompte type;
    private HashSet<Transaction> historiqueTransactions;

    Compte( TypeCompte type ){
        compteur++;
        this.numeroCompte = compteur;
        this.solde = 0;
        this.type = type;
        this.historiqueTransactions = new HashSet<>();
    }

    public float getSolde() {
        return solde;
    }

    public void deposer(float montant){
        if(montant < 0){
            System.out.println("erreur le montant est invalide!");
        }else{
            this.solde += montant;
        }
    }

    public void retirer(float montant){
        if(montant < 0 || montant > this.solde){
            System.out.println("erreur le montant est invalide!");
        }else{
            this.solde -= montant;
        }
    }

    public int getNumeroCompte() {
        return numeroCompte;
    }

}
