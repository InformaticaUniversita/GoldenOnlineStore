package Servlet;

import model.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet( "/ModificaProdotto")
public class ModificaProdottoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        int idProdotto = Integer.parseInt(request.getParameter("idProdotto"));

        int id = Integer.parseInt(request.getParameter("id"));

        int categoria = Integer.parseInt(request.getParameter("categoria"));
        if (!(categoria > 0)) {
            request.setAttribute("notifica", "Categoria non valida!");
            request.getRequestDispatcher("WEB-INF/jsp/ModificaProdotto.jsp").forward(request, response);
            return;
        }

        String nome = request.getParameter("nome");
        if (!(nome != null && nome.matches("([ a-zA-Z0-9.!@#$%^&*()_-]{2,32})"))) {
            request.setAttribute("notifica", "Nome non valido!");
            request.getRequestDispatcher("WEB-INF/jsp/ModificaProdotto.jsp").forward(request, response);
            return;
        }

        String descrizione = request.getParameter("descrizione");
        if (!(descrizione != null && descrizione.matches("([ a-zA-Z0-9.!@#$%^&*()_-]{0,150})"))) {
            request.setAttribute("notifica", "Descrizione non valida!");
            request.getRequestDispatcher("WEB-INF/jsp/ModificaProdotto.jsp").forward(request, response);
            return;
        }

        float prezzo = Float.parseFloat(request.getParameter("prezzo"));
        if (prezzo < 0) {
            request.setAttribute("notifica", "Prezzo non valido!");
            request.getRequestDispatcher("WEB-INF/jsp/ModificaProdotto.jsp").forward(request, response);
            return;
        }

        String marca = request.getParameter("marca");
        if (!(marca != null && marca.matches("([ a-zA-Z0-9.!@#$%^&*()_-]{3,32})"))) {
            request.setAttribute("notifica", "Marca non valida!");
            request.getRequestDispatcher("WEB-INF/jsp/ModificaProdotto.jsp").forward(request, response);
            return;
        }

        Prodotto prodotto = new Prodotto();
        prodotto.setId(id);
        prodotto.setCategoria(categoria);
        prodotto.setPrezzo(prezzo);
        prodotto.setDescrizione(descrizione);
        prodotto.setMarca(marca);
        prodotto.setNome(nome);
        ProdottoDAO prodottoDAO = new ProdottoDAO();
        prodottoDAO.doUpdate(prodotto, idProdotto);

        String messaggio = "Prodotto modificato con successo!";

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/jsp/Messaggio.jsp");
        request.getSession().setAttribute("messaggio", messaggio);
        requestDispatcher.forward(request,response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Prodotto prodotto = new Prodotto();
        ProdottoDAO prodottoDAO = new ProdottoDAO();
        int id = Integer.parseInt(request.getParameter("id"));

        prodotto = prodottoDAO.doRetrieveById(id);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/jsp/ModificaProdotto.jsp");
        request.getSession().setAttribute("prodotto", prodotto);
        request.getSession().setAttribute("categoria", prodotto.getCategoria());
        requestDispatcher.forward(request, response);
    }
}
