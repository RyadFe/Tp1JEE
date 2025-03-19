import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/CalculDeMonImc")
public class CalculDeMonImc extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        double poids = Double.parseDouble(request.getParameter("poids"));
        double taille = Double.parseDouble(request.getParameter("taille"));

        Imc imc = new Imc(taille, poids);
        double valeurImc = imc.calcul();

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><head><title>IMC</title></head><body>");
        out.println("<p>Votre IMC est : " + valeurImc + "</p>");
        out.println("</body></html>");
    }
}



