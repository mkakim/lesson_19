package mservlets;

import store.UserCache;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Merei on 22.06.2016.
 */
public class UserDeleteServlet extends HttpServlet {
    final UserCache USER_CACHE = UserCache.getInstance();
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.USER_CACHE.delete(Integer.valueOf(request.getParameter("id")));
        response.sendRedirect(String.format("%s%s", request.getContextPath(), "/user/view"));
    }
}
