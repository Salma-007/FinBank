
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    static Client client1 = new Client("Allali", "Salma", "salma@gmail.com", "1234");
    static Gestionnaire gestionnaire1 = new Gestionnaire("Allaoui", "Taha", "taha@gmail.com", "12345");

    public static void main(String[] args) {
        Compte cmp = new Compte(TypeCompte.courant);
        Compte cmp2 = new Compte(TypeCompte.eparne);
        cmp.setSolde(4000);
        cmp2.setSolde(1000);
        client1.addAccount(cmp);
        client1.addAccount(cmp2);
        boolean quitter = false;

        while (!quitter) {
            System.out.println("\n=== FinBank menu ===");
            System.out.println("1. Client");
            System.out.println("2. Gestionnaire");
            System.out.println("3. Quitter");
            System.out.print("Choisissez une option: ");

            int choix = scanner.nextInt();
            scanner.nextLine();

            switch (choix) {
                case 1:
                    menuClient(client1);
                    break;
                case 2:
                    menuGestionnaire(gestionnaire1);
                    break;
                case 3:
                    quitter = true;
                    System.out.println("Merci d'avoir utilisé FinBank!");
                    break;
                default:
                    System.out.println("Option invalide!");
            }
        }
    }

    private static void menuClient(Client client) {
        System.out.println("\n--- CLIENT ---");
            boolean deconnecter = false;

            while (!deconnecter) {
                System.out.println("\n--- MENU CLIENT ---");
                System.out.println("1. Consulter solde");
                System.out.println("2. Déposer argent");
                System.out.println("3. Retirer argent");
                System.out.println("4. Effectuer virement");
                System.out.println("5. Consulter historique transactions");
                System.out.println("6. Mes comptes");
                System.out.println("7. Déconnexion");
                System.out.print("Choisissez une option: ");

                int choix = scanner.nextInt();
                scanner.nextLine();

                switch (choix) {
                    case 1:
                        System.out.println("Votre solde total est: " + client.consulterSolde() + " DH");
                        break;
                    case 2:
                        System.out.println("--- DÉPÔT ---");
                        client.afficherMesComptes();
                        System.out.print("Numéro de compte: ");
                        int compteDepot = scanner.nextInt();
                        System.out.print("Montant: ");
                        float montantDepot = scanner.nextFloat();
                        scanner.nextLine();

                        Compte compteD = client.getCompte(compteDepot);
                        if (compteD != null) {
                            compteD.deposer(montantDepot);
                            System.out.println("Dépôt réussi !");
                        } else {
                            System.out.println("Compte introuvable");
                        }
                        break;
                    case 3:
                        System.out.println("--- RETRAIT ---");
                        client.afficherMesComptes();
                        System.out.print("Numéro de compte: ");
                        int compteRetrait = scanner.nextInt();
                        System.out.print("Montant: ");
                        float montantRetrait = scanner.nextFloat();
                        scanner.nextLine();

                        Compte compteDes = client.getCompte(compteRetrait);
                        if (compteDes != null) {
                            compteDes.retirer(montantRetrait);
                            System.out.println("Dépôt réussi !");
                        } else {
                            System.out.println("Compte introuvable");
                        }
                        break;
                    case 4:
                        System.out.println("--- VIREMENT ---");
                        client.afficherMesComptes();
                        System.out.print("Compte source: ");
                        int source = scanner.nextInt();
                        System.out.print("Compte destination: ");
                        int destination = scanner.nextInt();
                        System.out.print("Montant: ");
                        float montantVirement = scanner.nextFloat();
                        scanner.nextLine();

                        Compte compteSource = client.getCompte(source);
                        Compte compteDest = client.getCompte(destination);

                        if (compteSource != null && compteDest != null) {
                            client.virement(montantVirement, compteDest, compteSource);
                            System.out.println("Virement réussi !");
                        } else {
                            System.out.println("Compte(s) introuvable(s)");
                        }
                        break;
                    case 5:
                        System.out.println("--- HISTORIQUE ---");
                        client.afficherMesComptes();
                        System.out.print("Numéro de compte: ");
                        int compteHisto = scanner.nextInt();
                        scanner.nextLine();

                        Compte compteH = client.getCompte(compteHisto);
                        if (compteH != null) {
                            compteH.afficherHistorique();
                        } else {
                            System.out.println("Compte introuvable");
                        }
                        break;
                    case 6:
                        client.afficherMesComptes();
                        break;
                    case 7:
                        deconnecter = true;
                        System.out.println("Déconnexion réussie.");
                        break;
                    default:
                        System.out.println("Option invalide!");
                }
            }
    }

    private static void menuGestionnaire(Gestionnaire gestionnaire1) {
        System.out.println("\n--- MENU GESTIONNAIRE ---");
        boolean deconnecter = false;

        while (!deconnecter) {
            System.out.println("\nQue voulez-vous faire ?");
            System.out.println("1. Voir historique général");
            System.out.println("2. Créer un client");
            System.out.println("3. Clôturer un compte");
            System.out.println("4. Déconnexion");
            System.out.print("Votre choix: ");

            int choix = scanner.nextInt();
            scanner.nextLine();

            switch (choix) {
                case 1:
                    System.out.println("--- HISTORIQUE GÉNÉRAL ---");
                    gestionnaire1.historiqueAllTransaction();
                    break;

                  case 2:
                      System.out.println("--- CREER COMPTE ---");
                      System.out.println("tapez le nom du client");
                      String nom = scanner.nextLine();
                      scanner.nextLine();
                      System.out.println("tapez le prenom du client");
                      String prenom = scanner.nextLine();
                      scanner.nextLine();
                      System.out.println("tapez le email du client");
                      String email = scanner.nextLine();
                      scanner.nextLine();
                      System.out.println("tapez le mdp du client");
                      String mdp = scanner.nextLine();
                      scanner.nextLine();
                      Client nv_client =  new Client(nom, prenom, email, mdp);
                      Compte compte_initial = new Compte(TypeCompte.courant);
                      nv_client.addAccount(compte_initial);
                      System.out.println("account created succefully!");
                    break;

//                case 3:
//                    System.out.println("--- CLÔTURE DE COMPTE ---");
//                    System.out.print("Id du client: ");
//                    int idClient = scanner.nextInt();
//                    System.out.print("Numéro du compte à clôturer: ");
//                    int numCompte = scanner.nextInt();
//                    scanner.nextLine();
//
//                    if (client != null) {
//                        client.cloturer(numCompte);
//                    } else {
//                        System.out.println("Client introuvable");
//                    }
//                    break;

                case 4:
                    deconnecter = true;
                    System.out.println("Déconnexion réussie");
                    break;

                default:
                    System.out.println("Choix invalide");
            }
        }
    }

}
