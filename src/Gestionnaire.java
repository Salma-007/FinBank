import javax.sound.midi.Soundbank;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Gestionnaire extends Personne{
    static int compteur = 0;
    private int idGestionnaire;

    Gestionnaire(String nom, String prenom, String email ,String mdp){
        super(nom, prenom, email, mdp);
        compteur++;
        idGestionnaire = compteur;
    }

    public void setIdGestionnaire(int idGestionnaire) {
        this.idGestionnaire = idGestionnaire;
    }

    public int getIdGestionnaire() {
        return idGestionnaire;
    }

    // historique pour voir toutes les transactions
    public void historiqueAllTransaction(){
        String filaPath = "transactions.txt";
        try(BufferedReader reader = new BufferedReader(new FileReader(filaPath))){
            String Line;
            while((Line = reader.readLine()) != null){
                System.out.println(Line);
            }
        }catch(FileNotFoundException e){
            System.out.println("file not found!");
        }catch(IOException e){
            System.out.println("something went wrong!");
        }
    }
}
