import java.util.List;
import java.util.Scanner;

import entities.Agence;
import entities.Cheque;
import entities.Client;
import entities.Compte;
import entities.ETypeCompte;
import entities.Epargne;
//import entities.ETypeCompte;
import services.AgenceService;
import services.ClientService;
import services.CompteService;

public class View {
    public static void main(String[] args) throws Exception {
        int choix;
        Scanner sc=new Scanner(System.in);
        AgenceService agenceService=new AgenceService();
        ClientService clientService=new ClientService();
        CompteService compteService=new CompteService();
        sc.nextLine();
        do {
            System.out.println("1-Ajouter un Agence");
            System.out.println("2-Lister tous les Agences");
            System.out.println("3-Lister Agence par numero");
            System.out.println("4-Créer un Client");
            System.out.println("5-Lister tous les Clients");
            System.out.println("6-Ajouter une Compte");
            System.out.println("7-Lister tous les Comptes");
            System.out.println("8-Lister les Comptes d'un Client");
            System.out.println("10-Quitter");
                choix=sc.nextInt();
                sc.nextLine();
            switch (choix) {
                case 1:
                    System.out.println("Entrer un numero");
                    String numero=sc.nextLine();
                    System.out.println("Entrer un telephone");
                    String telephone=sc.nextLine();
                    System.out.println("Entrer une adresse");
                    String adresse=sc.nextLine();
                    Agence ag= new Agence();
                    ag.setNumero(numero);
                    ag.setTelephone(telephone);
                    ag.setAdresse(adresse);
                    agenceService.ajouterAgence(ag);
                break;

                case 2:
                    List<Agence> agences= agenceService.listerAgence();
                        for (Agence agence : agences) {
                            System.out.println("Numero "+ agence.getNumero());
                            System.out.println("Telephone "+ agence.getTelephone());
                            System.out.println("Adresse "+ agence.getAdresse());
                            System.out.println("================================");
                        }
                break;

                case 3:
                    System.out.println("Entrer un numero");
                    numero=sc.nextLine();
                    Agence agence= agenceService.listerAgence(numero);
                    if (agence!=null) {
                        System.out.println("Numero "+ agence.getNumero());
                        System.out.println("Telephone "+ agence.getTelephone());
                        System.out.println("Adresse "+ agence.getAdresse());
                        
                    }else{
                        System.out.println("Erreur sur le numero");
                    }
                break;

                case 4:
                    System.out.println("Entrer un nom");
                    String nom=sc.nextLine();
                    System.out.println("Entrer un prénom");
                    String prenom=sc.nextLine();
                    System.out.println("Entrer un telephone");
                    String tel=sc.nextLine();
                    Client client= new Client();
                    client.setNom(nom);
                    client.setPrenom(prenom);
                    client.settel(tel);;
                    clientService.ajouterClient(client);
            break;
            case 5:
                List<Client> clients= clientService.listerClient();
                for (Client cl : clients) {
                    System.out.println("Nom "+ cl.getNom());
                    System.out.println("Prénom "+ cl.getPrenom());
                    System.out.println("Téléphone "+ cl.gettel());
                    System.out.println("*******************************");
                }
            break;
            case 6:
                System.out.println("Entrer un numero");
                numero=sc.nextLine();
                System.out.println("Entrer le Solde");
                double solde=sc.nextDouble();
                System.out.println("Veuillez selectionner un type");
                System.out.println("1-Cheque");
                System.out.println("2-Epargne");
                int type=sc.nextInt();
                sc.nextLine();
                System.out.println("Entrer le telephone du client");
                tel=sc.nextLine();
                //Rechercher un client a travers son telephone
                client = clientService.listerClient(tel);
                if (client==null) {
                    System.out.println("Entrer un nom");
                    nom=sc.nextLine();
                    System.out.println("Entrer un prénom");
                    prenom=sc.nextLine();
                    client=new Client();
                    client.setNom(nom);
                    client.setPrenom(prenom);
                    client.settel(tel);;
                    clientService.ajouterClient(client);
                }
                if (type==1) {
                    System.out.println("Entrer le frais");
                    double frais=sc.nextDouble();
                    Cheque compte=new Cheque();
                    compte.setNum(numero);
                    compte.setSolde(solde);
                    compte.setFrais(frais);
                    compte.setType(ETypeCompte.Cheque);
                } else if(type==2){
                    System.out.println("Entrer le taux");
                    double taux=sc.nextDouble();
                    Epargne compte=new Epargne();
                    compte.setNum(numero);
                    compte.setSolde(solde);
                    compte.setTaux(taux);
                    compte.setType(ETypeCompte.Epargne);
                    compte.setClient(client);
                    compteService.ajouterCompte(compte);
                }   
                    }
            break;
            case 7:
                List<Compte> comptes= compteService.listerCompte();
                 for (Compte compte : comptes) {
                    System.out.println("Id "+ compte.getId());
                    System.out.println("Numero "+ compte.getNum());
                    System.out.println("Solde "+ compte.getSolde());
                    System.out.println("------------------------");
                }
             break;
           case 8:
              System.out.println("Entrer le telephone");
              tel=sc.nextLine(); 
              client=clientService.listerClient(tel);
               if (client==null) {
                System.out.println("Le client n'existe pas");
               }else{
               comptes=compteService.listerCompte();
               for (Compte cpte : comptes) {
                    System.out.println(cpte);
               }
            }
             break;
         default:
         break;   
            
        } while (choix!=10);       
}
}
