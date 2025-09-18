import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.io.BufferedWriter;

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
            // ecrire la transaction dans le fichier
            Compte.writeInFile(t);
        }
    }

    public void retirer(float montant){
        if(montant < 0 || montant > this.solde){
            System.out.println("erreur le montant est invalide!");
        }else{
            Transaction t = new Transaction(TypeTransaction.retrait, montant, this, this);
            this.historiqueTransactions.add(t);
            this.solde -= montant;
            // ecrire la transaction dans le fichier
            Compte.writeInFile(t);
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

    public static void writeInFile(Transaction t){
        //gestion des exceptions pour ecrire les transactions dans le fichier
        try(FileWriter fw = new FileWriter("transactions.txt", true);
            BufferedWriter writer = new BufferedWriter(fw)){
            writer.write(t.toString());
            writer.newLine();
        }
        catch(FileNotFoundException e){
            System.out.println("file not found");
        }
        catch (IOException e){
            System.out.println("could not open file!");
        }
    }

}
