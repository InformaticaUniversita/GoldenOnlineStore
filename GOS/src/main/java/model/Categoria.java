package model;

import java.util.Objects;

/**
 * la classe Categoria rappresenta un oggetto categoria con informazioni come
 * nome e descrizione.
 * Ogni oggetto Categoria può essere identificato da un codice univoco.
 */
public class Categoria {
    private int id;
    private String nome;
    private String descrizione;

    /**
     * Metodo per restituire una stringa rappresentante l'oggetto Categoria.
     * @return Una stringa che contiene l'identificatore e il nome della categoria.
     */
    @Override
    public String toString() {
        return "Categoria{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }
    /**
     * Metodo per confrontare l'oggetto corrente con un altro oggetto per determinare se sono uguali.
     * @param o Oggetto da confrontare con l'istanza corrente.
     * @return True se gli oggetti sono uguali, altrimenti False.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Categoria categoria = (Categoria)o;
        return id == categoria.id &&
                Objects.equals(nome, categoria.nome);
    }

    /**
     * Metodo per restituire un valore hash per l'oggetto Categoria.
     * @return Un valore hash basato sull'identificatore e il nome della categoria.
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, nome);
    }


    /**
     * Costruttore vuoto per un oggetto Categoria.
     * Viene utilizzato per creare un'istanza di Categoria senza
     * specificare valori iniziali.
     */
    public Categoria() {
    }

    /**
     * Metodo per restituire l'identidicatore.
     * @return L'identificatore della categoria.
     */
    public int getId() {
        return id;
    }

    /**
     * Metodo per modificare l'identificatore di una categoria.
     * @param id L'identificatore di una categoria.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Metodo per restituire il nome di una categoria.
     * @return Il nome della categoria.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Metodo per modificare il nome di una categoria.
     * @param nome Il nome della categoria.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Metodo per modificare la descrizione di una categoria.
     * @param descrizione La descrizione della categoria.
     */
    public void setDescrizione(String descrizione){this.descrizione=descrizione;}

    /**
     * Metodo per restituire la descrizione di una categoria.
     * @return la descrizione della categoria.
     */
    public String getDescrizione() {return descrizione; }
}
