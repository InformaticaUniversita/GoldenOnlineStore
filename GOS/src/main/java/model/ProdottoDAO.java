package model;

import javax.persistence.OrderBy;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * La classe ProdottoDAO fornisce metodi per interagire con il database
 * per le operazioni relative agli oggetti prodotto.
 * E' responsabile della persistenza e del recupero dei dati dei prodotti.
 *
 * Gli oggetti di questo classe dovrebbero essere utilizzati per accedere e manipolare
 * le informazioni dei prodotti nel database.
 *
 * La classe utilizza la connessione al database fornita da ConnectionPool per
 * garantire una gestione corretta delle risorse e delle eccezioni SQL.
 */

public class ProdottoDAO {


    /**
     * Enumerazione che rappresenta le opzioni di ordinamento per le query.
     */
    public enum OrderBy{
        DEFAULT(""), PREZZO_ASC("ORDER BY prezzo ASC"), PREZZO_DESC("ORDER BY prezzo DESC");
        public final String sql;

        private OrderBy(String sql){
            this.sql=sql;
        }
    }

    /**
     * Metodo che recupera una lista di prodotti dal database con un indice di partenza e un numero massimo di prodotti da recuperare.
     *
     * @param offset L'indice di partenza dei prodotti.
     * @param limit Il numero massimo di prodotti da recuperare.
     * @return Una lista di prodotti che rappresentano i prodotti nel database.
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
     * Metodo che recupera un singolo prodotto dal database identificato dal suo id.
     *
     * @param id L'id univoco del prodotto da recuperare.
     * @return Un prodotto con l'id specificato, o null se non trovato.
     * @throws RuntimeException Se si verifica un'eccezione SQLException durante l'esecuzione della query.
     */
    public Prodotto doRetrieveById(int id){
        try(Connection con =ConnectionPool.getConnection()){
            PreparedStatement ps=con.prepareStatement("SELECT prodotto.id,prodotto.nome,prodotto.descrizione,prodotto.marca,prodotto.prezzo, prodotto.categoria FROM prodotto WHERE id=?");
            ps.setInt(1,id);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                Prodotto P=new Prodotto();
                P.setId(rs.getInt(1));
                P.setNome(rs.getString(2));
                P.setDescrizione(rs.getString(3));
                P.setMarca((rs.getString(4)));
                P.setPrezzo(rs.getFloat(5));
                P.setCategoria(rs.getInt(6));
                return P;
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    /**
     * Metodo che recupera una lista di prodotti dal database con un indice di partenza e un
     * numero massimo di prodotti da recuperare utilizzando il nome come criterio di ricerca.
     *
     * @param nome Il nome dei prodotti da ricercare.
     * @param offset L'indice di partenza dei prodotti da recuperare.
     * @param limit Il numero massimo di prodotti da recuperare.
     * @return Una lista di prodotti che corrispondono al nome cercato nel database.
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
     * Metodo che conta il numero totale di prodotti associati a una categoria specifica nel database.
     *
     * @param categoria L'id univoco della categoria di prodotti da contare.
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
     * Metodo che recupera una lista di prodotti dal database con un indice di partenza e un numero massimo
     * di prodotti da recuperare utilizzando la descrizione come criterio di ricerca.
     *
     * @param descrizione La descrizione dei prodotti da recuperare.
     * @param offset L'indice di partenza dei prodotti da recuperare.
     * @param limit Il numero massimo di prodotti da recuperare.
     * @return Una lista di prodotti che corrispondono alla descrizione cercata nel database.
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
     * Metodo che recupera una lista di prodotti dal database che appartengono a una categoria specifica,
     * ordinati secondo un criterio specificato, un indice di partenza e un numero massimo di prodotti da recuperare.
     *
     * @param categoria L'id della categoria dei prodotti da recuperare.
     * @param orderBy Criterio di ordinamento per i risultati della query.
     * @param offset L'indice di partenza dei prodotti da recuperare.
     * @param limit Il numero massimo di prodotti da recuperare.
     * @return Una lista di prodotti che appartengono alla categoria specificata, ordinati secondo il criterio specificato.
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
     * Metodo che salva un nuovo prodotto nel database con le informazioni specificate.
     * @return L'id del prodotto salvato nel database.
     * @param prodotto Il prodotto da salvare nel database.
     * @param idCategoria L'id della categoria a cui appartiene il prodotto.
     * @throws RuntimeException Se si verifica un'eccezione SQLException durante l'inserimento del prodotto nel database.
     */
    public int doSave(Prodotto prodotto, int idCategoria){
        try(Connection con = ConnectionPool.getConnection()){
            PreparedStatement ps = con.prepareStatement("INSERT  INTO prodotto(nome, descrizione, marca, prezzo, categoria) VALUES(?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            ps.setString(1,prodotto.getNome());
            ps.setString(2,prodotto.getDescrizione());
            ps.setString(3,prodotto.getMarca());
            ps.setFloat(4,prodotto.getPrezzo());
            ps.setInt(5,idCategoria);
            if(ps.executeUpdate() != 1){
                throw new RuntimeException("INSERT error");
            }
            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            int id = rs.getInt(1);
            return id;
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    /**
     * Metodo che aggiorna le informazioni di un prodotto esistente nel database con i nuovi valori specificati.
     *
     * @param prodotto Il prodotto con le nuove informazioni.
     * @param id L'id del prodotto da modificare.
     * @throws RuntimeException Se si verifica un'eccezione SQLException durante l'aggiornamento delle informazioni del prodotto nel database.
     */
    public void doUpdate(Prodotto prodotto,int id){
        try(Connection con = ConnectionPool.getConnection()){
            PreparedStatement ps=con.prepareStatement("UPDATE prodotto SET nome=?, descrizione=?, marca=?, prezzo=?, categoria=?, id=? WHERE id =?");
            ps.setString(1,prodotto.getNome());
            ps.setString(2,prodotto.getDescrizione());
            ps.setString(3,prodotto.getMarca());
            ps.setFloat(4,prodotto.getPrezzo());
            ps.setInt(5,prodotto.getCategoria());
            ps.setInt(6,prodotto.getId());
            ps.setInt(7,id);
            if (ps.executeUpdate() != 1){
                throw new RuntimeException("UPDATE error.");
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    /**
     * Metodo che elimina un prodotto dal database utilizzando l'id specificato.
     *
     * @param id L'id del prodotto da eliminare.
     * @throws RuntimeException Se si verifica un'eccezione SQLException durante l'eliminazione del prodotto dal database.
     */
    public void doDelete(int id){
        try(Connection con = ConnectionPool.getConnection()){
            PreparedStatement ps = con.prepareStatement("DELETE FROM prodotto WHERE id=?");
            ps.setInt(1, id);
            if(ps.executeUpdate() != 1){
                throw new RuntimeException("UPDATE error .");
            }

        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

}