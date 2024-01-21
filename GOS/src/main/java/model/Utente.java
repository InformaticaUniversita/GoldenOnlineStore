package model;

import java.util.Objects;

/**
 * la classe Utente rappresenta un oggetto utente con informazioni come
 * username, email, password, nome e cognome.
 */
public class Utente {
    private String username;
    private String email;
    private String password;
    private String nome;
    private String cognome;

    /**
     * Costruttore vuoto per un oggetto Utente.
     * Viene utilizzato per creare un'istanza di Utente senza
     * specificare valori iniziali.
     */
    public Utente() { }

    /**
     * Questo costruttore permette di creare una nuova istanza di Utente
     * inizializzando i suoi attributi con i valori specificati.
     *
     * @param username L'username dell'account
     * @param email L'email dell'account
     * @param password La password dell'account
     * @param nome Il nome del proprietario dell'account
     * @param cognome Il cognome del proprietario dell'account
     */
    public Utente(String username, String email, String password, String nome, String cognome) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.nome = nome;
        this.cognome = cognome;
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
        Utente utente = (Utente) o;
        return Objects.equals(username, utente.username) && Objects.equals(email, utente.email) && Objects.equals(password, utente.password) && Objects.equals(nome, utente.nome) && Objects.equals(cognome, utente.cognome);
    }

    /**
     * Metodo per restituire un valore hash per l'oggetto Utente.
     * @return Un valore hash basato sull'username.sull'email,sulla password
     * e sul nome del proprietario dell'account.
     */
    @Override
    public int hashCode() {
        return Objects.hash(username, email, password, nome, cognome);
    }

    /**
     * Metodo per restituire l'username dell'account.
     * @return L'username dell'account.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Metodo per modificare l'username dell'account.
     * @param username L'username dell'account.
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Metodo per restituire l'email dell'account.
     * @return L'email dell'account.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Metodo per modificare l'email dell'account.
     * @param email L'email dell'account.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Metodo per restituire la password dell'account.
     * @return La password dell'account.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Metodo per modificare la password dell'account.
     * @param password La password dell'account.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Metodo per restituire il nome del proprietario dell'account.
     * @return Il nome del proprietario dell'account.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Metodo per modificare il nome del proprietario dell'account.
     * @param nome Il nome del proprietario dell'account.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Metodo per restituire il cognome del proprietario dell'account.
     * @return Il cognome del proprietario dell'account.
     */
    public String getCognome() {
        return cognome;
    }

    /**
     * Metodo per modificare il cognome del proprietario dell'account.
     * @param cognome Il cognome del proprietario dell'account.
     */
    public void setCognome(String cognome) {
        this.cognome = cognome;
    }
}