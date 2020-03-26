package com.songify.Dao.Interface;

import com.songify.entities.User;

import java.util.List;

public interface SongifyDao {
    List<User> GetAllUsers();
    User GetUserById(String UserId);
    User SaveUser(User user);
    void UpdateUser(String UserId,User user);
    void DeleteUser(String userid);
}
