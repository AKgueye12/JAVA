package Entities;


public class Adresse {
    private int id;
    private String ville; 
    private String quartier;
    private int numVilla;
    

    private Client client;
    public Client getClient() {
        return client;
    }
    public void setClient(Client client) {
        this.client = client;
    }
    public Adresse() {
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getVille() {
        return ville;
    }
    public void setVille(String ville) {
        this.ville = ville;
    }
    public String getQuartier() {
        return quartier;
    }
    public void setQuartier(String quartier) {
        this.quartier = quartier;
    }
    public int getNumVilla() {
        return numVilla;
    }
    public void setNumVilla(int numVilla) {
        this.numVilla = numVilla;
    }
    
}
