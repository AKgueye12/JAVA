package Services;

import java.util.List;

import Entities.Client;
import Repository.ClientRepository;

public class ClientService {
    private ClientRepository clientRepository= new ClientRepository();

    public void ajouterClient(Client client){
        clientRepository.insertClient(client);
       }
    public List<Client> ListerClient(){
        return clientRepository.getALLClient();
    }
}
