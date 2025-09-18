
public class Main {
    public static void main(String[] args) {
        Client client1 = new Client("Allali", "Salma", "salma@gmail.com", "salma123");
        Compte compte1 = new Compte(TypeCompte.courant);
        client1.addAccount(compte1);
        compte1.deposer(2000);
        System.out.println(compte1.getSolde());
        compte1.retirer(500);
        System.out.println(compte1.getSolde());
        Compte compte2 = new Compte(TypeCompte.eparne);
        client1.addAccount(compte2);
        client1.virement(200,compte2, compte1);
        System.out.println(compte1.getSolde());
        System.out.println(compte2.getSolde());
        compte1.afficherHistorique();
    }
}