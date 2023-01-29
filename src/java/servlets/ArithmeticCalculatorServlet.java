package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Swift
 */
public class ArithmeticCalculatorServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("result", "---");
        
        getServletContext().getRequestDispatcher("/WEB-INF/arithmeticCalculator.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String first = request.getParameter("first");
        String second = request.getParameter("second");
        String add = request.getParameter("+");
        String subtract = request.getParameter("-");
        String multiply = request.getParameter("*");
        String modulus = request.getParameter("%");
        
        request.setAttribute("first", first);
        request.setAttribute("second", second);
        
        if (first == null || first.equals("") || second == null 
                || second.equals("")){
            request.setAttribute("result", "invalid");
            getServletContext().getRequestDispatcher("/WEB-INF/arithmeticCalculator.jsp")
                .forward(request, response);
            return;
        }
        
        Integer firstInt;
        Integer secondInt;
        try {
            firstInt = Integer.parseInt(first);
            secondInt = Integer.parseInt(second);
        } catch (NumberFormatException nfe){
            request.setAttribute("result", "invalid");
            getServletContext().getRequestDispatcher("/WEB-INF/arithmeticCalculator.jsp")
                .forward(request, response);
            return;
        }
        
        if (add != null){
            request.setAttribute("result", firstInt + secondInt);
        } else if (subtract != null) {
            request.setAttribute("result", firstInt - secondInt);
        } else if (multiply != null) {
            request.setAttribute("result", firstInt * secondInt);
        } else if (modulus != null) {
            request.setAttribute("result", firstInt % secondInt);
        }
        
        getServletContext().getRequestDispatcher("/WEB-INF/arithmeticCalculator.jsp")
                .forward(request, response);
    }
}