package entities;

import java.util.ArrayList;
import java.util.List;

public class Compte {
    private int id;
    private String num;
    private double solde;
    private ETypeCompte type;

    //Propriete Navigationnelle
    //ManyToOne: plusieurs comptes crées dans une Agence
    //OneToMany: Une compte peut avoir plusieurs cartes.
    //ManyToOne: plusieurs comptes crées dans un Client
    Agence agence;
    List<Carte> cartes=new ArrayList<>();
    Client client;

    public Client getClient() {
        return client;
    }
    public void setClient(Client client) {
        this.client = client;
    }
    public Agence getAgence() {
        return agence;
    }
    public void setAgence(Agence agence) {
        this.agence = agence;
    }
    public ETypeCompte getType() {
        return type;
    }
    public void setType(ETypeCompte type) {
        this.type = type;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNum() {
        return num;
    }
    public void setNum(String num) {
        this.num = num;
    }
    public double getSolde() {
        return solde;
    }
    public void setSolde(double solde) {
        this.solde = solde;
    }
    public Compte() {
    }
}
