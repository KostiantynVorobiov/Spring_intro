package spring.intro.dao.impl;

import java.util.List;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import spring.intro.HibernateUtil;
import spring.intro.dao.UserDao;
import spring.intro.model.User;

public class UserDaoImpl implements UserDao {
    private static final Logger logger = Logger.getLogger(UserDaoImpl.class);

    @Override
    public void add(User user) {
        logger.info("Trying to add user to DB");
        Transaction transaction = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(user);
            transaction.commit();
            logger.info("Added new user " + user.getName() + " successfully");
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new RuntimeException("Can't add user " + user.getName() + " to DB ", e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public List<User> listUsers() {
        logger.info("Trying to get all users from DB");
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<User> userQuery = session.createQuery("FROM User", User.class);
            return userQuery.getResultList();
        } catch (Exception e) {
            throw new RuntimeException("Can't get all users from Db", e);
        }
    }
}
