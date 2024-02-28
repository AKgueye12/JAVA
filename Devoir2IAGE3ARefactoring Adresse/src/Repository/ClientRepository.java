package Repository;

import java.util.ArrayList;
import java.util.List;

import Entities.Client;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ClientRepository extends Database {

    private final  String SQL_SELECT_ALL="select * from client" ;
    private final  String SQL_INSERT="INSERT INTO client (nomComplet, Telephone, email) VALUES (?,?,?)";
     public void insertClient(Client client){
        openConnexion();
        try {
          initPreparedStatement(SQL_INSERT);
          statement.setString(1,client.getNomComplet());
          statement.setString(2,client.getTelephone());
          statement.setString(3,client.getEmail());
          int nbreLigne= executeUpdate();
          closeConnexion();
        } catch (SQLException e) {
            System.out.println("Erreur de chargement de Driver");
        }
       }


    public List<Client> getALLClient(){
        List<Client> clients=new ArrayList<>();
        try {
            openConnexion();
            initPreparedStatement(SQL_SELECT_ALL);
            ResultSet rs= executeSelect();
            while (rs.next()) {
                Client client = new Client();
                client.setId(rs.getInt("id_client"));
                client.setNomComplet(rs.getString("nomComplet"));
                client.setTelephone(rs.getString("Telephone"));
                client.setEmail(rs.getString("email")); 
            }
            
        } catch (SQLException e) {
            System.out.println("Erreur de connexion a la BD");
        }
        return clients;
    }
}
