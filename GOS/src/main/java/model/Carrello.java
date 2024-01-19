package model;

import java.util.*;


/**
 * La classe Carrello rappresenta un carrello di acquisti contenente prodotti
 * e le relative quantità. Utilizza una struttura dati basata su mappa per
 * associare ogni prodotto a una quantità nel carrello.
 * La classe Carrello fornisce metodi per ottenere, aggiungere, rimuovere e calcolare
 * il prezzo totale dei prodotti presenti nel carrello. Inoltre, è possibile ottenere
 * la lista completa dei prodotti presenti nel carrello.
 */

public class Carrello {
    /**
     * La classe interna ProdottoQuantità gestisce le istanze di un prodotto nel carrello,
     * mantenendo informazioni come il prodotto stesso, la quantità e fornendo metodi per
     * accedere e modificare queste informazioni.
     */
    public static class ProdottoQuantità {
        private Prodotto prodotto;
        private int quantità;

        /**
         * Un oggetto ProdottoQuantità ha un prodotto e una quantità.
         * Questo costruttore permette di creare una nuova istanza di un prodotto
         * inizializzando i suoi attributi con i valori specificati.
         * @param prodotto Il prodotto della linea del carrello.
         * @param quantità La quantità del prodotto della linea del carrello.
         */
        public ProdottoQuantità(Prodotto prodotto, int quantità){
            this.prodotto = prodotto;
            this.quantità = quantità;
        }

        /**
         * Costruttore vuoto per un oggetto ProdottoQuantità.
         * Viene utilizzato per creare un'istanza di ProdottoQuantità senza
         * specificare valori iniziali.
         */
        public ProdottoQuantità() { }

        /**
         * Metodo per restituire il prodotto di una linea del carrello.
         * @return Il prodotto di una linea del carrello.
         */
        public Prodotto getProdotto() {
            return prodotto;
        }

        /**
         * Metodo per modificare il prodotto di una linea del carrello.
         * @param prodotto Il prodotto di una linea del carrello.
         */
        public void setProdotto(Prodotto prodotto) {
            this.prodotto = prodotto;
        }

        /**
         * Metodo per restituire la quantità di un prodotto di una linea del carrello.
         * @return la quantità del prodotto di una linea del carrello.
         */
        public int getQuantità() {
            return quantità;
        }

        /**
         * Metodo per modificare la quantità di un prodotto di una linea del carrello.
         * @param quantità La quantità del prodotto di una linea del carrello.
         */
        public void setQuantità(int quantità) {
            this.quantità = quantità;
        }

        /**
         * Metodo per restituire il prezzo totale dei prodotti di una linea del carrello.
         * @return Il prezzo totale dei prodotti di una linea del carrello.
         */
        public float getPrezzoTot() {
            return quantità * prodotto.getPrezzo();
        }
    }

    private LinkedHashMap<Integer, ProdottoQuantità> prodotti = new LinkedHashMap<>();


    /**
     * Metodo per restituire tutti i prodotti all'interno del carrello.
     * @return Tutti i prodotti all'interno del carrello.
     */
    public List<ProdottoQuantità> getProdottiArray(){
        ArrayList<ProdottoQuantità> pq = new ArrayList<ProdottoQuantità>();
        Iterator it = prodotti.entrySet().iterator();
        while (it.hasNext()){
            Map.Entry entry= (Map.Entry) it.next();
            ProdottoQuantità p =(ProdottoQuantità) entry.getValue();
            System.out.println(p.getProdotto().getNome());
            pq.add(p);
        }
        return pq;
    }

    /**
     * Metodo per restituire un prodotto ricercato tramite id.
     * @param prodId L'id del prodotto.
     * @return Il prodotto e la corrispettiva quantità.
     */
    public ProdottoQuantità get(int prodId){
        return prodotti.get(prodId);
    }

    /**
     * Metodo per aggiungere un prodotto e la corrispettiva quantità.
     * @param prodotto Il prodotto da aggiungere.
     * @param quantità La quantità del prodotto da aggiungere.
     */
    public void put(Prodotto prodotto, int quantità){
        prodotti.put(Integer.valueOf(prodotto.getId()), new ProdottoQuantità(prodotto, quantità));
    }

    /**
     * Metodo per rimuovere un prodotto ricercato tramite id.
     * @param prodId L'id del prodotto.
     * @return Il prodotto rimosso e la corrispettiva quantità.
     */
    public ProdottoQuantità remove(int prodId) {
        return prodotti.remove(prodId);
    }

    /**
     * Metodo per ottenere il prezzo totale di tutti i prodotti del carrello.
     * @return il prezzo totale di tutti i prodotti.
     */
    public float getPrezzoTot(){
        return (float) prodotti.values().stream().mapToDouble(p->p.getPrezzoTot()).sum();
    }
}
