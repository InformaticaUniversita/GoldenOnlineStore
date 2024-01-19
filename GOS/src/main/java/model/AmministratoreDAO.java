package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * La classe AmministratoreDAO fornisce metodi per interagire con il database
 * per le operazioni relative agli oggetti amministratore.
 * È responsabile della persistenza e del recupero dei dati degli amministratori.
 *
 * Gli oggetti di questa classe dovrebbero essere utilizzati per accedere e manipolare
 * le informazioni degli amministratori nel database.
 *
 * La classe utilizza la connessione al database fornita da ConnectionPool per
 * garantire una gestione corretta delle risorse e delle eccezioni SQL.
 */
public class AmministratoreDAO {

    /**
     * Metodo che recupera un oggetto amministratore dal database utilizzando l'username come criterio di ricerca.
     *
     * @param username L'username dell'amministratore da cercare nel database.
     * @return Un amministratore corrispondente all'username fornito, o null se non trovato.
     * @throws RuntimeException Se si verifica un'eccezione di tipo SQLException durante l'accesso al database.
     */
    public Amministratore doRetrieveByUsername(String username){
        try(Connection con = ConnectionPool.getConnection()){
            PreparedStatement ps = con.prepareStatement("SELECT username,email, password, nome, cognome, codicediaccesso FROM amministratore WHERE username =?");
            ps.setString(1,username);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                Amministratore p = new Amministratore();
                p.setUsername(rs.getString(1));
                p.setEmail(rs.getString(2));
                p.setPassword(rs.getString(3));
                p.setNome(rs.getString(4));
                p.setCognome(rs.getString(5));
                p.setCodice(rs.getInt(6));
                return p;
            }
            return null;
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }

    /**
     * Metodo che recupera un oggetto amministratore dal database utilizzando il codice di accesso come criterio di ricerca.
     *
     * @param codice Il codice di accesso dell'amministratore da cercare nel database.
     * @return Un amministratore corrispondente al codice di accesso fornito, o null se non trovato.
     * @throws RuntimeException Se si verifica un'eccezione di tipo SQLException durante l'accesso al database.
     */
    public Amministratore doRetrieveByCodice(int codice){
        try(Connection con = ConnectionPool.getConnection()){
            PreparedStatement ps = con.prepareStatement("SELECT username,email, password, nome, cognome,  codicediaccesso FROM amministratore WHERE codicediaccesso =?");
            ps.setInt(1,codice);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                Amministratore p = new Amministratore();
                p.setUsername(rs.getString(1));
                p.setEmail(rs.getString(2));
                p.setPassword(rs.getString(3));
                p.setNome(rs.getString(4));
                p.setCognome(rs.getString(5));
                p.setCodice(rs.getInt(6));
                return p;
            }
            return null;
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }

    /**
     * Metodo che recupera una lista di amministratori dal database con un indice di partenza e un numero
     * massimo di amministratori da recuperare.
     *
     * @param offset L'indice di partenza di amministratori da recuperare.
     * @param limit Il numero massimo di amministratori da recuperare.
     * @return Una lista di amministratori recuperati dal database.
     * @throws RuntimeException Se si verifica un'eccezione di tipo SQLException durante l'accesso al database.
     */
    public List<Amministratore> doRetrieveAll(int offset, int limit){
        try(Connection con = ConnectionPool.getConnection()){
            PreparedStatement ps = con.prepareStatement("SELECT username, email, password, nome, cognome, codicediaccesso FROM amministratore LIMIT ?,?  ");
            ps.setInt(1,offset);
            ps.setInt(2,limit);
            List<Amministratore> amministratori= new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Amministratore u= new Amministratore();
                u.setUsername(rs.getString(1));
                u.setEmail(rs.getString(2));
                u.setPassword(rs.getString(3));
                u.setNome(rs.getString(4));
                u.setCognome(rs.getString(5));
                u.setCodice(rs.getInt(6));
                amministratori.add(u);
            }
            return amministratori;

        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

    /**
     * Metodo che recupera un oggetto amministratore dal database utilizzando username, password e codice di accesso come criteri di ricerca.
     *
     * @param username L'username dell'amministratore da cercare nel database.
     * @param password La password dell'amministratore da cercare nel database.
     * @param code Il codice di accesso dell'amministratore da cercare nel database.
     * @return Un amministratore corrispondente agli input forniti, o null se non trovato.
     * @throws RuntimeException Se si verifica un'eccezione di tipo SQLException durante l'accesso al database.
     */
    public Amministratore doRetrieveByUsernamePasswordCode(String username, String password, int code){
        try(Connection con= ConnectionPool.getConnection()){
            PreparedStatement ps = con.prepareStatement(
                    "SELECT username, email, password, nome, cognome, codicediaccesso FROM amministratore WHERE username=? AND password = ? AND codicediaccesso=?");
            ps.setString(1,username);
            ps.setString(2,password);
            ps.setInt(3,code);

            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                Amministratore p= new Amministratore();
                p.setUsername(rs.getString(1));
                p.setEmail(rs.getString(2));
                p.setPassword(rs.getString(3));
                p.setNome(rs.getString(4));
                p.setCognome(rs.getString(5));
                p.setCodice(rs.getInt(6));

                return p;
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}