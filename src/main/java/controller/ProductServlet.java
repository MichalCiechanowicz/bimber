package controller;

import com.google.common.base.Throwables;
import model.Product;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;
import java.util.logging.Logger;


@WebServlet("/product")
public class ProductServlet extends HttpServlet {

    public static final Logger logger = Logger.getLogger(ProductServlet.class.getSimpleName());
    public static final String ID_BIMBER = "ID_BIMBER";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String parametr = request.getParameter(ID_BIMBER);
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        Optional<Integer> id = getIdFromParameter(parametr);

        //todo
        if (parametr == null) {
            writer.println("<h2>Tutaj wyswietl cala liste produkow</h2>");
        } else if (id.isPresent()) {
            writer.print("<h2> Twoj product:" + id.get());
        } else {
            writer.println("<h2>NIEPOPRAWNE ID</h2>");
        }


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        PrintWriter writer = response.getWriter();

        String id = request.getParameter("id");
        String rodzaj = request.getParameter("rodzaj");
        String nazwa = request.getParameter("nazwa");
        String moc = request.getParameter("moc");
        String region = request.getParameter("region");
        String price = request.getParameter("price");

        if (id == null || rodzaj == null || nazwa == null || moc == null || region == null || price == null) {
            writer.println("Kotrys z parametrow nie zostal podany");
        } else if (validateIntegerValues(id, price, moc)) {
            Product newProduct = new Product();
            newProduct.setIdbimber(id);
            newProduct.setRodzaj(rodzaj);
            newProduct.setNazwa(nazwa);
            newProduct.setMoc(moc);
            newProduct.setRegion(region);
            newProduct.setPrice(price);

            //ustawic wszystkie parametry
            writer.println("Product has been created.");
        } else {
            writer.println("Integers value are not valid");
        }
    }

    private Optional<Integer> getIdFromParameter(String idParam) {
        try {
            Integer integer = Integer.valueOf(idParam);
        } catch (Exception e) {
            logger.warning(Throwables.getStackTraceAsString(e));
        } return Optional.empty();
    }

    private boolean validateIntegerValues(String id, String price, String moc) {
        try {
            Integer idInteger = Integer.valueOf(id);
            Integer priceInteger = Integer.valueOf(price);
            Integer mocInteger = Integer.valueOf(moc);

            return idInteger >= 0 && priceInteger >= 0 && mocInteger >= 0;

        } catch (Exception e) {
            logger.warning("User gives wrong id=" + id + ", price= " + price + ", moc= " + moc);
            logger.warning(Throwables.getStackTraceAsString(e));
        }return false;
    }
}


