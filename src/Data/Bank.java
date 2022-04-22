package Data;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private final List<User> users = new ArrayList<>();

    public void addUser(User user){
        users.add(user);
    }

    public String UserList() {
        String userList = "";
        for(User user: users){
            userList += user.toString();
        }
        return userList;
    }

    public User userLogin(String username, String password){
        for(User user: users){
            if(username.equals(user.getUsername()) && password.equals(user.getPassword())){
                return user;
            }
        }
        return null;
    }

    public void transfer(float amount, int accountNumber){
        for(User user: users){
            if(user.getAccount().getAccountNumber() == accountNumber){
                user.getAccount().deposit(amount);
            }
        }
    }

}
