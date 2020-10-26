package edu.utn.dto;

import java.util.HashMap;
import java.util.Map;

import edu.utn.entity.User;

public class UserDto {

    public UserDto(){
        
    }

    public Map<Integer, Object> setParameters(User user){
    int i = 0;
    Map<Integer, Object> parameters = new HashMap<>();
    
    parameters.put(i++, user.getEmail());
    parameters.put(i++, user.getName());
    parameters.put(i++, user.getLastname());
    parameters.put(i++, user.getBirthday());
    parameters.put(i++, user.getGender());
    parameters.put(i++, user.getPassword());

    return parameters;
    }
}
