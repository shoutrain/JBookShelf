package name.dohkoos.account.service;

import name.dohkoos.account.dao.UserDao;
import name.dohkoos.account.model.User;

public class UserService {
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public User getUser(String username) {
        return userDao.getUser(username);
    }

    public void addUser(User user) throws UserAlreadyExistsException {
        User u = getUser(user.getUsername());
        if (u != null) {
            //register.user.already.exists
            throw new UserAlreadyExistsException();
        }
        userDao.addUser(user);
    }
}
