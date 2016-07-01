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
public class UserDeleteServletTest {
    final UserCache USER_CACHE = UserCache.getInstance();
    @Test
    public void testDelete() throws ServletException, IOException {
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);

        when(request.getParameter("id")).thenReturn("1");

        assertTrue(this.USER_CACHE.values().isEmpty());

        new UserDeleteServlet().doGet(request, response);

        verify(request, atLeast(1)).getParameter("id");

        assertTrue(this.USER_CACHE.values().isEmpty());


    }
}
