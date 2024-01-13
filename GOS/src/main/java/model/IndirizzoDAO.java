package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class IndirizzoDAO {

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
