package s07;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/s07/timerPlain") // questa servlet risponde alle chiamate a questo indirizzo ("")
public class TimerPlain extends HttpServlet { // timer plain è una HttpServlet
    private static final long serialVersionUID = 1L;

    @Override // annotazione @ per dare significati aggiuntivi al codice
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/plain"); // sto generando la response. Indico le proprietà
        response.setCharacterEncoding("utf-8");
        try (PrintWriter writer = response.getWriter()) { // PrintWriter classe per scrivere sui file
            writer.println(LocalTime.now()); // sto scrivendo sulla response 
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException { // errore 500
        doGet(request, response); // delega alla get l'esecuzione
    }
}
