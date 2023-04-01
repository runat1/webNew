package web.dao;

import web.model.User;

import java.util.ArrayList;
import java.util.List;

public class test {
    private List<User> messages = new ArrayList<>();
   public void addLU(User user){
       messages.add(user);
   }

    public List<User> getCarLimited() {
        return messages;
    }
}
