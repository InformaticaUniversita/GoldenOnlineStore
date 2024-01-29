package model;

import org.junit.Assert;
import org.junit.Test;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;

import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

public class OrdineDAOTest {
    @BeforeAll
    public void getConnection() throws SQLException {
        ConnectionPool connectionPool = new ConnectionPool();
        connectionPool.getConnection();
    }

    @Test
    public void doSaveSuccessTest() throws Exception {

        // Crea un mock per la classe OrdineDAO
        OrdineDAO ordineDAOMock = Mockito.mock(OrdineDAO.class);

        // Configura il mock per restituire un ID fittizio quando chiamato con doSave
        when(ordineDAOMock.doSave(any(Ordine.class))).thenReturn(123);

        // Crea un oggetto Ordine con dati fittizi
        LocalDate currentDate = LocalDate.now();
        java.sql.Date dataOrdine = java.sql.Date.valueOf(currentDate);
        LocalDate afterDate = currentDate.plusDays(7);
        java.sql.Date dataSpedizione = java.sql.Date.valueOf(afterDate);
        Ordine ordine = new Ordine("Spaghettino", dataOrdine, dataSpedizione, 123.14F);

        // Chiamata al metodo doSave usando il mock
        int id = ordineDAOMock.doSave(ordine);

        // Verifica che il mock sia stato chiamato correttamente
        verify(ordineDAOMock, times(1)).doSave(any(Ordine.class));

        // Verifica che l'ID restituito sia quello atteso
        assertEquals(123, id);
    }

    @Test
    public void doSaveDatabaseTest() throws Exception {

            // Creazione di un oggetto Ordine fittizio
            LocalDate currentDate = LocalDate.now();
            java.sql.Date dataOrdine = java.sql.Date.valueOf(currentDate);
            LocalDate afterDate = currentDate.plusDays(7);
            java.sql.Date dataSpedizione = java.sql.Date.valueOf(afterDate);
            Ordine ordine = new Ordine("Spaghettino", dataOrdine, dataSpedizione, 123.14F);

            // Chiamata al metodo doSave utilizzando la connessione reale al database
            OrdineDAO ordineDAO = new OrdineDAO();
            int id = ordineDAO.doSave(ordine);

            // Verifica che l'ID restituito sia maggiore di 0 (indicando un inserimento riuscito)
            assertTrue(id > 0);
    }

    @Test
    public void ordineIntegrationTest(){
        // Creazione di un oggetto Ordine fittizio
        LocalDate currentDate = LocalDate.now();
        java.sql.Date dataOrdine = java.sql.Date.valueOf(currentDate);
        LocalDate afterDate = currentDate.plusDays(7);
        java.sql.Date dataSpedizione = java.sql.Date.valueOf(afterDate);
        Ordine ordine = new Ordine("Spaghettino", dataOrdine, dataSpedizione, 123.14F);

        // Chiamata al metodo doSave utilizzando la connessione reale al database
        OrdineDAO ordineDAO = new OrdineDAO();
        int id = ordineDAO.doSave(ordine);

        // Testiamo la ricerca nel database insieme all'inserimento
        assertEquals(id, ordineDAO.doRetrieveById(id).getId());
    }


}

