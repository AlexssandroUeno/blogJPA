/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Alexssandro Ueno
 */
public class UserRegisterServlet extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet UserRegisterServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UserRegisterServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        try (PrintWriter out = response.getWriter()) {
            DAO.UserDAO daoUser = new DAO.UserDAO();
            DAO.RoleDAO rdao = new DAO.RoleDAO();
            DAO.RoleDAO rdao11 = new DAO.RoleDAO();
            entities.User user = new entities.User();
            String nome = request.getParameter("nome");
            user.setName(request.getParameter("nome"));
            user.setUsername(request.getParameter("user"));
            user.setEmail(request.getParameter("email"));
            user.setPassword(request.getParameter("pass"));
            String[] desc = {"superadmin", "admin", "writer"};
            /*if (rdao.buscaPorId(1) == null) {
                for (int i = 1; i <= 3; i++) {
                    DAO.RoleDAO rdao1 = new DAO.RoleDAO();
                    entities.Role rl = new entities.Role();
                    rl.setIdRole(i);
                    rl.setDescription(desc[i - 1]);
                    rdao1.save(rl);
                }
            }*/
            user.setIdRole(rdao11.buscaPorId(1));
            daoUser.save(user);
            request.setAttribute("sucessoReg", true);
            request.getRequestDispatcher("login.jsp").forward(request, response);
        } catch (Exception ex) {
            System.out.println(ex);
            request.setAttribute("erroReg", true);
            request.getRequestDispatcher("registrar.jsp").forward(request, response);
        }
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
