package io.yodo.crmdemo.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.sql.Connection;
import java.sql.DriverManager;

@WebServlet("/health")
public class HealthCheckServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String jdbcUrl = "jdbc:postgresql://postgres:5432/crmdemo?";
        String driverClassName = "org.postgresql.Driver";
        String userName = "postgres";
        String password = "postgres";

        try {
            Class.forName(driverClassName);
            Connection conn = DriverManager.getConnection(jdbcUrl, userName, password);
            if (conn == null ) {
                resp.setStatus(HttpURLConnection.HTTP_INTERNAL_ERROR);
                resp.getWriter().append("DB connection failed");
            } else {
                resp.getWriter().append("DB connection successful");
            }
        }
        catch(Exception ex) {
            resp.setStatus(HttpURLConnection.HTTP_INTERNAL_ERROR);
            resp.getWriter().append("DB connection failed, see console output for details");
            ex.printStackTrace();
        }
    }
}
