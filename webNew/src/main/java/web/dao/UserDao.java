
package web.dao;

import org.springframework.transaction.annotation.Transactional;
import web.model.User;

import java.beans.Transient;
import java.util.List;

public interface UserDao {

   void addUser(User user);
   List<User> getListOfUsers();

    void updateUser(Long id, User user);
    User getUserId(long id);

    void deleteUserById(long id);

}