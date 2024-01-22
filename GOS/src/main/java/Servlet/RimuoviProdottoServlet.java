package Servlet;

import model.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/RimuoviProdotto")
public class RimuoviProdottoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
    protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        HttpSession session= request.getSession();

        int id = Integer.parseInt(request.getParameter("id"));
        ProdottoDAO prodottoDAO = new ProdottoDAO();
        prodottoDAO.doDelete(id);

        String messaggio = "Prodotto rimosso con successo";

        RequestDispatcher requestDispatcher=request.getRequestDispatcher("WEB-INF/jsp/Messaggio.jsp");
        request.getSession().setAttribute("messaggio", messaggio);
        requestDispatcher.forward(request,response);
    }
}