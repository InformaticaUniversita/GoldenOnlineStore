package model;

/**
 * la classe LineaOrdine rappresenta un oggetto linea d'ordine con informazioni come
 * id dell'ordine, id del prodotto, quantità del prodotto e prezzo totale.
 */
public class LineaOrdine {
    int idOrdine;
    int idProdotto;
    int quantità;
    float prezzoUnitario;

    /**
     * Costruttore vuoto per un oggetto LineaOrdine.
     * Viene utilizzato per creare un'istanza di LineaOrdine senza
     * specificare valori iniziali.
     */
    public LineaOrdine() {
    }

    /**identificativo
     * Questo metodo permette di creare una nuova istanza di LineaOrdine
     * inizializzando i suoi attributi con i valori specificati.
     *
     * @param idOrdine L'identificatore univoco dell'ordine associato alla linea di ordine.
     * @param idProdotto L'identificativo univoco del prodotto associato alla linea di ordine.
     * @param quantità La quantità di un prodotto nella linea di ordine.
     * @param prezzoUnitario Il prezzo totale del prodotto nella linea di ordine.
     */
    public LineaOrdine(int idOrdine, int idProdotto, int quantità, float prezzoUnitario) {
        this.idOrdine = idOrdine;
        this.idProdotto = idProdotto;
        this.quantità = quantità;
        this.prezzoUnitario = prezzoUnitario;
    }

    /**
     * Metodo per restituire l'identificativo di un ordine.
     * @return L'identificativo univoco di un ordine.
     */
    public int getIdOrdine() {
        return idOrdine;
    }

    /**
     * Metodo per modificare l'identificativo di un ordine .
     * @param idOrdine L'identificativo dell'ordine.
     */
    public void setIdOrdine(int idOrdine) {
        this.idOrdine = idOrdine;
    }

    /**
     * Metodo per restituire l'identificativo di un prodotto.
     * @return L'identificativo univoco di un prodotto.
     */
    public int getIdProdotto() {
        return idProdotto;
    }

    /**
     * Metodo per modificare l'identificativo di prodotto .
     * @param idProdotto L'identificativo dell'ordine.
     */
    public void setIdProdotto(int idProdotto) {
        this.idProdotto = idProdotto;
    }

    /**
     * Metodo per restituire la quantità di un prodotto.
     * @return La quantità di un prodotto.
     */
    public int getQuantità() {
        return quantità;
    }

    /**
     * Metodo per modificare la quantità di prodotto .
     * @param quantità La quantità di un prodotto.
     */
    public void setQuantità(int quantità) {
        this.quantità = quantità;
    }

    /**
     * Metodo per restituire il prezzo totale di una linea.
     * @return il prezzo totale di una linea.
     */
    public float getPrezzoUnitario() {
        return prezzoUnitario;
    }

    /**
     * Metodo per modificare il prezzo totale della linea .
     * @param  prezzoUnitario il prezzo totale della linea.
     */
    public void setPrezzoUnitario(float prezzoUnitario) {
        this.prezzoUnitario = prezzoUnitario;
    }
}
