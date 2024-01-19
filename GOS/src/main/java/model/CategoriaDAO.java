package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 * La classe CategoriaDAO fornisce metodi per interagire con il database
 * per le operazioni relative agli oggetti Categoria.
 * E' responsabile della persistenza e del recupero dei dati delle categorie.
 *
 * Gli oggetti di questo classe dovrebbero essere utilizzati per accedere e manipolare
 * le informazioni delle categorie nel database.
 *
 * La classe utilizza la connessione al database fornita da ConnectionPool per
 * garantire una gestione corretta delle risorse e delle eccezioni SQL.
 */
public class CategoriaDAO {

    /**
     * Metodo che recupera una lista di categorie dal database in base a una macrocategoria specifica.
     *
     * @param macro La macrocategoria utilizzata come criterio di ricerca per le categorie.
     * @return Una lista di categorie corrispondenti alla macrocategoria fornita.
     * @throws RuntimeException Se si verifica un'eccezione di tipo SQLException durante l'accesso al database.
     */
    public List<Categoria> doRetrieveByMacro(String macro){
        try(Connection con = ConnectionPool.getConnection()){
            PreparedStatement ps = con.prepareStatement("SELECT id, nome, descrizione FROM categoria WHERE macrocategoria=?");
            ps.setString(1,macro);
            List<Categoria> categorie = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Categoria c= new Categoria();
                c.setId(rs.getInt(1));
                c.setNome(rs.getString(2));
                c.setDescrizione(rs.getString(3));
                categorie.add(c);
            }
            return categorie;
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    /**
     * Metodo che recupera tutte le categorie presenti nel database.
     *
     * @return Tutte le categorie presenti nel database.
     * @throws RuntimeException Se si verifica un'eccezione SQLException durante l'operazione di recupero.
     */
    public List<Categoria> doRetrieveAll(){
        try(Connection con = ConnectionPool.getConnection()) {
            PreparedStatement ps= con.prepareStatement("SELECT id, nome, descrizione FROM categoria");
            List<Categoria> categorie= new ArrayList<Categoria>();
            ResultSet rs= ps.executeQuery();
            while(rs.next()){
                Categoria c= new Categoria();
                c.setId(rs.getInt(1));
                c.setNome(rs.getString(2));
                c.setDescrizione(rs.getString(3));
                categorie.add(c);
            }
            return categorie;
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
    /**
     * Metodo che recupera una categoria dal database basata sull'id specificato.
     *
     * @param id L'id univoco della categoria da recuperare.
     * @return Una categoria corrispondente all'id, o null se non trovata.
     * @throws RuntimeException Se si verifica un'eccezione SQLException durante l'operazione di recupero.
     */
    public Categoria doRetrieveById(int id){
        try(Connection con = ConnectionPool.getConnection()){
            PreparedStatement ps= con.prepareStatement("SELECT id,nome,descrizione FROM categoria WHERE id=?");
            ps.setInt(1,id);

            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                Categoria c= new Categoria();
                c.setId(rs.getInt(1));
                c.setNome(rs.getString(2));
                c.setDescrizione(rs.getString(3));
                return c;
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }
    /**
     * Metodo che salva una nuova categoria nel database.
     *
     * @param categoria L'oggetto categoria da salvare nel database.
     * @throws RuntimeException Se si verifica un'eccezione SQLException durante l'operazione di salvataggio.
     */
    public void doSave(Categoria categoria){
        try(Connection con = ConnectionPool.getConnection()){
            PreparedStatement ps = con.prepareStatement("INSERT INTO categoria(nome, descrizione) VALUES (?,?)");
            ps.setString(1,categoria.getNome());
            ps.setString(2,categoria.getDescrizione());
            if(ps.executeUpdate() != 1){
                throw new RuntimeException("INSERT error");
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
    /**
     * Metodo che aggiorna una categoria esistente nel database.
     *
     * @param categoria L'oggetto categoria con le nuove informazioni da aggiornare nel database.
     * @throws RuntimeException Se si verifica un'eccezione SQLException durante l'operazione di aggiornamento.
     */
    public void doUpdate(Categoria categoria){
        try (Connection con = ConnectionPool.getConnection()){
            PreparedStatement ps = con.prepareStatement("UPDATE categoria SET nome=?, descrizione=? WHERE id=?");
            ps.setString(1,categoria.getNome());
            ps.setString(2,categoria.getDescrizione());
            ps.setInt(3,categoria.getId());
            if(ps.executeUpdate() != 1){
                throw new RuntimeException("UPDATE error");
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    /**
     * Metodo che elimina una categoria dal database basata sull'id specificato.
     *
     * @param id L'id univoco della categoria da eliminare dal database.
     * @throws RuntimeException Se si verifica un'eccezione SQLException durante l'operazione di eliminazione.
     */
    public void doDelete(int id){
        try (Connection con = ConnectionPool.getConnection()){
            PreparedStatement ps = con.prepareStatement("DELETE FROM categoria WHERE id=?");
            ps.setInt(1,id);
            if(ps.executeUpdate() != 1){
                throw new RuntimeException("DELETE error");
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
