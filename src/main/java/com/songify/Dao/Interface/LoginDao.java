package com.songify.Dao.Interface;

import com.songify.entities.User;

import java.util.List;

public interface LoginDao {
    Object getUserWithUserId(Object userId, Object userPassword);

    boolean saveObject(Object objectToSave);

    boolean updateObject(Object obj) throws Exception;

    boolean saveNewPassword(User user, Object password);

    List executeNativeMysqlQuery(String queryLogout);

    List getListFromNativeQuery(String queryStr);

}
