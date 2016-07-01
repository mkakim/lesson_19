package mservlets;
import models.User;
import store.UserCache;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Merei on 22.06.2016.
 */
public class UserEditServlet extends HttpServlet {

    final UserCache USER_CACHE = UserCache.getInstance();

    final AtomicInteger ids = new AtomicInteger();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.USER_CACHE.edit(new User(this.ids.incrementAndGet(), request.getParameter("login"), request.getParameter("email")));
        response.sendRedirect(String.format("%s%s", request.getContextPath(), "/user/view"));
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("user", this.USER_CACHE.get(Integer.valueOf(request.getParameter("id"))));
        request.getRequestDispatcher("/views/user/UserEdit.jsp").forward(request, response);
    }
}
