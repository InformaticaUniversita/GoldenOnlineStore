package model;

public class Indirizzo {
    private int id;
    private String via;
    private String cap;
    private String citta;

    public Indirizzo() { }

    public Indirizzo(int id, String via, String cap, String citta) {
        this.id = id;
        this.via = via;
        this.cap = cap;
        this.citta = citta;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVia() {
        return via;
    }

    public void setVia(String via) {
        this.via = via;
    }

    public String getCap() {
        return cap;
    }

    public void setCap(String cap) {
        this.cap = cap;
    }

    public String getCitta() {
        return citta;
    }

    public void setCitta(String citta) {
        this.citta = citta;
    }
}
