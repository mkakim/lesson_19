package store;

import models.User;

import java.util.Collection;

/**
 * Created by Merei on 29.06.2016.
 */
public interface Storage {
    public Collection<User> values();

    public int add(final User user);

    public User get(final int id);

    public void delete(final int id);

    public void edit(final User user);

    public User findByLogin(final String login) throws IllegalStateException;

    public int generateId();

    public void close();

}
