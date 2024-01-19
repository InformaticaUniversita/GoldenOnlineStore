package model;

/**
 * La classe LineaOrdine rappresenta un oggetto linea d'ordine con informazioni come
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

    /**
     * Questo costruttore permette di creare una nuova istanza di LineaOrdine
     * inizializzando i suoi attributi con i valori specificati.
     *
     * @param idOrdine L'id univoco dell'ordine associato alla linea d'ordine.
     * @param idProdotto L'id univoco del prodotto associato alla linea d'ordine.
     * @param quantità La quantità di un prodotto nella linea d'ordine.
     * @param prezzoUnitario Il prezzo totale del prodotto nella linea d'ordine.
     */
    public LineaOrdine(int idOrdine, int idProdotto, int quantità, float prezzoUnitario) {
        this.idOrdine = idOrdine;
        this.idProdotto = idProdotto;
        this.quantità = quantità;
        this.prezzoUnitario = prezzoUnitario;
    }

    /**
     * Metodo per restituire l'id di un ordine.
     * @return L'id di un ordine.
     */
    public int getIdOrdine() {
        return idOrdine;
    }

    /**
     * Metodo per modificare l'id di un ordine .
     * @param idOrdine L'id dell'ordine.
     */
    public void setIdOrdine(int idOrdine) {
        this.idOrdine = idOrdine;
    }

    /**
     * Metodo per restituire l'id di un prodotto di una linea d'ordine.
     * @return L'id di un prodotto di una linea d'ordine.
     */
    public int getIdProdotto() {
        return idProdotto;
    }

    /**
     * Metodo per modificare l'id di prodotto di una linea d'ordine.
     * @param idProdotto L'id dell'ordine di una linea d'ordine.
     */
    public void setIdProdotto(int idProdotto) {
        this.idProdotto = idProdotto;
    }

    /**
     * Metodo per restituire la quantità di un prodotto di una linea d'ordine.
     * @return La quantità di un prodotto di una linea d'ordine.
     */
    public int getQuantità() {
        return quantità;
    }

    /**
     * Metodo per modificare la quantità di prodotto di una linea d'ordine.
     * @param quantità La quantità di un prodotto di una linea d'ordine.
     */
    public void setQuantità(int quantità) {
        this.quantità = quantità;
    }

    /**
     * Metodo per restituire il prezzo totale di una linea d'ordine.
     * @return Il prezzo totale di una linea d'ordine.
     */
    public float getPrezzoUnitario() {
        return prezzoUnitario;
    }

    /**
     * Metodo per modificare il prezzo totale di una linea d'ordine.
     * @param  prezzoUnitario Il prezzo totale di una linea d'ordine.
     */
    public void setPrezzoUnitario(float prezzoUnitario) {
        this.prezzoUnitario = prezzoUnitario;
    }
}
