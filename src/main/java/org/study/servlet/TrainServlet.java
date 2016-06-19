package org.study.servlet;

import org.study.entity.Train;
import org.study.service.Impl.TrainServiceImpl;
import org.study.service.TrainService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Skiller on 18.06.2016.
 */
public class TrainServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<body>");
        out.println("<h1 align = \"center\">Welcome!</h1>");
        out.println("This is your table:");
        TrainService trainService = new TrainServiceImpl();

        out.println("<table border = \"3\">");

        out.println("<tr>");
        out.println("<td>");
        out.println("<b>");
        out.println("numb_of_train");
        out.println("</b>");
        out.println("</td>");
        out.println("<td>");
        out.println("<b>");
        out.println("name");
        out.println("</b>");
        out.println("</td>");
        out.println("<td>");
        out.println("<b>");
        out.println("driver");
        out.println("</b>");
        out.println("</td>");
        out.println("<td>");
        out.println("<b>");
        out.println("numb_vagon");
        out.println("</b>");
        out.println("</td>");
        out.println("</tr>");

        for (Train train : trainService.getAllTrainsFromDB()) {
            out.println("<tr>");
            out.println("<td>");
            out.println(train.getNumbOfTrain());
            out.println("</td>");
            out.println("<td>");
            out.println(train.getName());
            out.println("</td>");
            out.println("<td>");
            out.println(train.getDriver());
            out.println("</td>");
            out.println("<td>");
            out.println(train.getNumbVagon());
            out.println("</td>");
            out.println("</tr>");
        }

        out.println("</table>");

        out.println("<p>");
        out.println("Enter your SQL query here:");
        out.println("</p>");
        out.println("<form action = \"http://localhost:8080/test-1.0-SNAPSHOT/Trains\" method = \"post\" name = \"trainform\">");
        out.println("<input type=\"text\" size=\"40\" name = \"query\">");
        out.println("<input type=\"submit\" value=\"Submit\" />");
        out.println("</form>");

        out.println("</body>");
        out.println("</html>");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        TrainService trainService = new TrainServiceImpl();
        trainService.parseQuery(request.getParameter("query"));
        doGet(request, response);
    }

}
