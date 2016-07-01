package mservlets;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import static org.mockito.Mockito.*;
/**
 * Created by Merei on 26.06.2016.
 */
public class UserSearchServletTest {
    private UserSearchServlet controller;
    @Before
    public void setUp() {
        controller = new UserSearchServlet();
    }
    @Test
    public void searchTest_no_param() throws ServletException, IOException {

        //init
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);

        when(request.getParameter("searchUser")).thenReturn(null);
        //use
        controller.doGet(request, response);

        //check
        verify(response).sendRedirect("/error.jsp");
    }
    @Test
    public void test_yes_param() throws ServletException, IOException {
        //init
        HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
        HttpServletResponse response = Mockito.mock(HttpServletResponse.class);
        when(request.getParameter("searchUser")).thenReturn("user");
        //use
        controller.doGet(request, response);
        //check
        verify(request).getParameter("searchUser");
//        verify(request).getRequestDispatcher("/views/user/UserView.jsp");
    }
}
