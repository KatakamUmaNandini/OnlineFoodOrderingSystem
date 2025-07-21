package services;

//import models.User;
import java.util.HashMap;

public class UserService {
    private HashMap<String, String> users = new HashMap<>();

    public boolean register(String username, String password) {
        if (users.containsKey(username)) return false;
        users.put(username, password);
        return true;
    }

    public boolean login(String username, String password) {
        return users.getOrDefault(username, "").equals(password);
    }
}