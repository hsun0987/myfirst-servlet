package com.example.myfirstservlet.state;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CookieServlet", value = "/cookie")
public class CookieServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 쿠키 : 클라이언트 측에서 저장
        // 서버에 접속할 때 자동으로 요청에 포함되어 전달

        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();

        Cookie cookie =  new Cookie("id", "guest");
        cookie.setMaxAge(60 * 60 *24);
        resp.addCookie(cookie);

        Cookie cookie2 = new Cookie("code", "007");
        cookie2.setPath("/cookie-read");
        resp.addCookie(cookie2);

        out.println("쿠키 전송 완료");
    }
}
