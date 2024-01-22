package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * La classe UtenteDAO fornisce metodi per interagire con il database
 * per le operazioni relative agli oggetti utente.
 * E' responsabile della persistenza e del recupero dei dati degli utenti.
 *
 * Gli oggetti di questo classe dovrebbero essere utilizzati per accedere e manipolare
 * le informazioni degli utenti nel database.
 *
 * La classe utilizza la connessione al database fornita da ConnectionPool per
 * garantire una gestione corretta delle risorse e delle eccezioni SQL.
 */
public class UtenteDAO {

    /**
     * Metodo che recupera un utente dal database basato sull'username specificato.
     *
     * @param username L'username dell'utente da recuperare.
     * @return Un utente corrispondente all'username specificato, o null se non trovato.
     * @throws RuntimeException Se si verifica un'eccezione SQLException durante l'operazione di recupero.
     */
    public Utente doRetrieveByUsername(String username){
        try(Connection con = ConnectionPool.getConnection()){
            PreparedStatement ps = con.prepareStatement("SELECT username, email, password, nome, cognome FROM cliente WHERE username =?");
            ps.setString(1,username);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                Utente p = new Utente();
                p.setUsername(rs.getString(1));
                p.setEmail(rs.getString(2));
                p.setPassword(rs.getString(3));
                p.setNome(rs.getString(4));
                p.setCognome(rs.getString(5));
                return p;
            }
            return null;
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }

    /**
     * Metodo che recupera un utente dal database basato sull'email specificata.
     *
     * @param email L'email dell'utente da recuperare.
     * @return Un utente corrispondente all'email specificato, o null se non trovato.
     * @throws RuntimeException Se si verifica un'eccezione SQLException durante l'operazione di recupero.
     */
    public Utente doRetrieveByEmail(String email){
        try(Connection con = ConnectionPool.getConnection()){
            PreparedStatement ps = con.prepareStatement("SELECT username, email, password, nome, cognome FROM cliente WHERE email =?");
            ps.setString(1,email);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                Utente p = new Utente();
                p.setUsername(rs.getString(1));
                p.setEmail(rs.getString(2));
                p.setPassword(rs.getString(3));
                p.setNome(rs.getString(4));
                p.setCognome(rs.getString(5));
                return p;
            }
            return null;
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }

    /**
     * Metodo che modifica le credenziali dell'utente nel database utilizzando l'username
     * come criterio di ricerca.
     *
     * @param utente L'utente con le credenziali aggiornate.
     * @param username l'username da utilizzare come criterio di ricerca.
     * @throws RuntimeException Se si verifica un'eccezione SQLException durante l'operazione di recupero.
     */
    public void doUpdateCredenziali(Utente utente, String username) {
        try (Connection con = ConnectionPool.getConnection();
             PreparedStatement ps = con.prepareStatement("UPDATE cliente SET email=?, password=? WHERE username=?")) {

            ps.setString(1, utente.getEmail());
            ps.setString(2, utente.getPassword());
            ps.setString(3, utente.getUsername());

            int result = ps.executeUpdate();

            if (result != 1) {
                // Se l'aggiornamento non ha avuto successo, puoi gestire l'errore qui.
                throw new RuntimeException("Failed to update user credentials");
            }

        } catch (SQLException e) {
            // Puoi loggare l'eccezione o fornire informazioni più dettagliate sull'errore.
            throw new RuntimeException("Error updating user credentials", e);
        }
    }

    /**
     * Metodo che salva un nuovo utente nel database.
     *
     * @param utente L'utente da salvare nel database.
     * @throws RuntimeException Se si verifica un'eccezione SQLException durante l'operazione di salvataggio.
     */
    public void doSave(Utente utente){
        try(Connection c = ConnectionPool.getConnection()){

            PreparedStatement ps = c.prepareStatement("INSERT INTO cliente(username, email, password, nome, cognome) VALUES (?, ?, ?, ?, ?)");
            ps.setString(1, utente.getUsername());
            ps.setString(2, utente.getEmail());
            ps.setString(3, utente.getPassword());
            ps.setString(4, utente.getNome());
            ps.setString(5, utente.getCognome());
            ps.executeUpdate();
            //if(ps.executeUpdate() != 1)
            // throw new RuntimeException("INSERT error");
        } catch (SQLException e){
            throw new RuntimeException();
        }
    }


    /**
     * Metodo che recupera un elenco di utenti dal database con un indice di partenza e un numero massimo
     * di utenti da recuperare.
     *
     * @param offset L'indice di partenza di utenti da recuperare.
     * @param limit Il numero massimo di utenti da recuperare.
     * @return Una lista di utenti recuperati dal database.
     * @throws RuntimeException Se si verifica un'eccezione SQLException durante l'operazione di recupero.
     */
    public List<Utente> doRetrieveAll(int offset, int limit){
        try(Connection con = ConnectionPool.getConnection()){
            PreparedStatement ps = con.prepareStatement("SELECT username, email, password, nome FROM cliente LIMIT ?,?  ");
            ps.setInt(1,offset);
            ps.setInt(2,limit);
            List<Utente> utenti= new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Utente u= new Utente();
                u.setUsername(rs.getString(1));
                u.setEmail(rs.getString(2));
                u.setPassword(rs.getString(3));
                u.setNome(rs.getString(4));
                u.setCognome(rs.getString(5));
                utenti.add(u);
            }
            return utenti;

        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

    /**
     * Recupera un utente dal database basato sul nome utente e sulla password specificati.
     *
     * @param username L'username dell'utente da recuperare.
     * @param password La password dell'utente da recuperare.
     * @return Un utente corrispondente allo username e alla password specificati, o null se non trovato.
     * @throws RuntimeException Se si verifica un'eccezione SQLException durante l'operazione di recupero.
     */
    public Utente doRetrieveByUsernamePassword(String username, String password){
        try(Connection con= ConnectionPool.getConnection()){
            PreparedStatement ps = con.prepareStatement(
                    "SELECT username, email, password, nome, cognome FROM cliente WHERE username=? AND password = ?");
            ps.setString(1,username);
            ps.setString(2,password);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                Utente p= new Utente();
                p.setUsername(rs.getString(1));
                p.setEmail(rs.getString(2));
                p.setPassword(rs.getString(3));
                p.setNome(rs.getString(4));
                p.setCognome(rs.getString(5));
                return p;
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
