package model;

import javax.persistence.OrderBy;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * La classe ProdottoDAO fornisce metodi per interagire con il database
 * per le operazioni relative agli oggetti Prodotto.
 * E' responsabile della persistenza e del recupero dei dati dei prodotti.
 *
 * Gli oggetti di questo classe dovrebbero essere utilizzati per accedere e manipolare
 * le informazioni dei prodotti nel database.
 *
 * La classe utilizza la connessione al database fornita da ConnectionPool per
 * garantire una gestione corretta delle risorse e delle eccezioni SQL.
 */

public class ProdottoDAO {
    public enum OrderBy{
        DEFAULT(""), PREZZO_ASC("ORDER BY prezzo ASC"), PREZZO_DESC("ORDER BY prezzo DESC");
        public final String sql;

        private OrderBy(String sql){
            this.sql=sql;
        }
    }

    /**
     * Recupera una lista di prodotti dal database con un limite inferiore e superiore.
     *
     * @param offset Il numero minimo di prodotti da recuperare.
     * @param limit Numero massimo di prodotti da recuperare.
     * @return Una lista di oggetti Prodotto che rappresentano i prodotti nel database.
     * @throws RuntimeException Se si verifica un'eccezione SQLException durante l'esecuzione della query.
     */
    public List<Prodotto>doRetrieveAll(int offset,int limit) {
        try (Connection con = ConnectionPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement("SELECT prodotto.id,prodotto.nome,prodotto.descrizione,prodotto.marca,prodotto.prezzo FROM prodotto limit ?,?");
            ps.setInt(1, offset);
            ps.setInt(2, limit);
            ResultSet rs = ps.executeQuery();

            ArrayList<Prodotto> prodotti = new ArrayList<>();
            while (rs.next()) {
                Prodotto P = new Prodotto();
                P.setId(rs.getInt(1));
                P.setNome(rs.getString(2));
                P.setDescrizione(rs.getString(3));
                P.setMarca((rs.getString(4)));
                P.setPrezzo(rs.getFloat(5));
                prodotti.add(P);
            }
            return prodotti;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    /**
     * Recupera un singolo prodotto dal database identificato dal suo ID.
     *
     * @param id L'identificativo univoco del prodotto da recuperare.
     * @return Un oggetto Prodotto che rappresenta il prodotto nel database con l'ID specificato,o null se non trovato.
     * @throws RuntimeException Se si verifica un'eccezione SQLException durante l'esecuzione della query.
     */
    public Prodotto doRetrieveById(int id){
        try(Connection con =ConnectionPool.getConnection()){
            PreparedStatement ps=con.prepareStatement("SELECT prodotto.id,prodotto.nome,prodotto.descrizione,prodotto.marca,prodotto.prezzo FROM prodotto WHERE id=?");
            ps.setInt(1,id);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                Prodotto P=new Prodotto();
                P.setId(rs.getInt(1));
                P.setNome(rs.getString(2));
                P.setDescrizione(rs.getString(3));
                P.setMarca((rs.getString(4)));
                P.setPrezzo(rs.getFloat(5));
                return P;
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    /**
     * Recupera una lista di prodotti dal database che corrispondono a un dato nome, utilizzando la ricerca full-text.
     * Limita il numero di risultati restituiti e utilizza offset e limit per la paginazione.
     *
     * @param nome Il termine di ricerca per il nome dei prodotti.
     * @param offset Il numero minimo di prodotti da recuperare.
     * @param limit Il numero massimo di prodotti da recuperare.
     * @return Una lista di oggetti Prodotto che corrispondono al nome cercato nel database.
     * @throws RuntimeException Se si verifica un'eccezione SQLException durante l'esecuzione della query.
     */
    public List<Prodotto> doRetrieveByNome(String nome,int offset,int limit) {
        try (Connection con = ConnectionPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement("SELECT prodotto.id,prodotto.nome,prodotto.descrizione,prodotto.marca,prodotto.prezzo FROM prodotto WHERE MATCH (nome)AGAINST(? IN BOOLEAN MODE) LIMIT ?,?");
            ps.setString(1, nome);
            ps.setInt(2, offset);
            ps.setInt(3, limit);
            ArrayList<Prodotto> prodotti = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Prodotto P=new Prodotto();
                P.setId(rs.getInt(1));
                P.setNome(rs.getString(2));
                P.setDescrizione(rs.getString(3));
                P.setMarca((rs.getString(4)));
                P.setPrezzo(rs.getFloat(5));
                prodotti.add(P);
            }
            return prodotti;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Conta il numero totale di prodotti associati a una categoria specifica nel database.
     *
     * @param categoria L'identificativo univoco della categoria di prodotti.
     * @return Il numero totale di prodotti associati alla categoria specificata.
     * @throws RuntimeException Se si verifica un'eccezione SQLException durante l'esecuzione della query.
     */

    public int countByCategoria(int categoria){
        try(Connection con = ConnectionPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement("SELECT COUNT(prodotto.nome) FROM prodotto JOIN categoria ON prodotto.categoria= categoria.id WHERE categoria.id =?");
            ps.setInt(1,categoria);
            ResultSet rs = ps.executeQuery();
            rs.next();
            return rs.getInt(1);
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    /**
     * Recupera una lista di prodotti dal database che corrispondono a una data descrizione, utilizzando la ricerca.
     * Limita il numero di risultati restituiti e utilizza offset e limit per la paginazione.
     *
     * @param descrizione Il termine di ricerca per la descrizione dei prodotti.
     * @param offset Il numero minimo di prodotti da recuperare.
     * @param limit Il numero massimo di prodotti da recuperare.
     * @return Una lista di oggetti Prodotto che corrispondono alla descrizione cercata nel database.
     * @throws RuntimeException Se si verifica un'eccezione SQLException durante l'esecuzione della query.
     */
    public List<Prodotto> doRetrieveByDescrizione(String descrizione,int offset,int limit) {
        try (Connection con = ConnectionPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement("SELECT prodotto.id,prodotto.nome,prodotto.descrizione,prodotto.marca,prodotto.prezzo,prodotto.categoria FROM prodotto WHERE MATCH (descrizione)AGAINST(? IN BOOLEAN MODE) LIMIT ?,?");
            ps.setString(1, descrizione);
            ps.setInt(2, offset);
            ps.setInt(3, limit);
            ArrayList<Prodotto> prodotti = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Prodotto P=new Prodotto();
                P.setId(rs.getInt(1));
                P.setNome(rs.getString(2));
                P.setDescrizione(rs.getString(3));
                P.setMarca((rs.getString(4)));
                P.setPrezzo(rs.getFloat(5));
                prodotti.add(P);
            }
            return prodotti;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    /**
     * Recupera una lista di prodotti dal database che appartengono a una categoria specifica,
     * ordinati secondo un criterio specificato.
     *
     * @param categoria Identificatore della categoria dei prodotti da recuperare.
     * @param orderBy Criterio di ordinamento per i risultati della query.
     * @param offset Il numero minimo di prodotti da recuperare.
     * @param limit Il numero massimo di prodotti da recuperare.
     * @return Una lista di oggetti Prodotto che appartengono alla categoria specificata, ordinati secondo il criterio specificato.
     * @throws RuntimeException Se si verifica un'eccezione SQLException durante l'esecuzione della query.
     */
    public List<Prodotto> doRetrieveByCategoria(int categoria, OrderBy orderBy, int offset, int limit) {
        try (Connection con = ConnectionPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement("SELECT prodotto.id,prodotto.nome,prodotto.descrizione,prodotto.marca,prodotto.prezzo FROM prodotto, categoria WHERE prodotto.categoria=categoria.id AND categoria.id=? "+orderBy.sql+" LIMIT ?,?");
            ps.setInt(1, categoria);
            ps.setInt(2, offset);
            ps.setInt(3, limit);
            ArrayList<Prodotto> prodotti = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Prodotto P = new Prodotto();
                P.setId(rs.getInt(1));
                P.setNome(rs.getString(2));
                P.setDescrizione(rs.getString(3));
                P.setMarca((rs.getString(4)));
                P.setPrezzo(rs.getFloat(5));
                prodotti.add(P);
            }
            return prodotti;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    /**
     * Salva un nuovo prodotto nel database con le informazioni specificate.
     *
     * @param prodotto Oggetto Prodotto da salvare nel database.
     * @param idCategoria Identificatore della categoria a cui appartiene il prodotto.
     * @throws RuntimeException Se si verifica un'eccezione SQLException durante l'inserimento del prodotto nel database.
     */
    public void doSave(Prodotto prodotto, int idCategoria){
        try(Connection con = ConnectionPool.getConnection()){
            PreparedStatement ps = con.prepareStatement("INSERT  INTO prodotto(nome, descrizione, marca, prezzo, categoria) VALUES(?,?,?,?,?,?)");
            ps.setString(1,prodotto.getNome());
            ps.setString(2,prodotto.getDescrizione());
            ps.setInt(3,prodotto.getId());
            ps.setString(4,prodotto.getMarca());
            ps.setFloat(5,prodotto.getPrezzo());
            ps.setInt(6,idCategoria);
            if(ps.executeUpdate() != 1){
                throw new RuntimeException("INSERT error,");
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    /**
     * Aggiorna le informazioni di un prodotto esistente nel database con i nuovi valori specificati.
     *
     * @param prodotto Oggetto Prodotto con le nuove informazioni.
     * @param idCategoria Identificatore della nuova categoria a cui appartiene il prodotto.
     * @throws RuntimeException Se si verifica un'eccezione SQLException durante l'aggiornamento delle informazioni del prodotto nel database.
     */
    public void doUpdate(Prodotto prodotto,int idCategoria){
        try(Connection con = ConnectionPool.getConnection()){
            PreparedStatement ps=con.prepareStatement("UPDATE prodotto SET nome=?, descrizione=?, marca=?, prezzo=?, categoria=? WHERE id =?");
            ps.setString(1,prodotto.getNome());
            ps.setString(2,prodotto.getDescrizione());
            ps.setString(3,prodotto.getMarca());
            ps.setFloat(4,prodotto.getPrezzo());
            ps.setInt(5,idCategoria);
            ps.setInt(6,prodotto.getId());
            if (ps.executeUpdate() != 1){
                throw new RuntimeException("UPDATE error.");
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    /**
     * Elimina un prodotto dal database utilizzando l'identificatore specificato.
     *
     * @param id Identificatore del prodotto da eliminare.
     * @throws RuntimeException Se si verifica un'eccezione SQL durante l'eliminazione del prodotto dal database.
     */
    public void doDelete(String id){
        try(Connection con = ConnectionPool.getConnection()){
            PreparedStatement ps = con.prepareStatement("DELETE FROM prodotto WHERE id=?");
            ps.setString(1, id);
            if(ps.executeUpdate() != 1){
                throw new RuntimeException("UPDATE error .");
            }

        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

}