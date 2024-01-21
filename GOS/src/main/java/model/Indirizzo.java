package model;

/**
 * La classe Indirizzo rappresenta un oggetto indirizzo con informazioni come via, CAP e città.
 * Ogni oggetto indirizzo può essere identificato da un id univoco dell'ordine associato.
 */
public class Indirizzo {
    private int idOrdine;
    private String via;
    private String cap;
    private String citta;

    /**
     * Costruttore vuoto per un oggetto indirizzo.
     * Viene utilizzato per creare un'istanza di indirizzo senza specificare
     * valori iniziali.
     */
    public Indirizzo() { }

    /**
     * Costruttore per creare un oggetto indirizzo con valori iniziali specificati.
     * @param idOrdine L'id dell'ordine associato.
     * @param via La via dell'indirizzo.
     * @param cap Il codice di avviamento postale (CAP) dell'indirizzo.
     * @param citta La città dell'indirizzo.
     */
    public Indirizzo(int idOrdine, String via, String cap, String citta) {
        this.idOrdine = idOrdine;
        this.via = via;
        this.cap = cap;
        this.citta = citta;
    }

    /**
     * Metodo per restituire l'id dell'ordine associato.
     * @return L'id dell'ordine associato.
     */
    public int getId() {
        return idOrdine;
    }

    /**
     * Metodo per modificare l'id dell'ordine associato.
     * @param idOrdine L'id dell'ordine associato.
     */
    public void setId(int idOrdine) {
        this.idOrdine = idOrdine;
    }

    /**
     * Metodo per restituire la via dell'indirizzo.
     * @return La via dell'indirizzo.
     */
    public String getVia() {
        return via;
    }

    /**
     * Metodo per modificare la via dell'indirizzo.
     * @param via  La via dell'indirizzo.
     */
    public void setVia(String via) {
        this.via = via;
    }

    /**
     * Metodo per restituire il cap dell'indirizzo.
     * @return Il cap dell'indirizzo.
     */
    public String getCap() {
        return cap;
    }

    /**
     * Metodo per modificare il cap dell'indirizzo.
     * @param cap  Il cap dell'indirizzo.
     */
    public void setCap(String cap) {
        this.cap = cap;
    }

    /**
     * Metodo per restituire la città dell'indirizzo.
     * @return La città dell'indirizzo.
     */
    public String getCitta() {
        return citta;
    }

    /**
     * Metodo per modificare la città dell'indirizzo.
     * @param citta  La città dell'indirizzo.
     */
    public void setCitta(String citta) {
        this.citta = citta;
    }
}
