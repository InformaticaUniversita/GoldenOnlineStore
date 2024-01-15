package model;

import java.sql.Date;

public class Ordine {
    int id;
    String cliente;// viene inserito l'username del cliente
    Date dataOrdine;
    Date dataSpedizione;

    float prezzoTotale;


    public Ordine(String cliente, Date dataOrdine, Date dataSpedizione, float prezzoTotale ) {
        this.cliente=cliente;
        this.dataOrdine = dataOrdine;
        this.dataSpedizione = dataSpedizione;
        this.prezzoTotale = prezzoTotale;
    }

    public Ordine() {
    }

    public String getCliente(){return cliente;}

    public void setCliente(String cliente){this.cliente= cliente; }

    public Date getDataOrdine() {
        return dataOrdine;
    }

    public void setDataOrdine(Date dataOrdine) {
        this.dataOrdine = dataOrdine;
    }

    public Date getDataSpedizione() {
        return dataSpedizione;
    }

    public void setDataSpedizione(Date dataSpedizione) {
        this.dataSpedizione = dataSpedizione;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getPrezzoTotale() {
        return prezzoTotale;
    }

    public void setPrezzoTotale(float prezzoTotale) {
        this.prezzoTotale = prezzoTotale;
    }
}
