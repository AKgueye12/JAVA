package Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Entities.Adresse;
import Entities.Client;

public class AdresseRepository extends Database {
    private final  String SQL_SELECT_ALL="select * from Adresse a, client c, where a.id_client= c.id_client " ;
    private final  String SQL_INSERT="INSERT INTO client (Ville, quartier , nomVilla) VALUES (?,?,?)";

    public void insertAdresse(Adresse adresse){
        openConnexion();
        try {
          initPreparedStatement(SQL_INSERT);
          statement.setString(1,adresse.getVille());
          statement.setString(2,adresse.getQuartier());
          statement.setInt(3,adresse.getNumVilla());
          int nbreLigne= executeUpdate();
          closeConnexion();
        } catch (SQLException e) {
            System.out.println("Erreur de chargement de Driver");
        }
       }


    public List<Adresse> getAllAdresse(){
        List<Adresse> adresses=new ArrayList<>();
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
                Adresse adresse = new Adresse();
                adresse.setVille(rs.getString("Ville"));
                adresse.setQuartier(rs.getString("Quartier"));
                adresse.setNumVilla(rs.getInt("numVilla"));
                adresses.add(adresse);
            }
            
        } catch (SQLException e) {
            System.out.println("Erreur de connexion a la BD");
        }
        return adresses;
    }
}
