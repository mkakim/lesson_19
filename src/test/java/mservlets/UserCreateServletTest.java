package mservlets;

import org.junit.Test;
import store.UserCache;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * Created by Merei on 26.06.2016.
 */
public class UserCreateServletTest {
    final UserCache USER_CACHE = UserCache.getInstance();

    @Test
    public void createUser() throws ServletException, IOException {
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);

        when(request.getParameter("login")).thenReturn("test");
        when(request.getParameter("email")).thenReturn("test");

        assertTrue(USER_CACHE.values().isEmpty());

        new UserCreateServlet().doGet(request, response);

        verify(request, atLeast(1)).getParameter("login");
        verify(request, atLeast(1)).getParameter("email");

        assertFalse(USER_CACHE.values().isEmpty());

        USER_CACHE.delete(USER_CACHE.findByLogin("test").getId());
    }
}
