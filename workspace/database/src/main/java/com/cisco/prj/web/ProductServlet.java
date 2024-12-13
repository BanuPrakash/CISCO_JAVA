package com.cisco.prj.web;

import com.cisco.prj.entity.Product;
import com.cisco.prj.entity.dao.FetchException;
import com.cisco.prj.entity.dao.PersistenceException;
import com.cisco.prj.entity.dao.ProductDao;
import com.cisco.prj.entity.dao.ProductDaoJdbcImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/products")
public class ProductServlet extends HttpServlet {
    private ProductDao productDao = new ProductDaoJdbcImpl();

    // GET http://localhost:8080/products
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html"); // Browser is the client
        // open character stream to the browser
        PrintWriter out = resp.getWriter();
        // binary stream
        // ServletOutputStream out = resp.getOutputStream();
        out.print("<html><body>");
        out.print("<h1>Product List</h1>");
        out.print("<table border=\"1\">");
            out.print("<tr>");
                out.print("<th>ID</th><th>Name</th><th>Price</th>");
            out.print("</tr>");
        try {
            List<Product> products = productDao.getProducts();
            for(Product p : products) {
                out.print("<tr>");
                    out.print("<td>" + p.getId() + "</td>");
                    out.print("<td>" + p.getName() + "</td>");
                    out.print("<td>" + p.getPrice() + "</td>");
                out.print("</tr>");
            }
        } catch (FetchException e) {
            e.printStackTrace();
        }
        out.print("</table></body><html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       String name = req.getParameter("name");
       String price = req.getParameter("price"); // "45.66"

      Product p = Product.builder().name(name).price(Double.parseDouble(price)).build();

        ProductDao productDao = new ProductDaoJdbcImpl();
        try {
            productDao.addProduct(p);
            resp.sendRedirect("index.html");
//            System.out.println("Product added Successfully!!!");
        } catch (PersistenceException e) {
           // System.out.println(e.getMessage()); // production
            e.printStackTrace();  // development stage
            resp.sendRedirect("error.jsp?msg=" + e.getMessage());
        }
    }
}
