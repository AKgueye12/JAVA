import java.util.List;
import java.util.Scanner;

import Entities.Adresse;
import Entities.Client;
import Services.AdresseService;
import Services.ClientService;

public class View {
    public static void main(String[] args) throws Exception {
        int choix;
        Scanner sc = new Scanner(System.in);
        // Dependances
        AdresseService Adresseservice = new AdresseService();
        ClientService clientService = new ClientService();

        do {
            System.out.println("1-Ajouter un client ");
            System.out.println("2-Lister  les Clients");
            System.out.println("3-Ajouter une adresse et lui associe un client");
            System.out.println("4-Lister les adresse en affichant le nom du client");
            System.out.println("5-Quitter");
            choix = sc.nextInt();
            sc.nextLine();
        } while (choix != 5);

        switch (choix) {
            case 1:
                System.out.println("Entrer un nomComplet");
                String nomComplet = sc.nextLine();
                System.out.println("Entrer un Telephone");
                String tel = sc.nextLine();
                System.out.println("Entrer un email");
                String email = sc.nextLine();
                Client client = new Client();
                client.setNomComplet(nomComplet);
                client.setTelephone(tel);
                client.setEmail(email);
                clientService.ajouterClient(client);
                break;

            case 2:
                List<Client> clients = clientService.ListerClient();
                for (Client cl : clients) {
                    System.out.println("nomComplet:" + cl.getNomComplet());
                    System.out.println("Telephone:" + cl.getTelephone());
                    System.out.println("email:" + cl.getEmail());
                }
                break;
            case 3:
                System.out.println("entrer le nom de la ville");
                String ville = sc.nextLine();
                Adresse adresse = new Adresse();
                List<Client> clientss = clientService.ListerClient();
                for (Client cl : clientss) {
                    System.out.println("nomComplet" + clientss.getNomComplet());
                }

                break;
            case 4:
                List<Adresse> Adresse = Adresseservice.ListerAdresse();
                for (Adresse ad : Adresse) {
                    System.out.println("nomComplet:" + ad.getId());
                    System.out.println("Ville :" + ad.getVille());
                    System.out.println("quartier:" + ad.getQuartier());
                    System.out.println("numVilla:" + ad.getNumVilla());
                }
                break;

            default:
                break;
        }

    }
}
