package Services;

import java.util.List;

import Entities.Adresse;
import Repository.AdresseRepository;



public class AdresseService {
    private AdresseRepository adresseRepository= new AdresseRepository();
    public void ajouterAdresse(Adresse adresse){
        adresseRepository.insertAdresse(adresse);
       }
    public List<Adresse> ListerAdresse(){
        return adresseRepository.getAllAdresse();
    }
}
