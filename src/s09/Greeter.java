package s09;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.Duration;
import java.time.LocalTime;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/s09/greeter")
public class Greeter extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(); // quando tomcat vede una request, guarda il cookie e se l'utente aveva già fatto una request precedente associa la session precedente e la riapre
        LocalTime start = (LocalTime) session.getAttribute("start"); // gli attributi possono essere anche all'interno della session, rimane dentro finchè la session rimane attiva. Se non esisteva una session precedente, in start c'è null.

        Duration duration;
        if (start == null) { // se non esiste una sessione precedente 
            duration = Duration.ZERO; // metti 0 in duration della sessione
            session.setAttribute("start", LocalTime.now()); // quindi metti l'ora corrente in session
        } else {
            duration = Duration.between(start, LocalTime.now()); // altrimenti dico che duration è la distanza nel tempo tra start e now
        }

        if (request.getParameter("done") == null) { // cerco tra i parametri passati dall'utente "done", tipo logout
            request.setAttribute("duration", duration); 
            RequestDispatcher rd = request.getRequestDispatcher("/s09/greeter.jsp");
            rd.forward(request, response);
        } else {
            session.invalidate(); // sto terminando la sessione

            response.setContentType("text/html");
            response.setCharacterEncoding("utf-8");
            try (PrintWriter writer = response.getWriter()) {
                writer.println("<!DOCTYPE html><html>");
                writer.println("<head><meta charset=\"utf-8\">");
                writer.println("<title>So long</title></head>");
                writer.println("<body><h1>Goodbye</h1>");
                writer.println("<p>You worked on this stuff for " + duration.getSeconds() + " seconds</p>");
                writer.println("</body></html>");
            }
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
