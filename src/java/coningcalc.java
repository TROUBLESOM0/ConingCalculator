/*
 * Copyright (C) 2021 mohafabode.com
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
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
 * @author mohafabode.com
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
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
/*  
Display progress bar
*/
/*
    out.println("<div class=\"progbar\";>\n" +
"	Status: \n" +
"<progress id=\"progBar\" min=\"0\" max=\"100\" value=\"20\">  \n" +
"</progress>\n" +
"<p id=\"reader\"></p>\n" +
"</div>\n" +
"\n" +
"<script>\n" +
"var b = document.getElementById(\"progBar\");\n" +
"var r = document.getElementById(\"reader\");\n" +
"//setInterval speed in milliseconds\n" +
"var id = setInterval(add, 15);\n" +
"\n" +
"function add(){\n" +
"  if(b.value >= 100){\n" +
"//clear interval when value reach 100\n" +
"	r.innerHTML = \"Done\";\n" +
"	clearInterval(id);\n" +
"  }else{\n" +
" b.value++;\n" +
"r.innerHTML = \"working\";\n" + 
"}}\n" +

"</script>");
*/    
/* End Progress Bar */

        out.println("<h1>Speed should be:</h1>");
        out.println("<h1><u>" + FINAL_CALC + " " + "m/s</u></h1>");
        out.println("<tr>");
        out.println("<style>\n" +
".goback {\n" +
"background-color: lightsteelblue;\n" +
"padding: 10px 28px;\n" +
"text-align: center;\n" +
"display: block;\n" +
"font-size: 15px;\n" +
"border-radius: 8px;\n" +
"margin-right: auto;\n" +
"position: relative;\n" +
"text-align: center;\n" +
"cursor: pointer;\n" +
"}\n" +
"</style>\n" +
"<button class=\"goback\" onclick=\"document.location='coner.html'\">GO BACK</button>");
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
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
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
