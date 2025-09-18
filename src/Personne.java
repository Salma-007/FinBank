
public class Personne {
    String prenom;
    String email;
    String nom;
    String mdp;

    Personne(String nom, String prenom, String mdp){
        this.nom = nom;
        this.prenom = prenom;
        this.mdp = mdp;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

}
