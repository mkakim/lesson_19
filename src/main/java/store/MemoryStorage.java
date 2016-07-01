package store;

import models.User;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Merei on 29.06.2016.
 */
public class MemoryStorage implements Storage{

    private final AtomicInteger ids = new AtomicInteger();

    private final ConcurrentHashMap<Integer, User> users = new ConcurrentHashMap<>();

    @Override
    public Collection<User> values() {
        return this.users.values();
    }

    @Override
    public int add(final User user) {
        this.users.put(user.getId(), user);
        return user.getId();
    }

    @Override
    public User get(final int id) {
        return this.users.get(id);
    }

    @Override
    public void delete(final int id) {
        this.users.remove(id);
    }

    @Override
    public void edit(final User user) {
        this.users.replace(user.getId(), user);
    }

    @Override
    public User findByLogin(final String login) throws IllegalStateException {
        for (User user : this.users.values()) {
            if (user.getLogin().equals(login)) {
                return user;
            }
        }
        throw new IllegalStateException(String.format("login %s not founds", login));
    }

    @Override
    public int generateId() {
        return ids.incrementAndGet();
    }

    @Override
    public void close() {

    }
}
