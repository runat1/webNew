
package web.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.beans.Transient;
import java.util.List;


@Repository
public class UserDaoImp implements UserDao {

   @PersistenceContext
   private EntityManager entityManager;
   @Override
   public void addUser(User user) {
      entityManager.persist(user);
   }
   @Override
   public List<User> getListOfUsers() {
      return entityManager.createQuery("select user from User user", User.class).getResultList();
   }
   @Override
   public void updateUser(Long id, User user){

      User userOld= getUserId(id);
      userOld.setFirstName(user.getFirstName());
      userOld.setLastName(user.getLastName());
      userOld.setMoselMobail(user.getMoselMobail());

   }
   @Override
   public User getUserId(long id){
      return entityManager.find(User.class, id);
   }
   @Override
   public void deleteUserById(long id) {
      entityManager.remove(getUserId(id));
   }
}
