package model;

/**
 * La classe Indirizzo rappresenta un oggetto indirizzo con informazioni come via, CAP e città.
 * Ogni oggetto indirizzo può essere identificato da un id univoco.
 */
public class Indirizzo {
    private int id;
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
     * @param id L'id univoco dell'indirizzo.
     * @param via La via dell'indirizzo.
     * @param cap Il codice di avviamento postale (CAP) dell'indirizzo.
     * @param citta La città dell'indirizzo.
     */
    public Indirizzo(int id, String via, String cap, String citta) {
        this.id = id;
        this.via = via;
        this.cap = cap;
        this.citta = citta;
    }

    /**
     * Metodo per restituire l'id dell'indirizzo.
     * @return L'id dell'indirizzo.
     */
    public int getId() {
        return id;
    }

    /**
     * Metodo per modificare l'id dell'indirizzo.
     * @param id L'id dell'indirizzo.
     */
    public void setId(int id) {
        this.id = id;
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
