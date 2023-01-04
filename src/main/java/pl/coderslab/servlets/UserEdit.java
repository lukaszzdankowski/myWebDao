package pl.coderslab.servlets;

import pl.coderslab.entity.User;
import pl.coderslab.entity.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user/edit")
public class UserEdit extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String idString = req.getParameter("id");

        try {
            int id = Integer.valueOf(idString);
            User user = UserDao.read(id);

            req.setAttribute("user", user);
            getServletContext().getRequestDispatcher("/users/edit.jsp").forward(req, resp);
        } catch (NumberFormatException e) {
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String idString = req.getParameter("id");
        String username = req.getParameter("username");
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        try {
            int id = Integer.valueOf(idString);
            User user = new User(username,email,password);
            user.setId(id);
            UserDao.update(user);
        } catch (NumberFormatException e) {
        }

        resp.sendRedirect(req.getContextPath() + "/user/list");
    }
}
