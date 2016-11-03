package com.blueberry.weibo.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Administrator on 2016/11/3.
 */

public final class SecurityServlet extends HttpServlet {

    private PrintWriter pw;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        pw = new PrintWriter(resp.getOutputStream());
        pw.print("blueberry");
        pw.flush();
        pw.close();
        resp.setStatus(200);
    }
}
