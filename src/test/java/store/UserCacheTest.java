package store;

import models.User;
import org.hamcrest.Matcher;
import org.hamcrest.generator.HamcrestFactoryWriter;
import org.junit.Assert;
import org.junit.Test;
import org.junit.matchers.JUnitMatchers;
import org.mockito.Matchers;
import org.mockito.Mockito;

import static javafx.scene.input.KeyCode.T;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * Created by Merei on 27.06.2016.
 */
public class UserCacheTest {
    @Test
    public void add_test() {
        UserCache cache = Mockito.mock(UserCache.class);

        cache.add(new User(1, "a", "a"));
//        when(cache.get(1)).thenReturn(new User(1, "a", "a"));

    }



}
