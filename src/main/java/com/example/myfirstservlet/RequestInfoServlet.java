package com.example.myfirstservlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet(name = "RequestInfoServlet", value = "/request-info-servlet")
public class RequestInfoServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // HTTP 메시지에 담긴 정보 -> HttpServletRequest 이 객체로 들어감
        resp.setContentType("text/html;charset=UTF-8"); // 한글로 바꿔줌
        PrintWriter out = resp.getWriter();
        out.println("<h1>클라이언트로부터 받은 요청정보</h1>");
        out.printf("<p> method : %s</p>\n", req.getMethod());
        out.printf("<p> user : %s</p>\n", req.getRemoteUser());
        out.printf("<p> address : %s</p>\n", req.getRemoteAddr());
        out.printf("<p> port : %s</p>\n", req.getRemotePort());
        out.printf("<p> RequestURL : %s</p>\n", req.getRequestURL());
        out.printf("<p> ContextPath : %s</p>\n", req.getContextPath());
        out.printf("<p> Protocol : %s</p>\n", req.getProtocol());
        out.printf("<p> ServletPath : %s</p>\n", req.getServletPath());
        out.printf("<p> ServletMapping : %s</p>", req.getHttpServletMapping() );

        out.println("<p>헤더 정보</p>");
        Enumeration<String> names = req.getHeaderNames();
        while (names.hasMoreElements()){
            String s = names.nextElement();

        }
    }
}
