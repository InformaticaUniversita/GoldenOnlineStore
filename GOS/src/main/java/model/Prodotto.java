package model;

import java.util.Objects;

/**
 * La classe Prodotto rappresenta un oggetto prodotto con informazioni come id,
 * nome, descrizione, prezzo, marca e categoria.
 * Ogni oggetto prodotto può essere identificato da un codice univoco.
 */
public class Prodotto {
    private int id;
    private String nome;
    private String descrizione;
    private float prezzo;
    private String marca;
    private int categoria;


    /**
     * Costruttore vuoto per un oggetto prodotto.
     * Viene utilizzato per creare un'istanza di prodotto senza specificare
     * valori iniziali.
     */
    public Prodotto() { }

    /** Questo costruttore permette di creare un nuovo oggetto prodotto inizializzando
     * i suoi attributi con i valori specificati.
     * @param id L'id del prodotto.
     * @param nome Il nome del prodotto.
     * @param descrizione La descrizione del prodotto.
     * @param prezzo Il prezzo del prodotto.
     * @param marca La marca del prodotto.
     * @param categoria La categoria del prodotto.
     */
    public Prodotto(int id, String nome, String descrizione, float prezzo, String marca, int categoria) {
        this.id = id;
        this.nome = nome;
        this.descrizione = descrizione;
        this.prezzo = prezzo;
        this.marca = marca;
        this.categoria = categoria;
    }

    /**
     * Metodo per restituire una stringa rappresentante l'oggetto prodotto.
     * @return Una stringa che contiene id, nome, descrizione, prezzo, marca e categoria.
     */
    @Override
    public String toString() {
        return "Prodotto{" +
                "id='" + id + '\'' +
                ", nome='" + nome + '\'' +
                ", descrizione='" + descrizione + '\'' +
                ", prezzo=" + prezzo +
                ", marca='" + marca + '\'' +
                ", categoria='" + categoria + '\'' +
                '}';
    }

    /**
     * Metodo per confrontare l'oggetto corrente con un'altro oggetto per determinare se sono uguali.
     * @param o Oggetto da confrontare con l'istanza corrente.
     * @return True se gli oggetti sono uguali, false altrimenti.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Prodotto prodotto = (Prodotto) o;
        return id == prodotto.id &&
                Float.compare(prodotto.prezzo, prezzo) == 0 &&
                Objects.equals(nome, prodotto.nome) &&
                Objects.equals(descrizione, prodotto.descrizione);
    }


    /**
     * Metodo per restituire un valore hash per l'oggetto prodotto.
     * @return Un valore hash basato sull'id, nome, descrizione e prezzo.
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, nome, descrizione, prezzo);
    }

    /**
     * Metodo per restituire l'id del prodotto.
     * @return L'id del prodotto.
     */
    public int getId() {
        return id;
    }

    /**
     * Metodo per modificare l'id del prodotto.
     * @param id L'id del prodotto.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Metodo per restituire il nome del prodotto.
     * @return Il nome del prodotto.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Metodo per modificare il nome del prodotto.
     * @param nome Il nome del prodotto.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Metodo per restituire la descrizione del prodotto.
     * @return La descrizione del prodotto.
     */
    public String getDescrizione() {
        return descrizione;
    }

    /**
     * Metodo per modificare la descrizione del prodotto.
     * @param descrizione La descrizione del prodotto.
     */
    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    /**
     * Metodo per restituire il prezzo del prodotto.
     * @return Il prezzo del prodotto.
     */
    public float getPrezzo() {
        return prezzo;
    }

    /**
     * Metodo per modificare il prezzo del prodotto.
     * @param prezzo Il prezzo del prodotto.
     */
    public void setPrezzo(float prezzo) {
        this.prezzo = prezzo;
    }

    /**
     * Metodo per restituire la marca del prodotto.
     * @return La marca del prodotto.
     */
    public String getMarca() {
        return marca;
    }

    /**
     * Metodo per restituire la categoria del prodotto.
     * @return La categoria del prodotto.
     */
    public int getCategoria() { return categoria;
    }

    /**
     * Metodo per modificare la categoria del prodotto.
     * @param categoria La categoria del prodotto.
     */
    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    /**
     * Metodo per modificare la marca del prodotto.
     * @param marca La marca del prodotto.
     */
    public void setMarca(String marca) {
        this.marca= marca;
    }
}