/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jmahaffey09
 */
public class coningcalc extends HttpServlet {

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
        /* response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
             TODO output your page here. You may use following sample code. 
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet coningcalc</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet coningcalc at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } */
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
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        //String vesselD = request.getParameter("vesseld"); NOT SURE WHY CAN'T USE THIS
        
        // This works. Commented out to test Enumeration
        try {
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<body>");
        out.println("<h1> Vessel Distance: " + request.getParameter("vesseld") + " " + request.getParameter("vd") + "<br>");
        //out.println("Vessel Distance: " + request.getParameter("vesseld") + "<br>");
        out.println("Vessel Distance: " + request.getParameter("vessels") + " " + request.getParameter("vs") + "<br>");
        //out.println("Vessel Distance: " + request.getParameter("vessels") + "<br>");
        out.println("Vessel Distance: " + request.getParameter("vesselad") + " " + request.getParameter("ad") + "<br>");
        //out.println("Vessel Distance: " + request.getParameter("vesselad") + "<br>");
        out.println("</h1>");
        out.println("</body>");
        out.println("</html>");
      }
        
 // THIS READS ALL 'GETPARAMETER' AND VALUES
 /*
 Enumeration en = request.getParameterNames();
 while (en.hasMoreElements()) {
     Object objOri = en.nextElement();
     String param = (String)objOri;
     String value = request.getParameter(param);
     
     
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<body>");
     
     out.println("Parmaeter name is " + param + " and Parameter value is " + value + "<br>");
     
     out.println("</body>");
        out.println("</html>");
      
     
 }
 */
 // END THE ENUMERATION
 
 
        finally {
            out.close();
        }
       
        
        
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
