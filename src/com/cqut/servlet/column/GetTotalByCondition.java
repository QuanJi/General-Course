package com.cqut.servlet.column;

import com.cqut.server.columnManagement.CloumnService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/GetTotalByCondition")
public class GetTotalByCondition extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public GetTotalByCondition() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        PrintWriter writer = response.getWriter();
        try {

            String key = request.getParameter("value");
            Integer parentId = Integer.parseInt(request.getParameter("parentId"));
            String total = CloumnService.getAllDataWithCondition(key,parentId)+"";

            writer.write(total);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }
}
