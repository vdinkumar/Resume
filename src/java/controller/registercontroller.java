/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.*;
/**
 *
 * @author Administrator
 */
public class registercontroller extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {


     //   profilebean bean=new profilebean();



        profilebean bean=new profilebean();
        bean.setName(request.getParameter("name"));
        bean.setAddress(request.getParameter("address"));
        bean.setDOB(request.getParameter("DOB"));
        bean.setMobile(request.getParameter("mobile"));
        bean.setEmail(request.getParameter("email"));
        bean.setSpecialization_id(Integer.parseInt(request.getParameter("specialization_id")));
        bean.setWork_experience(Integer.parseInt(request.getParameter("work_experience")));
        

        profile p=new profile(getServletContext().getInitParameter("DSN"));
        int key=p.create(bean);
        if(key!=0)
        {
        login log=new login(getServletContext().getInitParameter("DSN"));
        log.create(key, request.getParameter("username"), request.getParameter("password"));
        request.setAttribute("message","You are successfully registered.Login to update your resume");
        request.getRequestDispatcher("login.jsp").forward(request, response);
         
        }
        else
        {
            request.setAttribute("message","Registration failed due to technical issues.");
        request.getRequestDispatcher("register.jsp").forward(request, response);
        }



    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
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
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
