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
public class UserCreateServlet extends HttpServlet {

    private final AtomicInteger ids = new AtomicInteger();
    private final UserCache USER_CACHE = UserCache.getInstance();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.USER_CACHE.add(new User(ids.incrementAndGet(), request.getParameter("login"), request.getParameter("email")));
        response.sendRedirect(String.format("%s%s", request.getContextPath(), "/user/view"));
    }
}
