package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * La classe IndirizzoDAO fornisce metodi per interagire con il database
 * per le operazioni relative agli oggetti indirizzo.
 * È responsabile della persistenza dei dati degli indirizzi.
 *
 * Gli oggetti di questa classe dovrebbero essere utilizzati per manipolare
 * le informazioni degli indirizzi nel database.
 *
 * La classe utilizza la connessione al database fornita da ConnectionPool per
 * garantire una gestione corretta delle risorse e delle eccezioni SQL.
 */
public class IndirizzoDAO {

    /**
     * Metodo che salva un nuovo indirizzo di spedizione nel database.
     *
     * @param indirizzo L'oggetto indirizzo da salvare nel database.
     * @throws RuntimeException Se si verifica un'eccezione di tipo SQLException durante l'accesso al database.
     */
    public void doSave(Indirizzo indirizzo){
        try(Connection con = ConnectionPool.getConnection()){
            PreparedStatement ps = con.prepareStatement("INSERT  INTO indirizzospedizione(ordine, via, cap, città) VALUES(?,?,?,?)");
            ps.setInt(1,indirizzo.getId());
            ps.setString(2, indirizzo.getVia());
            ps.setString(3, indirizzo.getCap());
            ps.setString(4, indirizzo.getCitta());
            if(ps.executeUpdate() != 1){
                throw new RuntimeException("INSERT error,");
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
