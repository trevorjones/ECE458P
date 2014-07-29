/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.User;

/**
 *
 * @author Trevor
 */
@WebServlet(name = "WriteInServlet", urlPatterns = {"/WriteInServlet"})
public class WriteInServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        Boolean injectionProtection = false;
        
        String writein = request.getParameter("writein");
        
        Connection con = (Connection) getServletContext().getAttribute("DBConnection");
        
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        try {
            if(injectionProtection){
                PreparedStatement ps = con.prepareStatement("UPDATE Candidates SET num_votes=num_votes + 1 WHERE name=?");
                ps.setString(1, writein);
                int updates = ps.executeUpdate();
                ps.close();
                if(updates < 1){
                    ps = con.prepareStatement("INSERT INTO Candidates (id, name, num_votes) VALUES (?,?,1)");
                    ps.setString(1, writein);
                    ps.setString(2, writein);
                    int updates2 = ps.executeUpdate();
                }
                ps = con.prepareStatement("UPDATE Users SET voted=true WHERE name=?");
                ps.setString(1, user.getName());
                ps.executeUpdate();
                ps.close();
            } else {
                Statement stmt = con.createStatement();
                String query = "UPDATE Candidates SET num_votes=num_votes + 1 WHERE name=\"" + writein + "\"";
                int updates = stmt.executeUpdate(query);
                stmt.close();
                if(updates < 1){
                    stmt = con.createStatement();
                    query = "INSERT INTO Candidates (id, name, num_votes) VALUES (\"" + writein + "\",\"" + writein + "\",1)";
                    int updates2 = stmt.executeUpdate(query);
                    stmt.close();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new ServletException("SQL Error");
        } finally {
            response.sendRedirect("voted.jsp");
        }
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
