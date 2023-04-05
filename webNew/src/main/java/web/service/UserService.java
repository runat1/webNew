
package web.service;

import org.springframework.transaction.annotation.Transactional;
import web.model.User;

import java.util.List;

public interface UserService {
    @Transactional(readOnly=true)
    void addUser(User user);
    @Transactional(readOnly=true)
    List<User> getListOfUsers();

    @Transactional
    void updateUser(long id, User user);

    @Transactional
    User getUserId(long id);

    @Transactional
    void deleteUserById(long id);
}
