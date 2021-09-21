package com.example.demo;

import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet<connN> extends HttpServlet {

    private String message;
    private String displayTable;
    DatabaseCon connN = new DatabaseCon();
    Connection connection = connN.getConnection();


    public void init() {
        message = "Hello World!";
    }


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");
        out.println();
        {
            try {
                System.out.println(connection);
                String sqlView = "select * from items";
                PreparedStatement preparedStatement = connection.prepareStatement(sqlView);
                System.out.println(preparedStatement);
                ResultSet rs = preparedStatement.executeQuery();

                if (!rs.next())
                    System.out.println("empty tabesultSet rs = preparedStatele ");
                while (rs.next()) {
                    int id = rs.getInt("itemid");
                    String name = rs.getString("itemname");
                    int price = rs.getInt("itemprice");
                    String quantity = rs.getString("itemquantity");

                    System.out.println(id + "," + name + "," + price + "," + quantity);

                }
                connection.close();

            } catch (
                    SQLException ex) {
                ex.printStackTrace();
            }


        }


    }
}