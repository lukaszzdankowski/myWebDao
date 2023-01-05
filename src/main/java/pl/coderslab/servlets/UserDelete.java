package pl.coderslab.servlets;

import pl.coderslab.entity.User;
import pl.coderslab.entity.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user/delete")
public class UserDelete extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String idString = req.getParameter("id");

        try {
            int id = Integer.valueOf(idString);
            User user = UserDao.read(id);

            if (user != null) {
                req.setAttribute("user", user);
                getServletContext().getRequestDispatcher("/users/delete.jsp").forward(req, resp);
            }

            resp.sendRedirect(req.getContextPath() + "/user/list");
        } catch (NumberFormatException e) {
            resp.sendRedirect(req.getContextPath() + "/user/list");
        }
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idString = req.getParameter("id");

        int id = Integer.valueOf(idString);
        UserDao.delete(id);
        resp.sendRedirect(req.getContextPath() + "/user/list");
    }
}
