package repositories;

import java.util.ArrayList;
import java.util.List;

import entities.Compte;
public class CompteRepository {
     List<Compte> tComptes=new ArrayList<>();

     public List<Compte> selectAll(){
        return tComptes;
    }

     public Compte selectByNumero(String numero){
        for (Compte com : tComptes) {
            if (com.getNum().compareTo(numero)==0) {
                return com;
            }
        
        } 
        return null;
    }

     public void insert(Compte compte){
        tComptes.add(compte);
    }
}
