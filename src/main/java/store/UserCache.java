package store;

import models.User;
import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
/**
 * Created by Merei on 22.06.2016.
 */
public class UserCache implements Storage {
    private static final UserCache INSTANCE = new UserCache();
    public static UserCache getInstance() {
        return INSTANCE;
    }

    private final Storage storage = new MemoryStorage();
    private UserCache() {}

    public Collection<User> values() {
        return this.storage.values();
    }

    public int add(final User user) {
        return this.storage.add(user);
    }

    public void delete(final int id) {
        this.storage.delete(id);
    }

    public void edit(final User user) {
        this.storage.edit(user);
    }

    public User get(final int id) {
        return this.storage.get(id);
    }

    public User findByLogin(final String login) {
        return this.storage.findByLogin(login);
    }

    @Override
    public int generateId() {
        return this.storage.generateId();
    }

    @Override
    public void close() {
        this.storage.close();
    }
}
