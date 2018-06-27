package com.cqut.servlet.column;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import com.cqut.server.columnManagement.CloumnService;

@WebServlet("/DelColumnServlet")
public class DelColumnServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    public DelColumnServlet(){
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String[] info = request.getParameterValues("value");
        String temp[] = info[0].replace("[", "").replace("]", "").split(",");
        int[] otherTemp = new int[temp.length];
        for(int i=0 ; i<otherTemp.length ; i++){
            otherTemp[i] = Integer.parseInt(temp[i]);
        }
        CloumnService.delIt(otherTemp);
    }
}
