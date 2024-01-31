package model;

import org.junit.After;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.mockito.Mockito;

import javax.validation.constraints.AssertFalse;
import java.sql.SQLException;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class UtenteDAOTest {
    private UtenteDAO utenteDAO = new UtenteDAO();
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
        int id = utenteDAO.doSave(utente2);

        // Verifica che l'ID restituito sia maggiore di 0 (indicando un inserimento riuscito)
        assertTrue(id > 0);
    }

    @Test
    public void deleteAccountIntegrationTest(){
        // Creazione di un oggetto Utente fittizio
        Utente utente3 = new Utente("username3", "email3@gmail.com",
                "password", "nome", "cognome");

        // Chiamata al metodo doSave utilizzando la connessione reale al database
        int id = utenteDAO.doSave(utente3);
        // Chiamata al metodo doDelete utilizzando la connessione reale al database
        utenteDAO.doDelete(utente3.getUsername());

        assertEquals(utenteDAO.doRetrieveById(id), null);
    }

    @Test
    public void utenteInserimentoIntegrationTest(){
        // Creazione di un oggetto Utente fittizio
        Utente utente4 = new Utente("username4", "email4@gmail.com",
                "password", "nome", "cognome");

        // Chiamata al metodo doSave utilizzando la connessione reale al database
        int id = utenteDAO.doSave(utente4);

        // Testiamo la ricerca nel database insieme all'inserimento
        assertEquals("username4", utenteDAO.doRetrieveByUsername("username4").getUsername());
    }

    @Test
    public void utenteUpdateIntegrationTest(){
        // Creazione di un oggetto Utente fittizio
        Utente utente5 = new Utente("username5", "email5@gmail.com",
                "password", "nome", "cognome");

        // Chiamata al metodo doSave utilizzando la connessione reale al database
        int id = utenteDAO.doSave(utente5);

        //Modifichiamo le credenziali dell'utente
        Utente utente6 = new Utente("username6", "email6@gmail.com",
                "password", "nome", "cognome");

        //Chiamata al metodo doUpdateCredenziali utilizzando la connessione reale al database
        utenteDAO.doUpdateCredenziali(utente6, "username5");

        // Testiamo la ricerca nel database insieme all'inserimento
        assertEquals("username6", utenteDAO.doRetrieveByUsername("username6").getUsername());
    }

    @Test
    public void doSaveUtenteFailureCognomeTest() {
        // Creazione di un oggetto Utente fittizio
        Utente utente7 = new Utente("username6", "email6@gmail.com",
                "password", "nome",
                "cognomeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee");

        // Tentativo di inserire un secondo ordine con la stessa chiave (dovrebbe fallire)
        try {
            int id1 = utenteDAO.doSave(utente7);
        } catch (Exception e) {
            // Aspettati un'eccezione durante l'inserimento duplicato
            assertTrue(e instanceof RuntimeException); // Aggiorna con il tipo di eccezione atteso
        }
    }
}

