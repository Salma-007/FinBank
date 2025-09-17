import java.util.Date;

public class Transaction {
    private int idTransaction;
    static int compteur;
    private TypeTransaction type;
    private float montant;
    private Date date;
    private Compte compteSource;
    private Compte compteDestination;

    public int getIdTransaction() {
        return idTransaction;
    }
    public float getMontant() {
        return montant;
    }
    public Date getDate() {
        return date;
    }
    public Compte getCompteSource() { return compteSource; }
    public Compte getCompteDestination() { return compteDestination; }

    Transaction(TypeTransaction type, float montant, Compte compteSource, Compte compteDestination){
        compteur++;
        idTransaction = compteur;
        this.type = type;
        this.montant = montant;
        this.date = new Date();
        this.compteSource = compteSource;
        this.compteDestination = compteDestination;
    }


}
