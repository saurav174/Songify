package com.songify.Dao.DaoImpl;


import com.songify.Dao.Interface.LoginDao;
import com.songify.ThirdPartyService.ServiceInterface.PassService;
import com.songify.Utility.BasicUtils;
import com.songify.Utility.SongifyMysqlUtility;
import com.songify.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LoginDaoImpl implements LoginDao {

    @Autowired
    SongifyMysqlUtility songifyMysqlUtility;

    @Autowired
    PassService passService;

    @Override
    public Object getUserWithUserId(Object userId, Object userPassword) {
        String query = "select * from user where userid = '"+userId+"' and password = '"+userPassword+"'";
        User user = (User) songifyMysqlUtility.GetListFromQuery(query).get(0);
        return user;
    }

    @Override
    public boolean saveObject(Object objectToSave) {
        return songifyMysqlUtility.SaveObject(objectToSave);
    }

    @Override
    public boolean updateObject(Object obj) throws Exception {
        return songifyMysqlUtility.SaveOrUpdate(obj);
    }

    @Override
    public boolean saveNewPassword(User user, Object password) {
        String EncPass = passService.encryptPassword(password.toString());
        user.setPassword(EncPass);
        return songifyMysqlUtility.SaveOrUpdate(user);
    }

    @Override
    public List executeNativeMysqlQuery(String queryLogout) {
        List listObj = songifyMysqlUtility.executeNativeMysqlQuery(queryLogout);
        return listObj;
    }

    @Override
    public List getListFromNativeQuery(String queryStr) {
        List listObj = songifyMysqlUtility.executeNativeMysqlQuery(queryStr);
        return listObj;
    }
}
