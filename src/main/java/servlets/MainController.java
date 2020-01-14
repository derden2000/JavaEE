package servlets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import persist.Product;
import persist.ProductRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "MainController", urlPatterns = {"/", "","/catalog"})
public class MainController extends HttpServlet {

    private Logger logger = LoggerFactory.getLogger(MainController.class);

    private ProductRepository productRepository;

    @Override
    public void init() throws ServletException {
        this.productRepository = (ProductRepository) getServletContext().getAttribute("productRepository");

        if (productRepository == null) {
            throw new ServletException("ProductRepository not created");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            if (req.getServletPath().equals("/")) {
                getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
            } else if (req.getServletPath().equals("/catalog")) {
                req.setAttribute("products", productRepository.findAll());
                getServletContext().getRequestDispatcher("/catalog.jsp").forward(req, resp);
            } else if (req.getServletPath().equals("/product")) {
                getServletContext().getRequestDispatcher("/product.jsp").forward(req, resp);
            } else if (req.getServletPath().equals("/about")) {
                getServletContext().getRequestDispatcher("/about.jsp").forward(req, resp);
            }
        } catch (SQLException e) {
            logger.error("", e);
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getServletPath().equals("/product")) {
            showOrderProductPage(req, resp);
        } else {
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
    }

    private void showOrderProductPage(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        long id;
        try {
            id = Long.parseLong(req.getParameter("id"));
        } catch (Exception ex) {
            logger.error("", ex);
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }
        Product product;
        try {
            product = productRepository.findById(id);
        } catch (SQLException ex) {
            logger.error("", ex);
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            return;
        }
        req.setAttribute("product", product);
//        req.setAttribute("action", "edit");
        getServletContext().getRequestDispatcher("/product.jsp").forward(req, resp);
    }
}
