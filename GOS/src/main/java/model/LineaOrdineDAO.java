package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * La classe LineaOrdineDAO fornisce metodi per interagire con il database
 * per le operazioni relative agli oggetti LineaOrdine.
 * E' responsabile della persistenza e del recupero dei dati delle linee d'ordine.
 *
 * Gli oggetti di questo classe dovrebbero essere utilizzati per accedere e manipolare
 * le informazioni  delle linee d'ordine nel database.
 *
 * La classe utilizza la connessione al database fornita da ConnectionPool per
 * garantire una gestione corretta delle risorse e delle eccezioni SQL.
 */
public class LineaOrdineDAO {
    /**
     * Metodo che recupera le linee d'ordine associate ad un ordine specifico dal database.
     *
     * @param ordine L'id univoco dell'ordine associato alle linee d'ordine da recuperare.
     * @return Una lista di linee d'ordine associate all'ordine specificato.
     * @throws RuntimeException Se si verifica un'eccezione SQLException durante l'operazione di recupero.
     */
    public List<LineaOrdine> doRetrieveByOrdine(int ordine){
        try(Connection con = ConnectionPool.getConnection()){
            PreparedStatement ps = con.prepareStatement("SELECT lineadordine.prodotto, lineadordine.quantità, lineadordine.prezzounitario FROM lineadordine WHERE lineadordine.ordine=?");
            ps.setInt(1,ordine);
            ResultSet rs = ps.executeQuery();
            List<LineaOrdine> Linee = new ArrayList<LineaOrdine>();
            while (rs.next()){
                LineaOrdine l = new LineaOrdine();
                l.setIdOrdine(ordine);
                l.setIdProdotto(rs.getInt(1));
                l.setQuantità(rs.getInt(2));
                l.setPrezzoUnitario(rs.getFloat(3));
                Linee.add(l);
            }
            return Linee;
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    /**
     * Metodo che salva una nuova linea d'ordine nel database.
     *
     * @param lineaOrdine L'oggetto LineaOrdine da salvare nel database.
     * @throws RuntimeException Se si verifica un'eccezione SQLException durante l'operazione di salvataggio.
     */
    public void doSave(LineaOrdine lineaOrdine){
        try(Connection con = ConnectionPool.getConnection()){
            PreparedStatement ps = con.prepareStatement("INSERT INTO lineadordine(lineadordine.ordine, lineadordine.prodotto, lineadordine.quantità, lineadordine.prezzounitario) VALUES (?,?,?,?)");
            ps.setInt(1,lineaOrdine.getIdOrdine());
            ps.setInt(2,lineaOrdine.getIdProdotto());
            ps.setInt(3,lineaOrdine.getQuantità());
            ps.setFloat(4,lineaOrdine.getPrezzoUnitario());
            if(ps.executeUpdate() != 1){
                throw new RuntimeException("INSERT error");
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

}
