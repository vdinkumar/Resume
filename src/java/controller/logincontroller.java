/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.*;

/**
 *
 * @author Administrator
 */
public class logincontroller extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int user_id=0;
       
      if(request.getParameter("btn")!=null)
      {
        login log=new login(getServletContext().getInitParameter("DSN"));
         user_id=log.validate(request.getParameter("username"),request.getParameter("password"));
          
      
           
        if(user_id!=0){
            request.getSession(true).setAttribute("user_id",user_id);
          request.getRequestDispatcher("profile").forward(request, response);
        }
        
        else
        {
        request.setAttribute("message","Username or password did not match.Try to relogin");
        request.getRequestDispatcher("login.jsp").forward(request, response);
        }
      }
      
      else{
          
          
          if(request.getSession().getAttribute("user_id")!=null)
             request.getRequestDispatcher("profile").forward(request, response);
          
          else
          request.getRequestDispatcher("login.jsp").forward(request, response);    
          
          
          
          
      }
      
      
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
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
     * Handles the HTTP
     * <code>POST</code> method.
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
