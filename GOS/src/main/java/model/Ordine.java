package model;

import java.sql.Date;

/**
 * La classe Ordine rappresenta un oggetto ordine con informazioni come id, cliente
 * data ordine, data spedizione e prezzo totale.
 * Ogni oggetto Ordine può essere identificato da un codice univoco.
 */
public class Ordine {
    int id;
    String cliente;// viene inserito l'username del cliente
    Date dataOrdine;
    Date dataSpedizione;

    float prezzoTotale;

    /**
     * Questo costruttore permette di creare un nuovo oggetto Ordine inizializzando
     * i suoi attributi con i valori specificati.
     * @param cliente L'username del cliente che effettua l'ordine.
     * @param dataOrdine La data in cui è effettuato l'ordine.
     * @param dataSpedizione La data in cui è spedito l'ordine.
     * @param prezzoTotale Il prezzo totale dell'ordine.
     */
    public Ordine(String cliente, Date dataOrdine, Date dataSpedizione, float prezzoTotale ) {
        this.cliente=cliente;
        this.dataOrdine = dataOrdine;
        this.dataSpedizione = dataSpedizione;
        this.prezzoTotale = prezzoTotale;
    }

    /**
     * Costruttore vuoto per un oggetto Ordine.
     * Viene utilizzato per creare un'istanza di Ordine senza specificare
     * valori iniziali.
     */
    public Ordine() {
    }

    /**
     * Metodo per restituire l'username del cliente che ha effettuato l'ordine.
     * @return L'username del cliente che ha effettuato l'ordine.
     */
    public String getCliente(){return cliente;}

    /**
     * Metodo per modificare l'username del cliente che ha effettuato l'ordine.
     * @param cliente  L'username del cliente che ha effettuato l'ordine.
     */
    public void setCliente(String cliente){this.cliente= cliente; }

    /**
     * Metodo per restituire la data in cui è stato effettuato l'ordine.
     * @return La data in cui è stato effettuato l'ordine.
     */
    public Date getDataOrdine() {
        return dataOrdine;
    }

    /**
     * Metodo per modificare la data in cui è stato effettuato l'ordine.
     * @param dataOrdine  La data in cui è stato effettuato l'ordine.
     */
    public void setDataOrdine(Date dataOrdine) {
        this.dataOrdine = dataOrdine;
    }

    /**
     * Metodo per restituire la data in cui è stato spedito l'ordine.
     * @return La data in cui è stato spedito l'ordine.
     */
    public Date getDataSpedizione() {
        return dataSpedizione;
    }

    /**
     * Metodo per modificare la data in cui è stato spedito l'ordine.
     * @param dataSpedizione  La data in cui è stato spedito l'ordine.
     */
    public void setDataSpedizione(Date dataSpedizione) {
        this.dataSpedizione = dataSpedizione;
    }

    /**
     * Metodo per restituire l'id dell'ordine.
     * @return L'id dell'ordine.
     */
    public int getId() {
        return id;
    }

    /**
     * Metodo per modificare l'id dell'ordine.
     * @param id L'id dell'ordine.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Metodo per restituire il prezzo totale dell'ordine.
     * @return Il prezzo totale dell'ordine.
     */
    public float getPrezzoTotale() {
        return prezzoTotale;
    }

    /**
     * Metodo per modificare il prezzo totale dell'ordine.
     * @param prezzoTotale Il prezzo totale dell'ordine.
     */
    public void setPrezzoTotale(float prezzoTotale) {
        this.prezzoTotale = prezzoTotale;
    }
}
