import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
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

    public void setSolde(float s){
        this.solde += s;
    }

    public void deposer(float montant){
        if(montant < 0){
            System.out.println("erreur le montant est invalide!");
        }else{
            Transaction t = new Transaction(TypeTransaction.depot, montant, this, this);
            this.historiqueTransactions.add(t);
            this.solde += montant;
        }
    }

    public void retirer(float montant){
        if(montant < 0 || montant > this.solde){
            System.out.println("erreur le montant est invalide!");
        }else{
            Transaction t = new Transaction(TypeTransaction.retrait, montant, this, this);
            this.historiqueTransactions.add(t);
            this.solde -= montant;

            //gestion des exceptions pour ecrire les transactions dans le fichier
            try(FileWriter writer = new FileWriter("transactions.txt")){
                writer.write(t.toString()+"\n");
            }
            catch(FileNotFoundException e){
                    System.out.println("file not found");
            }
            catch (IOException e){
                System.out.println("could not open file!");
            }
        }
    }

    public int getNumeroCompte() {
        return numeroCompte;
    }

    public void afficherHistorique(){
        for(Transaction t : historiqueTransactions){
            System.out.println(t);
        }
    }

}
