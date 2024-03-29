package model;

import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.mockito.Mockito;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class ProdottoDAOTest {
    private ProdottoDAO prodottoDAO = new ProdottoDAO();
    @BeforeAll
    public void getConnection() throws SQLException {
        ConnectionPool connectionPool = new ConnectionPool();
        connectionPool.getConnection();
    }


    @Test
    public void doSaveProdottoDatabaseTest() throws Exception {

        // Crea un oggetto Prodotto con dati fittizi
        Prodotto prodotto = new Prodotto("prodotto", "descrizione",
                123F, "marca", 6);

        // Chiamata al metodo doSave utilizzando la connessione reale al database
        int id = prodottoDAO.doSave(prodotto,6);

        // Verifica che l'ID restituito sia maggiore di 0 (indicando un inserimento riuscito)
        assertTrue(id > 0);
    }

    @Test
    public void deleteProdottoIntegrationTest(){
        // Crea un oggetto Prodotto con dati fittizi
        Prodotto prodotto = new Prodotto("prodotto", "descrizione",
                123F, "marca", 6);

        // Chiamata al metodo doSave utilizzando la connessione reale al database
        int id = prodottoDAO.doSave(prodotto, 6);
        // Chiamata al metodo doDelete utilizzando la connessione reale al database
        prodottoDAO.doDelete(id);

        assertEquals(prodottoDAO.doRetrieveById(id), null);
    }

    @Test
    public void prodottoInserimentoIntegrationTest(){
        // Crea un oggetto Prodotto con dati fittizi
        Prodotto prodotto = new Prodotto("prodotto", "descrizione",
                123F, "marca", 6);

        // Chiamata al metodo doSave utilizzando la connessione reale al database
        int id = prodottoDAO.doSave(prodotto, 6);

        // Testiamo la ricerca nel database insieme all'inserimento
        assertEquals(id, prodottoDAO.doRetrieveById(id).getId());
    }

    @Test
    public void prodottoUpdateIntegrationTest(){
        // Crea un oggetto Prodotto con dati fittizi
        Prodotto prodotto = new Prodotto("prodotto", "descrizione",
                123F, "marca", 6);

        // Chiamata al metodo doSave utilizzando la connessione reale al database
        int id = prodottoDAO.doSave(prodotto, 6);

        //Modifichiamo i dati del prodotto
        Prodotto prodotto1 = new Prodotto("prodotto1", "descrizione1",
                124F, "marca1", 7);

        //Chiamata al metodo doUpdateCredenziali utilizzando la connessione reale al database
        prodottoDAO.doUpdate(prodotto1, id);

        // Testiamo la ricerca nel database insieme alla modifica dei dati
        assertEquals("prodotto1", prodottoDAO.doRetrieveById(id).getNome());
    }

    @Test
    public void doSaveProdottoFailureNomeTest() {
        // Creazione di un oggetto Prodotto fittizio
        Prodotto prodotto = new Prodotto("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
        , "descrizione", 12.4F, "One Piece", 7);

        // Tentativo di inserire un secondo ordine con la stessa chiave (dovrebbe fallire)
        try {
            int id1 = prodottoDAO.doSave(prodotto, 6);
        } catch (Exception e) {
            // Aspettati un'eccezione durante l'inserimento duplicato
            assertTrue(e instanceof RuntimeException); // Aggiorna con il tipo di eccezione atteso
        }
    }

    @Test
    public void doSaveProdottoFailureMarcaTest() {
        // Creazione di un oggetto Prodotto fittizio
        Prodotto prodotto = new Prodotto("nome", "descrizione",
                13.3F, "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", 7);

        // Tentativo di inserire un secondo ordine con la stessa chiave (dovrebbe fallire)
        try {
            int id1 = prodottoDAO.doSave(prodotto, 6);
        } catch (Exception e) {
            // Aspettati un'eccezione durante l'inserimento duplicato
            assertTrue(e instanceof RuntimeException); // Aggiorna con il tipo di eccezione atteso
        }
    }

    @Test
    public void doSaveProdottoFailureDescrizioneTest() {
        // Creazione di un oggetto Prodotto fittizio
        Prodotto prodotto = new Prodotto("nome",
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
                13.3F, "One piece", 7);

        // Tentativo di inserire un secondo ordine con la stessa chiave (dovrebbe fallire)
        try {
            int id1 = prodottoDAO.doSave(prodotto, 6);
        } catch (Exception e) {
            // Aspettati un'eccezione durante l'inserimento duplicato
            assertTrue(e instanceof RuntimeException); // Aggiorna con il tipo di eccezione atteso
        }
    }
}
