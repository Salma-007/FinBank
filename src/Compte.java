import java.util.HashSet;

public class Compte {

    private int numeroCompte;
    private float solde;
    public enum type{
        Courant,
        Eparne;
    };
    HashSet<Transaction> historiqueTransactions;

    Compte( float solde, type type){

    }
}
