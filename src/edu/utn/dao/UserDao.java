package edu.utn.dao;

import java.util.List;
import java.util.Map;

public class UserDao extends DataAccess{

    public UserDao(){

    }

    public int saveNewUser(Map<Integer, Object> parameters) {
        String sql = "INSERT INTO public.user (user_email, user_name, user_lastname, user_birthday, user_gender, user_password) VALUES (?,?,?,?,?,?)";
        return write(sql, parameters);
    }

    public List<Map<String, Object>> getUser(Map<Integer, Object> parameters) {
        String sql = "SELECT * FROM user WHERE id = ?";
        return read(sql, parameters);
    }

}
