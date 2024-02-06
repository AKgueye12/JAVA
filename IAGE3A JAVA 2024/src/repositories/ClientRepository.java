package repositories;

import java.util.List;
import java.util.ArrayList;


import entities.Client;
public class ClientRepository {
    List<Client> tClients=new ArrayList<>();
    
    public List<Client> selecAll(){
        return tClients;
    }

      public Client selectByTelephone(String tel){
        for (Client cl : tClients) {
            if (cl.gettel().compareTo(tel)==0) {
                return cl;
            }
        
        } 
        return null;
    }
    public void insert(Client client){
        tClients.add(client);
    }
}
