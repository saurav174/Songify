package com.songify.Dao.DaoImpl;

import com.songify.Dao.Interface.SongifyDao;
import com.songify.entities.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class SongifyDaoImpl implements SongifyDao {

    @Autowired
    SessionFactory sessionFactory;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public List<User> GetAllUsers() {
        List<User> users = sessionFactory.getCurrentSession().createQuery("from User").list();
        return users;
    }

    @Override
    public User GetUserById(String UserId) {
        User user = sessionFactory.getCurrentSession().get(User.class,UserId);
        return user;
    }

    @Override
    public User SaveUser(User user) {
        return null;
    }

    @Override
    public void UpdateUser(String UserId, User user) {
        Session session = sessionFactory.getCurrentSession();
        User OldUser = session.byId(User.class).load(UserId);
        modelMapper.map(OldUser,user);
        session.flush();
    }

    @Override
    public void DeleteUser(String userid) {
        Session session = sessionFactory.getCurrentSession();
        User user = session.byId(User.class).load(userid);
        session.delete(user);
    }
}
