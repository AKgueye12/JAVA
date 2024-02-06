package services;


import java.util.List;

import entities.Compte;

import repositories.CompteRepository;

public class CompteService {
    private CompteRepository compteRepository=new CompteRepository();
   

    public List<Compte> listerCompte(){
        return compteRepository.selectAll();
    }

     public Compte listerCompte(String numero){
        return compteRepository.selectByNumero(numero);
    }

    
      public void ajouterCompte(Compte compte){
        compteRepository.insert(compte);
    }
}
