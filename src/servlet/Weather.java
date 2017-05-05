package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.*;
import javax.servlet.*;
import javax.xml.rpc.ServiceException;

import client.*;

public class Weather extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        response.addHeader("Access-Control-Allow-Origin","*");

        PrintWriter out = response.getWriter();

        WeatherSoapBindingStub binding;
        String value = null;
        try {
            binding = (WeatherSoapBindingStub)new WeatherServiceLocator().getWeather();
            binding.setTimeout(6000);
            value = binding.getWeather(request.getParameter("city"));
        }
        catch (ServiceException jre) {
            if(jre.getLinkedCause()!= null)
                jre.getLinkedCause().printStackTrace();
        }

        out.print(value);
        out.flush();
        out.close();
    }
}
