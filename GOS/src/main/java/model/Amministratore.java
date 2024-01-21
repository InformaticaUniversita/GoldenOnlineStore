package model;

/**
 * La classe amministratore rappresenta un oggetto amministratore con informazioni come username,
 * email, password, nome, cognome e codice.
 * Ogni oggetto amministratore può essere identificato da un codice univoco.
 */
public class Amministratore {
    private String username;
    private String email;
    private String password;
    private String nome;
    private String cognome;
    private int codice;

    /**
     * Questo costruttore permette di creare un nuovo oggetto amministratore inizializzando
     * i suoi attributi con i valori specificati.
     * @param username L'username dell'amministratore.
     * @param email L'email dell'amministratore.
     * @param password La password dell'amministratore.
     * @param nome Il nome dell'amministratore.
     * @param cognome Il cognome dell'amministratore.
     * @param codice Il codice dell'amministratore.
     */
    public Amministratore(String username, String email, String password, String nome, String cognome, int codice) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.nome = nome;
        this.cognome = cognome;
        this.codice = codice;
    }

    /**
     * Costruttore vuoto per un oggetto amministratore.
     * Viene utilizzato per creare un'istanza di amministratore senza specificare
     * valori iniziali.
     */
    public Amministratore() { }

    /**
     * Metodo per restituire l'username dell'amministratore.
     * @return L'username dell'amministratore.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Metodo per modificare l'username dell'amministratore.
     * @param username L'username dell'amministratore da modificare.
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Metodo per restituire l'email dell'amministratore.
     * @return L'email dell'amministratore.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Metodo per modificare l'email dell'amministratore.
     * @param email L'email dell'amministratore da modificare.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Metodo per restituire la password dell'amministratore.
     * @return La password dell'amminstratore.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Metodo per modificare la password dell'amministratore.
     * @param password La password dell'amministratore da modificare.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Metodo per restituire il nome dell'amministratore.
     * @return Il nome dell'amministratore.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Metodo per modificare il nome dell'amministratore.
     * @param nome Il nome dell'amministratore da modificare.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Metodo per restituire il cognome dell'amministratore.
     * @return Il cognome dell'amministratore.
     */
    public String getCognome() {
        return cognome;
    }

    /**
     * Metodo per modificare il cognome dell'amministratore.
     * @param cognome Il cognome dell'amministratore da modificare.
     */
    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    /**
     * Metodo per restituire il codice dell'amministratore.
     * @return Il codice dell'amministratore.
     */
    public int getCodice() {
        return codice;
    }

    /**
     * Metodo per modificare il codice dell'amministratore.
     * @param codice Il codice dell'amminstratore da modificare.
     */
    public void setCodice(int codice) {
        this.codice = codice;
    }
}