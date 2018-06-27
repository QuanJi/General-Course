package com.cqut.servlet.column;


import com.cqut.server.columnManagement.CloumnService;
import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/ColumnServlet")
public class ColumnServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ColumnServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String searchKey =request.getParameter("searchKey");
        Integer pageNum = Integer.parseInt(request.getParameter("pageNum"));
        Integer parentId = Integer.parseInt(request.getParameter("parentId"));
        System.out.println(searchKey+" "+pageNum+" "+parentId);



        try {
            JSONArray jsonInfo = CloumnService.getIt(searchKey,pageNum,parentId);

            //JSONArray json = CloumnService.getColumnInfo();
            //System.out.println(json);
            PrintWriter writer = response.getWriter();
            writer.write(jsonInfo.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}
