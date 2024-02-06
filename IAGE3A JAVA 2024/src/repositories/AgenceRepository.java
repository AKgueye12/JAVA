package repositories;

import java.util.List;
import java.util.ArrayList;

import entities.Agence;

public class AgenceRepository {
    //SOLID
    //Single Responsability

    //Table
    List<Agence> tAgences=new ArrayList<>();
    //Select * from agence where numero=numero

    public List<Agence> selectAll(){
        return tAgences;
    }

   public Agence selectByNumero(String numero){
        for (Agence ag : tAgences) {
            if (ag.getNumero().compareTo(numero)==0) {
                return ag;
            }
        
        } 
        return null;
    }
    //Update
    //Delete
    //Insert

    public void insert(Agence agence){
        tAgences.add(agence);
    }
}
