import java.util.Date;

public class Transaction {
    static int compteur;

    public int getIdTransaction() {
        return idTransaction;
    }

    public void setIdTransaction(int idTransaction) {
        this.idTransaction = idTransaction;
    }

    private int idTransaction;
    public enum type{
        depot,
        retrait,
        virement;
    }

    public float getMontant() {
        return montant;
    }

    public void setMontant(float montant) {
        this.montant = montant;
    }

    private float montant;
    Date date;
    Compte compteSource;
    Compte compteDestination;

    Transaction(type type, float montant, Date date, Compte compteSource, Compte compteDestination){
        compteur++;
        idTransaction = compteur;
    }

}
