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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.User;

@WebServlet(name = "SigninServlet", urlPatterns = {"/SigninServlet"})
public class SigninServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    Boolean injectionProtection = false;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String user_id = request.getParameter("user_id");
        String password = request.getParameter("password");
        String errorMsg = null;
        
        if (user_id == null || user_id.equals("") || password == null || password.equals("")) {
            invalidUser(request, response);
        } else {

            Connection con = (Connection) getServletContext().getAttribute("DBConnection");
            PreparedStatement ps = null;
            ResultSet rs = null;
            Statement stmt = null;
            
            try {
                ps = con.prepareStatement("select * from Users where name=? and pass=?");
                ps.setString(1, user_id);
                ps.setString(2, password);
                stmt = con.createStatement();
                String query = "select * from Users where name= \"" + user_id + "\" and pass= \"" + password + "\"";
                rs = stmt.executeQuery(query);
                
                if(injectionProtection){
                    rs = ps.executeQuery();
                } else {
                    rs = stmt.executeQuery(query);
                }
                
                if (rs != null && rs.first()) {
                    setupSession(request, response, con, user_id, injectionProtection);
                } else {
                    invalidUser(request, response);
                }
            } catch (Exception e) {
                e.printStackTrace();
                throw new ServletException("DB Connection Problem");
            } finally {
                try {
                    rs.close();
                    ps.close();
                } catch(SQLException e) {
                    e.printStackTrace();
                }
            }
        }        
    }
    
    private void invalidUser(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
        PrintWriter out = response.getWriter();
        out.println("<div class=\"container\" style=\"width:300px;\"><span class=\"label label-danger\" style=\"display:block;\">Invalid user id or password</span></div>");
        rd.include(request, response);
    }
    
    public static void setupSession(HttpServletRequest request, HttpServletResponse response, Connection con, String user_id, Boolean injectionProtection) throws SQLException, IOException {
        HttpSession session = request.getSession();
        PreparedStatement ps = null;
        ResultSet rs = null;

        if(injectionProtection){
            ps = con.prepareStatement("select * from Users where name = ?");
            ps.setString(1, user_id);
            rs = ps.executeQuery();
            rs.next();
            User user = new User(rs);
            session.setAttribute("user", user);

            if(user.getVoted()){
                response.sendRedirect("voted.jsp");
            } else {
                response.sendRedirect("ballot.jsp");
            }
        } else {
            response.sendRedirect("ballot.jsp");
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
