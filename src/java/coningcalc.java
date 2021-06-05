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
import java.lang.Math;

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
        
    // created variables from the requests    
        String radio_vd1 = request.getParameter("radio_vd");
        String input_distance1 = request.getParameter("input-vesseld");  
        String radio_vs1 = request.getParameter("radio_vs");
        String input_spd1 = request.getParameter("input-vesselspd");
        String radio_ad1 = request.getParameter("radio_ad");       
        String input_vesselad1 = request.getParameter("input-vesselad");
        
//  ****************************ALL THE MATH STUFF******************************      
        double spd2 = Double.parseDouble(input_spd1);
        double spd3=spd2*0.5144;  //  Speed converted from knots to m/s = (spd3)
        
        double vd2 = Double.parseDouble(input_distance1);
        double t1=vd2/spd3;  // distance1 in seconds
        
        double ad2 = Double.parseDouble(input_vesselad1);
        
        // calculating hypotenuse vector speed
        double first=vd2*vd2;
        System.out.println("first: " +first);
	double second=ad2*ad2;
	System.out.println("second: " +second);
	double d4=first+second;	
	System.out.println("d4: " +d4);	
	double hypotenuse=Math.sqrt(d4);
	System.out.println("Hyportenuse: " +hypotenuse);
        
        //FINAL EVAL
	double FINAL_CALC=hypotenuse/t1;
        
//  ****************************************************************************        
        
        // This works. Commented out to test Enumeration
        try {
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<body>");
/*        out.println("<h1> Vessel Distance: " + input_distance1 + " " + radio_vd1 + "<br>");
        //out.println("Vessel Distance: " + request.getParameter("vesseld") + "<br>");
        if (radio_vs1.equals("mph")) {
            out.println("You selected mph<br>");
        } else {
            out.println("You selected knots<br>");
        }
        out.println("Vessel Speed: " + input_spd1 + " " + radio_vs1 + "<br>");
        //out.println("Vessel Distance: " + request.getParameter("vessels") + "<br>");
        out.println("Ascent/Descent Distance: " + input_vesselad1 + " " + radio_ad1 + "<br>");
        //out.println("Vessel Distance: " + request.getParameter("vesselad") + "<br>");
*/        out.println("<h1>Ascent/Descent sped should be: <u>" + FINAL_CALC + " " + "m/s</u>");
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
