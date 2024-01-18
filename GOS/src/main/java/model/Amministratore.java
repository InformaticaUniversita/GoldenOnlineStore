package model;

/**
 * La classe Amministratore rappresenta un oggetto amministratore con informazioni come username,
 * email, password, nome, cognome e codice.
 * Ogni oggetto Amministratore può essere identificato da un codice univoco.
 */
public class Amministratore {
    private String username;
    private String email;
    private String password;
    private String nome;
    private String cognome;
    private String codice;

    /**
     * Questo costruttore permette di creare un nuovo oggetto Amministratore inizializzando
     * i suoi attributi con i valori specificati.
     * @param username L'username dell'Amministratore.
     * @param email L'email dell'Amministratore.
     * @param password La password dell'Amministratore.
     * @param nome Il nome dell'Amministratore.
     * @param cognome Il cognome dell'Amministratore.
     * @param codice Il codice dell'Amministratore.
     */
    public Amministratore(String username, String email, String password, String nome, String cognome, String codice) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.nome = nome;
        this.cognome = cognome;
        this.codice = codice;
    }

    /**
     * Costruttore vuoto per un oggetto Amministratore.
     * Viene utilizzato per creare un'istanza di Amministratore senza specificare
     * valori iniziali.
     */
    public Amministratore() { }

    /**
     * Metodo per restituire l'username dell'Amministratore.
     * @return L'username dell'Amministratore.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Metodo per modificare l'username dell'Amministratore.
     * @param username L'username da modificare.
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Metodo per restituire l'email dell'Amministratore.
     * @return L'email dell'Amministratore.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Metodo per modificare l'email dell'Amministratore.
     * @param email L'email dell'Amministratore.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Metodo per restituire la password dell'Amministratore.
     * @return La password dell'Amminstratore.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Metodo per modificare la password dell'Amministratore.
     * @param password La password dell'Amministratore.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Metodo per restituire il nome dell'Amministratore.
     * @return Il nome dell'Amministratore.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Metodo per modificare il nome dell'Amministratore.
     * @param nome Il nome dell'Amministratore.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Metodo per restituire il cognome dell'Amministratore.
     * @return Il cognome dell'Amministratore.
     */
    public String getCognome() {
        return cognome;
    }

    /**
     * Metodo per modificare il cognome dell'Amministratore.
     * @param cognome Il cognome dell'Amministratore.
     */
    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    /**
     * Metodo per restituire il codice dell'Amministratore.
     * @return Il codice dell'Amministratore.
     */
    public String getCodice() {
        return codice;
    }

    /**
     * Metodo per modificare il codice dell'Amministratore.
     * @param codice Il codice dell'Amminstratore.
     */
    public void setCodice(String codice) {
        this.codice = codice;
    }
}