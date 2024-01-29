package model;

import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.mockito.Mockito;
import java.sql.SQLException;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class UtenteDAOTest {
    @BeforeAll
    public void getConnection() throws SQLException {
        ConnectionPool connectionPool = new ConnectionPool();
        connectionPool.getConnection();
    }

    @Test
    public void doSaveSuccessTest() throws Exception {

        // Crea un mock per la classe UtenteDAO
        UtenteDAO utenteDAOMock = Mockito.mock(UtenteDAO.class);

        // Configura il mock per restituire un ID fittizio quando chiamato con doSave
        when(utenteDAOMock.doSave(any(Utente.class))).thenReturn(12);

        // Crea un oggetto Utente con dati fittizi
        Utente utente1 = new Utente("username1", "email1@gmail.com",
                "password", "nome", "cognome");

        // Chiamata al metodo doSave usando il mock
        int id = utenteDAOMock.doSave(utente1);

        // Verifica che il mock sia stato chiamato correttamente
        verify(utenteDAOMock, times(1)).doSave(any(Utente.class));

        // Verifica che l'ID restituito sia quello atteso
        assertEquals(12, id);
    }

    @Test
    public void doSaveDatabaseTest() throws Exception {

        // Creazione di un oggetto Utente fittizio
        Utente utente2 = new Utente("username2", "email2@gmail.com",
                "password", "nome", "cognome");

        // Chiamata al metodo doSave utilizzando la connessione reale al database
        UtenteDAO utenteDAO = new UtenteDAO();
        int id = utenteDAO.doSave(utente2);

        // Verifica che l'ID restituito sia maggiore di 0 (indicando un inserimento riuscito)
        assertTrue(id > 0);
    }

    @Test
    public void utenteIntegrationTest(){
        // Creazione di un oggetto Utente fittizio
        Utente utente3 = new Utente("username3", "email3@gmail.com",
                "password", "nome", "cognome");

        // Chiamata al metodo doSave utilizzando la connessione reale al database
        UtenteDAO utenteDAO = new UtenteDAO();
        int id = utenteDAO.doSave(utente3);

        Utente utente4 = utenteDAO.doRetrieveByUsername("username3");

        // Testiamo la ricerca nel database insieme all'inserimento
        assertEquals("username3", utente4.getUsername());
    }


}

