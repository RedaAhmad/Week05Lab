package Servlets;

import java.io.IOException;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.HttpSession;

import models.User;

/**
 *
 * @author reda_ *
 */
public class LoginServlet extends HttpServlet {

    @Override

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        String logout = request.getParameter("logout");

        if (logout != null) {

            session.invalidate();

        }

        HttpSession session2 = request.getSession();

        if (session2.getAttribute("username") != null) {

            getServletContext().getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response);

        }

        if (logout != null) {

            String loggedOut = "You have seccessfully logged out.";

            request.setAttribute("message", loggedOut);

            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);

        } 
        else {

            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);

        }

    }

    @Override

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        String uname = request.getParameter("username");

        String passw = request.getParameter("password");

        if (uname != "" && passw != "") {

            if (User.login(uname, passw) == null) {

                String error = "Invalid login";

                request.setAttribute("message", error);

                request.setAttribute("username", uname);

                request.setAttribute("password", passw);

                getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);

            } else {

                session.setAttribute("username", uname);

                response.sendRedirect("http://localhost:8084/Week5Lab_MyLogin/home");

            }

        } else {

            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);

        }

    }
    
}
