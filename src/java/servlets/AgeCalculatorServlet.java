package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ray
 */
public class AgeCalculatorServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/ageCalculator.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String age = request.getParameter("age");
        
        if (age == null || age.equals("")){
            request.setAttribute("message", "You must give your current age.");
            getServletContext().getRequestDispatcher("/WEB-INF/ageCalculator.jsp")
                    .forward(request, response);
            return;
        }
        
        Integer ageInt;
        
        try {
            ageInt = Integer.parseInt(age);
        } catch (NumberFormatException nfe){
            request.setAttribute("message", "You must enter a number.");
            getServletContext().getRequestDispatcher("/WEB-INF/ageCalculator.jsp")
                    .forward(request, response);
            return;
        }
        
        ageInt++;
                
        request.setAttribute("message", "Your age next birthday will be " + ageInt);
        
        getServletContext().getRequestDispatcher("/WEB-INF/ageCalculator.jsp")
                    .forward(request, response);
    }
}
