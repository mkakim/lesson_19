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
public class UserViewServlet extends HttpServlet {
    private final UserCache USER_CACHE = UserCache.getInstance();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("users", this.USER_CACHE.values());
        request.getRequestDispatcher("/views/user/UserView.jsp").forward(request, response);
    }
}
