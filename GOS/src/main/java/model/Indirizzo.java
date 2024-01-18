package model;

/**
 * La classe Indirizzo rappresenta un oggetto indirizzo con informazioni come via, CAP e città.
 * Ogni oggetto Indirizzo può essere identificato da un ID univoco.
 */
public class Indirizzo {
    private int id;
    private String via;
    private String cap;
    private String citta;

    /**
     * Costruttore vuoto per un oggetto Indirizzo.
     * Viene utilizzato per creare un'istanza di Indirizzo senza specificare
     * valori iniziali.
     */
    public Indirizzo() { }

    /**
     * Costruttore per creare un oggetto Indirizzo con valori iniziali specificati.
     * @param id L'ID univoco dell'indirizzo.
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
     * Metodo per restituire l'id dell'Indirizzo.
     * @return L'id dell'Indirizzo.
     */
    public int getId() {
        return id;
    }

    /**
     * Metodo per modificare l'id dell'Indirizzo.
     * @param id L'id dell'Indirizzo.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Metodo per restituire la via dell'Indirizzo.
     * @return La via dell'Indirizzo.
     */
    public String getVia() {
        return via;
    }

    /**
     * Metodo per modificare la via dell'Indirizzo.
     * @param via  La via dell'Indirizzo.
     */
    public void setVia(String via) {
        this.via = via;
    }

    /**
     * Metodo per restituire il cap dell'Indirizzo.
     * @return Il cap dell'Indirizzo.
     */
    public String getCap() {
        return cap;
    }

    /**
     * Metodo per modificare il cap dell'Indirizzo.
     * @param cap  Il cap dell'Indirizzo.
     */
    public void setCap(String cap) {
        this.cap = cap;
    }

    /**
     * Metodo per restituire la città dell'Indirizzo.
     * @return La città dell'Indirizzo.
     */
    public String getCitta() {
        return citta;
    }

    /**
     * Metodo per modificare la città dell'Indirizzo.
     * @param citta  La città dell'Indirizzo.
     */
    public void setCitta(String citta) {
        this.citta = citta;
    }
}
