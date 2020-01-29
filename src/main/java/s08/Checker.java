package s08;

import java.io.IOException;
import java.util.Set;
import java.util.TreeSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/s08/checker")
public class Checker extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String user = request.getParameter("user"); // in user viene messo il parametro associato, presente nell'url
        Set<Character> set = new TreeSet<>(); // creazione di un treeset vuoto salvato in un reference a set
        if (user != null) {
            for (char c : user.toCharArray()) { // il metodo ritorna un array di caratteri
                set.add(Character.toLowerCase(c)); // in set avrò tutti i caratteri di set in minuscolo, ordinati e senza duplicati essendo un tree set
            }
        }
        request.setAttribute("set", set); // in request posso mettere gli attributi che voglio, è come una mappa con K-V (key-value)
// passo il controllo alla jsp
        RequestDispatcher rd = request.getRequestDispatcher("/s08/checker.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
