package in.strikes.service;

import in.strikes.model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserService {

    private Map<Integer, User> userDB;

    public UserService() {
        userDB = new HashMap<>();
    }

    public User createUser(User userRequest) {
        userDB.put(userRequest.getId(), userRequest);
        return userRequest;
    }

    public List<User> getAllUsers() {
        return new ArrayList<>(userDB.values());
    }

    public User getUserById(int id) {
        return userDB.getOrDefault(id, null);
    }

    public User updateUser(User userRequest) {
        if (!userDB.containsKey(userRequest.getId())){
            return null;
        }
        userDB.put(userRequest.getId(), userRequest);
        return userRequest;
    }

    public void deleteUser(int id) {
        userDB.remove(id);
    }
}
