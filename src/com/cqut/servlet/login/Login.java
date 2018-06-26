package com.cqut.servlet.login;

import com.cqut.server.login.LoginServer;
import net.sf.json.JSONArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class t
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        BufferedReader reader = request.getReader();

        String gottenMsg = null;

        StringBuffer json = new StringBuffer();
        //如果传送的数据不为空
        if((gottenMsg = reader.readLine()) != null) {
            json.append(gottenMsg);
        }
        //
        String[] info = json.toString().split(",");

        PrintWriter writer = response.getWriter();
        try {
           // JSONArray data = LoginServer.checkAccount(info);
            String yesOrNo = LoginServer.checkAccount(info);
            writer.write(yesOrNo+"");
        } catch (Exception e) {

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
