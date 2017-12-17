package com.seavus.webcalculator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/webcalculator")
public class WebCalculator extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("com.seavus.webcalculator.WebCalculator.doGet");
        printMessage(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("com.seavus.webcalculator.WebCalculator.doPost");
        printMessage(req, resp);
    }

    private void printMessage(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String operator = req.getParameter("operator");
        int number1 = Integer.parseInt(req.getParameter("number1"));
        int number2 = Integer.parseInt(req.getParameter("number2"));

        resp.setContentType("text/html");
        if (operator.equals("+")) {
            resp.getWriter().println(number1 + number2);
        } else if (operator.equals("-")) {
            resp.getWriter().println(number1 - number2);
        } else {
            resp.getWriter().println("Wrong operator!");
        }
    }
}
