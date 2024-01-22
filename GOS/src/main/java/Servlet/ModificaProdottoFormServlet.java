package Servlet;

import model.Prodotto;
import model.ProdottoDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ModificaProdottoForm")
public class ModificaProdottoFormServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Prodotto prodotto = new Prodotto();
        ProdottoDAO prodottoDAO = new ProdottoDAO();
        int id = Integer.parseInt(request.getParameter("id"));

        prodotto = prodottoDAO.doRetrieveById(id);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/jsp/ModificaProdotto.jsp");
        request.getSession().setAttribute("prodotto", prodotto);
        request.getSession().setAttribute("categoria", prodotto.getCategoria());
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}