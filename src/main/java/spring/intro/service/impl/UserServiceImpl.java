package spring.intro.service.impl;

import java.util.List;
import spring.intro.dao.UserDao;
import spring.intro.dao.impl.UserDaoImpl;
import spring.intro.model.User;
import spring.intro.service.UserService;

public class UserServiceImpl implements UserService {
    UserDao userDao = new UserDaoImpl();

    @Override
    public void add(User user) {
        userDao.add(user);
    }

    @Override
    public List<User> listUsers() {
        return userDao.listUsers();
    }
}
