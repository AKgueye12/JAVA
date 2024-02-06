package services;

import java.util.List;

import entities.Client;
import repositories.ClientRepository;

public class ClientService {
   
    private ClientRepository clientRepository=new ClientRepository();
    public List<Client> listerClient(){
        return clientRepository.selecAll();
    }
    public Client listerClient(String tel){
        return clientRepository.selectByTelephone(tel);
    }
    public void ajouterClient(Client Client){
        clientRepository.insert(Client);
    }

}
