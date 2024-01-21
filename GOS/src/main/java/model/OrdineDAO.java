package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * La classe OrdineDAO fornisce metodi per interagire con il database
 * per le operazioni relative agli oggetti ordine.
 * È responsabile della persistenza e del recupero dei dati degli ordini.
 *
 * Gli oggetti di questa classe dovrebbero essere utilizzati per accedere e manipolare
 * le informazioni degli ordini nel database.
 *
 * La classe utilizza la connessione al database fornita da ConnectionPool per
 * garantire una gestione corretta delle risorse e delle eccezioni SQL.
 */
public class OrdineDAO {

    private static String DO_RETRIEVE_BY_ID = "SELECT id_ordine, cliente, dataordine, dataspedizione, prezzoTotale FROM ordine WHERE id_ordine =?";

    /**
     * Metodo che recupera una lista di ordini dal database utilizzando l'username del cliente come criterio di ricerca.
     * @param username L'username del cliente per il quale recuperare gli ordini.
     * @return Una lista di ordini corrispondenti all'username fornito.
     * @throws RuntimeException Se si verifica un'eccezione di tipo SQLException durante l'accesso al database.
     */
    public List<Ordine> doRetrieveByUsername(String username){
        try(Connection con = ConnectionPool.getConnection()){
            PreparedStatement ps = con.prepareStatement("SELECT id_ordine, cliente, dataordine, dataspedizione, prezzoTotale FROM ordine WHERE cliente =?");
            ps.setString(1,username);
            ResultSet rs = ps.executeQuery();
            List<Ordine> ordini = new ArrayList<>();
            while(rs.next()){
                Ordine o = new Ordine();
                o.setId(rs.getInt(1));
                o.setCliente(rs.getString(2));
                o.setDataOrdine(rs.getDate(3));
                o.setDataSpedizione(rs.getDate(4));
                o.setPrezzoTotale(rs.getFloat(5));
                ordini.add(o);
            }
            return ordini;
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    /**
     * Metodo che salva un nuovo ordine nel database e restituisce l'id generato per l'ordine appena inserito.
     * @param ordine L'oggetto ordine da salvare nel database.
     * @return L'id generato per l'ordine appena inserito nel database.
     * @throws RuntimeException Se si verifica un'eccezione di tipo SQLException durante l'accesso al database.
     */
    public int doSave (Ordine ordine){
        try (Connection con = ConnectionPool.getConnection()){
            PreparedStatement ps = con.prepareStatement("INSERT INTO ordine(cliente, dataordine, dataspedizione, prezzoTotale) VALUES(?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            ps.setString(1,ordine.getCliente());
            ps.setDate(2,ordine.getDataOrdine());
            ps.setDate(3,ordine.getDataSpedizione());
            ps.setFloat(4, ordine.getPrezzoTotale());
            if(ps.executeUpdate() != 1){
                throw new RuntimeException("INSERT error");
            }
            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            int id = rs.getInt(1);
            System.out.println(id);
            return id;
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    /**
     * Metodo che cancella un ordine dal database utilizzando l'username del cliente e l'id dell'ordine come criteri di ricerca.
     * @param idOrdine L'id dell'ordine da cancellare dal database.
     * @throws RuntimeException Se si verifica un'eccezione di tipo SQLException durante l'accesso al database.
     */
    public void doDelete (int idOrdine){
        try (Connection con = ConnectionPool.getConnection()){
            PreparedStatement ps = con.prepareStatement("DELETE FROM ordine WHERE id_ordine=?");
            ps.setInt(1,idOrdine);
            if(ps.executeUpdate() !=1){
                throw new RuntimeException("DELETE error");
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    /**
     * Metodo che recupera un ordine dal database utilizzando l'id dell'ordine come criterio di ricerca.
     * @param id_ordine L'id dell'ordine da cercare nel database.
     * @return Un ordine corrispondente all'id fornito, o null se non trovato.
     * @throws RuntimeException Se si verifica un'eccezione di tipo SQLException durante l'accesso al database.
     */
    public Ordine doRetrieveById(int id_ordine){
        try(Connection con = ConnectionPool.getConnection()){
            PreparedStatement ps = con.prepareStatement(DO_RETRIEVE_BY_ID);
            ps.setInt(1,id_ordine);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                Ordine o = new Ordine();
                o.setId(rs.getInt(1));
                o.setCliente(rs.getString(2));
                o.setDataOrdine(rs.getDate(3));
                o.setDataSpedizione(rs.getDate(4));
                o.setPrezzoTotale(rs.getFloat(5));
                return o;
            }
            return null;
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
