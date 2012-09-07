package name.dohkoos.account.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import name.dohkoos.account.model.User;

public class UserDao {
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public User getUser(String username) {
        Session session = sessionFactory.openSession();
        try {
            Query query = session.createQuery("from User u where u.username = ?");
            query.setString(0, username);
            query.setMaxResults(1);
            return (User)query.uniqueResult();
        } finally {
            session.close();
        }
    }
}
