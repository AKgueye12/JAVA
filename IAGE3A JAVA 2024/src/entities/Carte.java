package entities;

import java.util.Date;

public class Carte {
    private int id;
    private int numero;
    private Date dateExpiration;

    //ManyToOne: plusieurs cartes peuvent etre dans une compte.
    Compte compte;

    public Compte getCompte() {
        return compte;
    }
    public void setCompte(Compte compte) {
        this.compte = compte;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getNumero() {
        return numero;
    }
    public void setNumero(int numero) {
        this.numero = numero;
    }
    public Date getDateExpiration() {
        return dateExpiration;
    }
    public void setDateExpiration(Date dateExpiration) {
        this.dateExpiration = dateExpiration;
    }
    public Carte() {
    }
}
