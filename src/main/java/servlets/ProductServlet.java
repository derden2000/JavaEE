package servlets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/product")
public class ProductServlet extends HttpServlet {

    private static Logger logger = LoggerFactory.getLogger(ProductServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("New Request: " + req);

        resp.getWriter().println("<title>Продукт</title");
        getServletContext().getRequestDispatcher("/header.html").include(req, resp);
        resp.getWriter().println("<h1 class=\"text-center\">There will be a Product Page</h1>");
        getServletContext().getRequestDispatcher("/footer.html").include(req, resp);
    }
}
