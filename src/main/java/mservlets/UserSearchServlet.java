package mservlets;
import models.User;
import store.UserCache;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;
/**
 * Created by Merei on 25.06.2016.
 */
public class UserSearchServlet extends HttpServlet {
    final static UserCache USER_CACHE = UserCache.getInstance();
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String searchUser = request.getParameter("searchUser");
        Collection<User> values = this.USER_CACHE.values();
        for (User user : values) {
            if (user.getLogin().equals(searchUser)) {
                request.setAttribute("search", user);
                request.getRequestDispatcher("/views/user/UserView.jsp").forward(request, response);
                return;
            }
            else {
//                request.setAttribute("else", "Такого клиента в списке нет! ");
                response.sendRedirect(String.format("%s%s", request.getContextPath(), "/user/view"));
            }
        }
    }
}
