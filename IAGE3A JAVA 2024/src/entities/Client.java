package entities;

import java.util.ArrayList;
import java.util.List;

public class Client {
    private int id;
    private String nom;
    private String prenom;
    private String tel;

    //OneToMany: Un client peut avoir plusieurs comptes.
    List<Compte> comptes=new ArrayList<>();
    public List<Compte> getComptes() {
        return comptes;
    }
    public void setComptes(List<Compte> comptes) {
        this.comptes = comptes;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getPrenom() {
        return prenom;
    }
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    public String gettel() {
        return tel;
    }
    public void settel(String tel) {
        this.tel = tel;
    }
    public Client() {
    }

    
}
